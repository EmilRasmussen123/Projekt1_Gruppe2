import java.io.IOException;
import java.util.Scanner;

  class Menu {

      public static void main(String[] args) throws IOException {


          Scanner scanner = new Scanner(System.in);
          bookingSystem system = new bookingSystem();
          password password = new password();
          kalenderSimpel kalender = new kalenderSimpel();


              while (true) {
                  System.out.println("\n--- Salon Menu ---");
                  System.out.println("1. Opret en booking");
                  System.out.println("2. slet en booking");
                  System.out.println("3. Vis eksisterende bookinger");
                  System.out.println("4. indtast feriedage");
                  System.out.println("5. Afslut");
                  System.out.println("6. Password");
                  System.out.print("Vælg en mulighed (1-6): ");

                  String choice = scanner.nextLine().trim();

                  switch (choice) {
                      case "1":
                          system.createBooking();
                          menuHelper();
                          break;

                      case "2":
                          system.sletBooking();
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
                          kalender.nyBooking();
                          System.exit(0);
                          break;

                      case "6":
                          password.verifyPassword();
                          system.displayBookings();
                          menuHelper();
                          break;

                      default:
                          System.out.println("ugyldigt valg, prøv igen.");
                          break;
                  }
              }
          }
          public static void menuHelper () {
              Scanner scanner = new Scanner(System.in);
              System.out.println();
              System.out.println("Tryk på hvilken som helst knap for at forsætte");
              scanner.nextLine();
          }
      }








