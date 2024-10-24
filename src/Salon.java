
import java.util.Scanner;


class Salon {
    public static void main(String[] args) {
        bookingSystem system = new bookingSystem();

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.println("Book Her -->");                         // ??
            system.createBooking();
            System.out.println();
            system.displayBookings();

            System.out.println("Vil du afslutte pogrammet (yes/no)");
            String response = sc.nextLine();                                        // Lav substring index 0 - 1
            if (response.equalsIgnoreCase("yes")) {                               // equalsIgnoreCase("y")
                break;
            } else if (response.equals("no")) {                         // equalsIgnoreCase("n")
                system.createBooking();
            } else {
                System.out.println("Svar venligst (yes/no)");
            }                                                           // Det her burde være en switch

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
