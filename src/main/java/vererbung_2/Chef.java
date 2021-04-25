package vererbung_2;

public class Chef extends Mitarbeiter {
    private String abteilung;

    Chef(String abteilung, String name, String vorname, int personalNummer){
        super(name, vorname, personalNummer);
        this.abteilung = abteilung;
    }
}