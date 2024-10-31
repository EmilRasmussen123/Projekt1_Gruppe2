import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class kalenderSimpel {

    ArrayList<String> midlertidigListe () throws IOException {
        FileReader kalenderReader = new FileReader("src//Kalender.txt");
        BufferedReader kalenderReaderBuffed = new BufferedReader(kalenderReader);
        ArrayList<String> bookinger = new ArrayList<>();              //Lav txt filen til en ArrayListe
        String dato = kalenderReaderBuffed.readLine();
        while (dato != null) {
            bookinger.add(dato);
            dato = kalenderReaderBuffed.readLine();
        }
        return bookinger;
    }

    ArrayList<booking> bookingerObjektListe () throws IOException {
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

    void nyBooking() throws IOException {      //Skal have booking.toString som input
        FileWriter kalenderWriter = new FileWriter("src//Kalender.txt");
        PrintWriter kalenderPrinter = new PrintWriter(kalenderWriter);

        for (booking booking : bookingSystem.bookings){
            kalenderPrinter.println(booking);
        }
        kalenderPrinter.close();
    }
}
