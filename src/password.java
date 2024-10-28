import java.util.Scanner;

public class password {
    private static String PASSWORD = "hairyharry";

    // Metode der tjekker adgangskoden
    public static boolean verifyPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Indtast adgangskode: ");
        String inputPassword = scanner.nextLine();

        // Tjek om adgangskoden matcher den rigtige
        if (inputPassword.equals(PASSWORD)) {
            System.out.println("Adgangskode korrekt! Programmet starter nu.");
            return true;
        } else {
            System.out.println("Forkert adgangskode. Prøv igen.");
            return false;
        }
    }
}
