import java.io.*;
import java.util.ArrayList;
/*
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

    static String sorterBookinger(String bookinger){
        String booking = bookinger;
        String dato = booking.substring(0,18);
        String[] tester = booking.split("Time: ");         //Del linjen ved tid

        ArrayList<String> asorteredeTider = new ArrayList<>();
        for (int i = 1; i < tester.length; i++) {           //Tilføj tider men ikke dato (derfor i = 1 og ikke 0)
            asorteredeTider.add(tester[i].trim());          //Tilføj asorterede tider til liste
        }

        ArrayList<String> sorteredeTider = new ArrayList<>();

        while (!asorteredeTider.isEmpty()) {                //Indtil alle asorterede tider er rykket
            String foersteBooking = asorteredeTider.get(0);  //Starter med den første tid
            int foersteBookingIndex = 0;

            for (int i = 1; i < asorteredeTider.size(); i++) {
                String referenceDato = asorteredeTider.get(i);  //Referencedato hentes

                int reference = Integer.parseInt(referenceDato.substring(0, 5).replace(":", ""));     //Sammenlign datoerne som ints
                int foerste = Integer.parseInt(foersteBooking.substring(0, 5).replace(":", ""));

                if (reference < foerste) {                  //Hvis referenceDato er tidligere end nuværende tidligeste tid
                    foersteBooking = referenceDato;         //Bliver første booking sat til nuværende
                    foersteBookingIndex = i;                //Vi henter index på den
                }
            }

            sorteredeTider.add("Time: " + foersteBooking);      //Tilføj tiden til sorterede tider
            asorteredeTider.remove(foersteBookingIndex);        //Fjern den fra asorterede
        }
        String sorteredeBookinger = dato + String.join("\t", sorteredeTider);    //Sæt det sammen
        return sorteredeBookinger;
    }


    static void nyBooking(String booking) throws IOException {
        String date = booking.substring(0,16);                  //Dato på ny booking
        String relevantBooking = "";
        String newBooking = booking.substring(18);              //Ny booking uden dato
        ArrayList<String> bookinger = midlertidigListe();       //Midlertidig liste
        for (String tjek : bookinger){                          //Gå listen igennem
            if (tjek.substring(0,16).equals(date)){             //Find dato
                relevantBooking = tjek;                         //"Hiv" datoen ud
                bookinger.remove(tjek);                         //Fjern datoen fra den midlertidige liste
            }
            relevantBooking = relevantBooking + "\t" + newBooking;
            relevantBooking = sorterBookinger(relevantBooking);
            bookinger.add(relevantBooking);
        }
        while (!bookinger.isEmpty()){
        kalenderPrinter.println(bookinger);
        }
        kalenderPrinter.close();
    }

    static void sletBooking(String booking) throws IOException {            //Man kan ikke redigere direkte i et dokument, så man skal lave en ny liste og slette den gamle
        ArrayList<String> bookinger = midlertidigListe();
              ArrayList<String> bookinger = new ArrayList<>();              //Lav en midlertidig liste med de ting som ikke skal slettes;
        String dato = kalenderReaderBuffed.readLine();
        while (dato != null) {                     //Læs hele filen
            if (!dato.equals(booking)) {           //Tjekker at linjen ikke matcher den som skal slettes
                bookinger.add(dato);               //Hvis den ikke matcher tilføjes den til den midlertidige liste
            }
            dato = kalenderReaderBuffed.readLine();
        }

        bookinger.removeIf(tjek -> tjek.equals(booking));                   //Fjerner nævnte booking

        FileWriter kalenderWriter = new FileWriter("src//Kalender.txt");    //Ikke true, da den opretter det nye, rettede dokument
        PrintWriter kalenderPrinter = new PrintWriter(kalenderWriter);
        for (String string : bookinger) {
            kalenderPrinter.println(string);
        }
        kalenderPrinter.close();
    }
}
*/
