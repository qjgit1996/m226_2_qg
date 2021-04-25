package polymorphismus_1;

class Fachangestellter extends Mitarbeiter {
    private Chef vorgesetzter;

    Fachangestellter(Chef vorgesetzter, String name, String vorname, int alter, int personalNummer){
        super(name, vorname, alter, personalNummer);
        this.vorgesetzter = vorgesetzter;
    }

    @Override
    public int berechneFerien() {
        return (int)(basisFerienSaldo() * 1.2);
    }

    @Override
    public String toString() {
        return "Fachangestellter{" +
                "name='" + name + '\'' +
                ", vorname='" + vorname + '\'' +
                ", alter=" + alter +
                ", personalNummer=" + personalNummer +
                '}';
    }
}