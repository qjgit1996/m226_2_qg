package polymorphismus_1;

public abstract class Mitarbeiter {
    protected String name;
    protected String vorname;
    protected int alter;
    protected int personalNummer;

    Mitarbeiter(String name, String vorname, int alter, int personalNummer) {
        this.name = name;
        this.vorname = vorname;
        this.alter = alter;
        this.personalNummer = personalNummer;

    }

    protected final int basisFerienSaldo(){
        if(alter > 30) {
            return 25;
        } else{
            return 20;
        }
    }
    // BerechneFerien wurde abgeändert von
    // public abstract int berechneFerien(int alter);
    // zu:
    // public abstract int berechneFerien();
    // Das alter ist jetzt eine Instanzvariable

    public abstract int berechneFerien();

    public final int berechneFerien(int bonus){
        return berechneFerien() + bonus;
    }

    @Override
    public String toString() {
        return "Mitarbeiter{" +
                "name='" + name + '\'' +
                ", vorname='" + vorname + '\'' +
                ", alter=" + alter +
                ", personalNummer=" + personalNummer +
                '}';
    }
}


