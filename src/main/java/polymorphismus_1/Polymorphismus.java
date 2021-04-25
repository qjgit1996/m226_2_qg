package polymorphismus_1;

public class Polymorphismus {

    public static void main (String args[]) {
        Chef chef = new Chef("Informatik", "Arnold", "Peter", 50, 1024);
        Fachangestellter personal = new Fachangestellter(chef,"Hunziker", "Brigitte", 50, 1001);

        Firma f = new Firma(new Mitarbeiter[] {chef, personal});

        f.printFerienReport();
    }
}
