package vererbung_1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Vererbung {
    public static void main (String args[]) {
        Mitarbeiter m = new Mitarbeiter();
        Chef c = new Chef();
        Fachangestellter f = new Fachangestellter();

        c.abteilung = "Entwicklung";
        c.name = "Hans Müller";

        f.name = "Peter";
        f.vorgesetzter = c;

        List<Mitarbeiter> mitarbeiterList = new ArrayList<>();
        mitarbeiterList.add(c);
        mitarbeiterList.add(f);

        for (Mitarbeiter mitarbeiter : mitarbeiterList) {
            mitarbeiter.printDetails();
            mitarbeiter.name = "Test";
            System.out.println(mitarbeiter.name);
        }
    }
}

