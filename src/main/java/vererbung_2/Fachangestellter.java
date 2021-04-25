package vererbung_2;

class Fachangestellter extends Mitarbeiter {
    private Chef vorgesetzter;

    Fachangestellter(Chef vorgesetzter, String name, String vorname, int personalNummer){
        super(name, vorname, personalNummer);
        this.vorgesetzter = vorgesetzter;
    }
}