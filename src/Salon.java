
import java.util.Scanner;


class Salon {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        bookingSystem system = new bookingSystem();

        while (!password.verifyPassword()) {
            // Gentager, indtil den korrekte adgangskode er indtastet
        }

        while (true) {
            System.out.println();
            System.out.println("Book Her -->");
            system.createBooking();
            System.out.println();
            system.displayBookings();
            System.out.println();
            System.out.println("Vil du afslutte pogrammet (yes/no)");

            String response = sc.nextLine().trim();
            // Lav substring index 0 - 1
            if (response.length() > 0) { // sørger for at der mindst er et tegn
                switch (response.substring(0, 1).toLowerCase()) {
                    case "y":
                    case "j":
                        System.out.println("Programmet afsluttes.");
                        return;
                    case "n":
                        System.out.println("programmet køres igen.");
                        break;
                    default:
                        System.out.println("svar venligst (ja/nej)");
                        break;

                }
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
