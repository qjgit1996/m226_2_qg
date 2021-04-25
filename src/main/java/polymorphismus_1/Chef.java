package polymorphismus_1;

public class Chef extends Mitarbeiter {
    private String abteilung;

    Chef(String abteilung, String name, String vorname, int alter, int personalNummer){
        super(name, vorname, alter, personalNummer);
        this.abteilung = abteilung;
    }

    @Override
    public int berechneFerien() {
        return (int)(basisFerienSaldo() * 1.5);
    }

    @Override
    public String toString() {
        return "Chef{" +
                "abteilung='" + abteilung + '\'' +
                ", name='" + name + '\'' +
                ", vorname='" + vorname + '\'' +
                ", alter=" + alter +
                ", personalNummer=" + personalNummer +
                '}';
    }
}