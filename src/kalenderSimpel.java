import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
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

    //MIDLERTIDIGLISTE TØMMER AF EN ELLER ANDEN GRUND KALENDEREN NÅR MAN BRUGER DEN
    //VED BRUG AF MIDLERTIDIGLISTE SKAL DER ALTID SKRIVES ET NYT DOKUMENT
    static ArrayList<String> midlertidigListe () throws IOException {
        ArrayList<String> bookinger = new ArrayList<>();              //Lav txt filen til en ArrayListe
        String dato = kalenderReaderBuffed.readLine();
        while (dato != null) {
            bookinger.add(dato);
            dato = kalenderReaderBuffed.readLine();
        }
        return bookinger;
    }

    static ArrayList<booking> bookingerObjektListe () throws IOException {
        ArrayList<String> stringListe = midlertidigListe();
        ArrayList<booking> objektListe = new ArrayList<>();             //Liste af objekter

        for (String tjek : stringListe){                                //For hele listen
            try {
            String name = tjek.split("Name:")[1].trim();                   //Find navnet
            LocalDate bookingDato = LocalDate.parse(tjek.substring(6,16)); //Find datoen
            LocalTime bookingTid = LocalTime.parse(tjek.substring(24,29)); //Find tiden
            booking bookingFraListe = new booking(name, bookingDato, bookingTid);   //Opret en booking
            objektListe.add(bookingFraListe);                           //Tilføj til listen
        } catch (Exception e) {
                throw new RuntimeException(e);
            }
            }
        return objektListe;
    }       //Skal tilføjes bookingsystem, linje 10 - ArrayList<booking> bookings = kalenderSimpel.bookingObjektListe;

    static void nyBooking() throws IOException {      //Skal have booking.toString som input
        kalenderWriter = new FileWriter("src//Kalender.txt");
        for (booking booking : bookingSystem.bookings){
            kalenderPrinter.println(booking);
        }
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
        ArrayList<String> bookinger = new ArrayList<>();                    //Lav en midlertidig liste
        String dato = kalenderReaderBuffed.readLine();
        while (dato != null) {
            if (booking.substring(5,16).equals(dato.substring(5,16))) {     //Hvis datoen matcher
                bookinger.add(dato.substring(18));                          //Så tilføj booking til en liste
            }
            dato = kalenderReaderBuffed.readLine();
        }
        return booking.substring(0,16)+",\t" + String.join("     ",bookinger);
    }

}
