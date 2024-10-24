import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
class bookingSystem {
    ArrayList<booking> bookings = new ArrayList<>();

    public void createBooking() {
        Scanner sc = new Scanner(System.in);
        String name = "";
        LocalDate bookingDate = new bookingDato().setBookingDate(sc);
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
    public LocalDate setBookingDate(Scanner sc) {
        LocalDate bookingDate = null;
        int currentYear = LocalDate.now().getYear();

        while (bookingDate == null) {
            System.out.println();
            System.out.println("Book Dato (MM-DD):");

            try {
                String dateInput = sc.nextLine();

                if (dateInput.matches("\\d{2}-\\d{2}")) {                                          //"-" bruges stadig, og er ikke blevet ændret
                    String fullDateInput = currentYear + "-" + dateInput;
                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");  //udprinter i formatet yyyy-MM-dd.
                    bookingDate = LocalDate.parse(fullDateInput, dateFormatter);

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