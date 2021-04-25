package vererbung_2;

public class Vererbung {

    public static void main (String args[]) {
        Chef chef = new Chef("Informatik", "Arnold", "Peter", 1024);
        Fachangestellter personal = new Fachangestellter(chef,"Hunziker", "Brigitte", 1001);

        Firma f = new Firma(new Mitarbeiter[] {chef, personal});
    }
}
