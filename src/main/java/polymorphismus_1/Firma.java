package polymorphismus_1;

public class Firma {
    private Mitarbeiter[] mitarbeiter;

    public Firma (Mitarbeiter[] p) {
        mitarbeiter = p;
    }

    public void printFerienReport(){
        for (Mitarbeiter m : mitarbeiter) {
            System.out.println("Mitarbeiter " + m + " hat einen Feriensaldo von  " + m.berechneFerien() + " Tagem");
        }
    }
}
