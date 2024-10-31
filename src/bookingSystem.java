import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

class bookingSystem {

    static kalenderSimpel kalender = new kalenderSimpel();
    static ArrayList<booking> bookings;

    static {
        try {
            bookings = kalender.bookingerObjektListe();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    ; //liste over bookings

    Set<LocalDate> feriedage = new HashSet<>(); // liste over feriedage

    public bookingSystem() throws IOException {
        // her kan man tilføje feriedage hvis nu harry skal på feriejuleaften fx.

        feriedage.add(LocalDate.of(2024,12,24));
    }

    public void createBooking() {
        Scanner sc = new Scanner(System.in);
        String name = "";
        LocalDate bookingDate = new bookingDato(feriedage).setBookingDate(sc);
        LocalTime bookingTime = new bookingTid().setBookingTime(sc);

        //Tjekker først om bookingdate og bookingtime er ledig for, du kan skrive navnet
        if (isBookingAvailable(bookingDate, bookingTime)){
            System.out.println("Skriv Navnet:");
            while (name.isEmpty()) {
                name = sc.nextLine();
                if (name.isEmpty()) {
                    System.out.println("Du Skal Skrive Navnet.");
                }
            }

            booking newbooking = new booking(name, bookingDate, bookingTime);
            bookings.add(newbooking);

            System.out.println("Booking Tilføjet:");
            System.out.println(newbooking);
        } else {
            System.out.println("Datoen og Tiden er ikke tilgændlig .");
        }
    }

    //Søger for den nye booking ikke matcher den forrige
    private boolean isBookingAvailable(LocalDate bookingDate, LocalTime bookingTime) {
        for (booking booking : bookings) {
            if (booking.bookingDate.equals(bookingDate) && booking.bookingTime.equals(bookingTime)) {
                return false;
            }
        }
        return true;
    }

    public void displayBookings() {
        if (bookings.isEmpty()) {
            System.out.println("Ingen Booking Tilgængelig.");
        } else {
            System.out.println("Alle Bookings:");
            for (booking booking : bookings) {
                System.out.println(booking);
            }
        }
    }
}
//
class bookingDato {
    Set<LocalDate> feriedage;

    public bookingDato(Set<LocalDate> feriedage){
        this.feriedage = feriedage;
    }
    public LocalDate setBookingDate(Scanner sc) {
        LocalDate bookingDate = null;
        int currentYear = LocalDate.now().getYear();

        while (bookingDate == null) {
            System.out.println();
            System.out.println("Book Dato (MM-dd):");

            try {
                String dateInput = sc.nextLine();

                if (dateInput.matches("\\d{2}-\\d{2}")) {                                          //"-" bruges stadig, og er ikke blevet ændret
                    String fullDateInput = currentYear + "-" + dateInput;
                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");  //udprinter i formatet yyyy-MM-dd.
                    bookingDate = LocalDate.parse(fullDateInput, dateFormatter);

                    // Tjekker om dagen er en hverdag
                    DayOfWeek dayOfWeek = bookingDate.getDayOfWeek();
                    if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
                        System.out.println("Bookning er kun tilladt fra mandag til fredag. Prøv igen.");
                        bookingDate = null;
                    } else if (feriedage.contains(bookingDate)) { // Tjekker om dagen er en feriedag
                        System.out.println("Denne dag er en feriedag og kan ikke bookes. Vælg en anden dato.");
                        bookingDate = null;
                    }
                } else{
                    System.out.println("Ugyldig format, venligst re-enter (MM-DD)");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Ugyldig format, venligst re-enter");
            }
        }

        return bookingDate;
    }
}

//
class bookingTid {
    public LocalTime setBookingTime(Scanner sc) {
        LocalTime bookingTime = null;

        while (bookingTime == null) {
            System.out.println("Book Tid (HH:mm):");
            try {
                String inputTime = sc.nextLine();

                if (inputTime.matches("\\d{2}:\\d{2}")) {
                    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
                    bookingTime = LocalTime.parse(inputTime, timeFormatter);

                    // Tjekker, om tiden er inden for åbningstiden og i 30-minutters intervaller
                    if (bookingTime.isBefore(LocalTime.of(10, 0)) || bookingTime.isAfter(LocalTime.of(18, 0))) {
                        System.out.println("Tid skal være mellem 10:00 og 18:00. Prøv igen.");
                        bookingTime = null;
                    } else if (bookingTime.getMinute() != 0 && bookingTime.getMinute() != 30) {
                        System.out.println("Tid skal være i 30 minutters intervaller (f.eks. 10:00, 10:30). Prøv igen.");
                        bookingTime = null;
                    }

                }else {
                    System.out.println("Ugyldig format, venligst re-enter (HH:mm)");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Ugyldig format, venligst re-enter");
            }
        }

        return bookingTime;
    }
}