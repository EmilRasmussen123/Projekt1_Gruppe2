package Project_1;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Salon {
    public static void main(String[] args) {
        bookingSystem system = new bookingSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nNy Booking? (yes/no)");
            String response = sc.nextLine().toLowerCase();

            if (response.equals("yes")) {
                system.createBooking();
            } else if (response.equals("no")) {
                break;
            } else {
                System.out.println("Svar venligst (yes/no)");
            }
        }

        system.displayBookings();
    }
}

class booking {
    String name;
    LocalDate bookingDate;
    LocalTime bookingTime;

    booking(String name, LocalDate bookingDate, LocalTime bookingTime) {
        this.name = name;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
    }

    public String toString() {
        return "Name: " + name + ", Date: " + bookingDate + ", Time: " + bookingTime;
    }


}

class bookingSystem {
    ArrayList<booking> bookings = new ArrayList<>();

    public void createBooking() {
        Scanner sc = new Scanner(System.in);
        LocalDate bookingDate = null;
        LocalTime bookingTime = null;
        String name = "";
        int currentYear = LocalDate.now().getYear();
        
        //While loopen for at book en dato
        while (bookingDate == null) {
            System.out.println();
            System.out.println("Book Dato (DD-MM):");
            try {
                String dateInput = sc.nextLine();

                if (dateInput.matches("\\d{2}-\\d{2}")) {
                    dateInput = currentYear + "-" + dateInput;
                }

                bookingDate = LocalDate.parse(dateInput);
            } catch (DateTimeParseException e) {
                System.out.println("Ugyldig format, venligst re-enter");
            }
        }

        //While loopen for at book en tid
        while (bookingTime == null) {
            System.out.println("Book Tid (HH:mm):");
            try {
                String inputTime = sc.nextLine();

                if (inputTime.matches("\\d{2}:\\d{2}")) {
                    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
                    bookingTime = LocalTime.parse(inputTime, timeFormatter);
                } else {
                    System.out.println("Ugyldig format, venligst re-enter (HH:mm)");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Ugyldig format, venligst re-enter");
            }
        }
        
        //Tjekker hvis navn, dato og tid er optaget
        if (isBookingAvailable(bookingDate, bookingTime)) {
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
    
    //Hvis den nye booking matcher den forrige
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


/*
//Der er problemer med denne class
class calender extends booking{



    public String toCSV(){
        return name + "," + bookingDate + "," + bookingTime;
    }

    public static booking fromCSV(String csvLine){
        String[] parts =csvLine.split(",");
        String name = parts[0];
        LocalDate date = LocalDate.parse(parts[1]);
        LocalTime time = LocalTime.parse(parts[2]);

        return new booking(name,date,time);
    }

    //Der er problemer med denne kode
    public void saveBooking(){
        try(PrintWriter writer = new PrintWriter(new FileWriter(filepath)){
            for(booking booking : bookings){
                writer.println(booking.toCSV());
            }
            System.out.println("Bookings Er Gemt Til " + filepath);

        }catch(IOException e){
            System.out.println("Noget Gik Galt " + e.getMessage());

        }
    }

    //Der er problemer med denne kode
    public void loadBookings(){
        try(BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null){
                booking booking = booking.fromCSV(line);
                bookings.add(booking);
            }
            System.out.println("tekst");
        }catch (IOException e){
            System.out.println();
        }
    }
    
}

class date{



}
*/
