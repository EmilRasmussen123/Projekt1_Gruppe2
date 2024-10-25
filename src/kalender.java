import java.io.*;
import java.util.ArrayList;

public class kalender {                 //Metoderne er static, så man skal ikke oprette et kalender objekt for at bruge metoderne
    static FileWriter kalenderWriter;  // Writer - true -> tilføj til eksisterende dokument, null -> erstat gamle dokument
    static {
        try {
            kalenderWriter = new FileWriter("src//Kalender.txt", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static PrintWriter kalenderPrinter = new PrintWriter(kalenderWriter);     // Writer til at behandle dokument som konsol

    static FileReader kalenderReader;       // Læser filen
    static {
        try {
            kalenderReader = new FileReader("src//Kalender.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    static BufferedReader kalenderReaderBuffed = new BufferedReader(kalenderReader);       // Lader FileReader læse linjer i stedet for enkelte tegn

    public kalender() throws IOException {
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


    static void nyBooking(String booking) {
        kalenderPrinter.println(booking);
        kalenderPrinter.close();
    }

    static void sletBooking(String booking) throws IOException {            //Man kan ikke redigere direkte i et dokument, så man skal lave en ny liste og slette den gamle
        ArrayList<String> bookinger = midlertidigListe();
        /*        ArrayList<String> bookinger = new ArrayList<>();              //Lav en midlertidig liste med de ting som ikke skal slettes;
        String dato = kalenderReaderBuffed.readLine();
        while (dato != null) {                     //Læs hele filen
            if (!dato.equals(booking)) {           //Tjekker at linjen ikke matcher den som skal slettes
                bookinger.add(dato);               //Hvis den ikke matcher tilføjes den til den midlertidige liste
            }
            dato = kalenderReaderBuffed.readLine();
        }  */

        for (String tjek : bookinger){

        }

        FileWriter kalenderWriter = new FileWriter("src//Kalender.txt");    //Ikke true, da den opretter det nye, rettede dokument
        PrintWriter kalenderPrinter = new PrintWriter(kalenderWriter);
        for (String string : bookinger) {
            kalenderPrinter.println(string);
        }
        kalenderPrinter.close();
    }
}
