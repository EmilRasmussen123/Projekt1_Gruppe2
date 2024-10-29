import java.io.*;
import java.util.ArrayList;

public class kalenderSimpel {
    static FileWriter kalenderWriter;
    static {
        try {
            kalenderWriter = new FileWriter("src//Kalender.txt", true);       //Writer - true -> tilføj til eksisterende dokument, null -> erstat gamle dokument
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static PrintWriter kalenderPrinter = new PrintWriter(kalenderWriter);     //Writer til at behandle dokument som konsol

    static FileReader kalenderReader;                                         // Læser filen
    static {
        try {
            kalenderReader = new FileReader("src//Kalender.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    static BufferedReader kalenderReaderBuffed = new BufferedReader(kalenderReader);       //Lader FileReader læse linjer i stedet for enkelte tegn

    public kalenderSimpel() throws IOException {                                        //Konstruktør
    }

    static ArrayList<String> midlertidigListe () throws IOException {
        ArrayList<String> bookinger = new ArrayList<>();              //Lav en midlertidig liste
        String dato = kalenderReaderBuffed.readLine();
        while (dato != null) {
            bookinger.add(dato);
            dato = kalenderReaderBuffed.readLine();
        }
        return bookinger;
    }

    static void nyBooking(String booking) throws IOException {
        kalenderPrinter.println(booking);
        kalenderPrinter.close();
    }

    static void sletBooking(String booking) throws IOException {            //Man kan ikke redigere direkte i et dokument, så man skal lave en ny liste og slette den gamle
        ArrayList<String> bookinger = midlertidigListe();
        bookinger.removeIf(tjek -> tjek.equals(booking));                   //Fjerner nævnte booking

        FileWriter kalenderWriter = new FileWriter("src//Kalender.txt");    //Ikke true, da den opretter det nye, rettede dokument
        PrintWriter kalenderPrinter = new PrintWriter(kalenderWriter);
        for (String string : bookinger) {
            kalenderPrinter.println(string);
        }
        kalenderPrinter.close();
    }

    static String dato(String booking) throws IOException {
        ArrayList<String> bookinger = new ArrayList<>();              //Lav en midlertidig liste
        String dato = kalenderReaderBuffed.readLine();
        while (dato != null) {
            if (booking.substring(0,16).equals(dato.substring(0,16))) {     //Hvis datoen matcher
                bookinger.add(dato.substring(18));                          //Så tilføj booking til en liste
            }
            dato = kalenderReaderBuffed.readLine();
        }
        return dato + String.join("\t",bookinger);
    }
}
