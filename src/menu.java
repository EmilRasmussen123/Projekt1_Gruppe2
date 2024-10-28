import java.util.Scanner;

public class menu {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        bookingSystem system = new bookingSystem();

        while (!password.verifyPassword()) {
            // Gentager, indtil den korrekte adgangskode er indtastet
        }

        while (true) {
            System.out.println("\n--- Salon Menu ---");
            System.out.println("1. Opret en booking");
            System.out.println("2. slet en booking");
            System.out.println("3. Vis eksisterende bookinger");
            System.out.println("4. indtast feriedage");
            System.out.println("5. Afslut programmet");
            System.out.print("Vælg en mulighed (1-5): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    system.createBooking();
                    menuHelper();
                    break;

                case "2":
                    //System.sletBooking
                    menuHelper();
                    break;

                case "3":
                    system.displayBookings();
                    menuHelper();
                    break;

                case "4":
                    //System.indtastFeriedage
                    menuHelper();
                    break;

                case "5":
                    return;

                default:

                    System.out.println("ugyldigt valg, prøv igen.");
                    break;
            }
        }
    }
    public static void menuHelper(){
        System.out.println();
        System.out.println("Tryk på hvilken som helst knap for at forsætte");
        scanner.nextLine();


    }
}





