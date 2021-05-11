package challenge_1;

public class Main {
    public static void main(String[] args) {
        ColoredPoint p1 = new ColoredPoint(1,1,true);
        ColoredPoint p2 = new ColoredPoint(1, 1, true);

        compare(p1,p2);
        compare2(p1,p2);
    }

    private static void compare(Point p1, Point p2) {
        // Was läuft hier falsch?
        // Zeige auf, was hier korrigiert werden muss, so dass die zwei Punkte richtig verglichen werden
        // Diese Methode soll nicht verändert werden!
        System.out.println(p1.equals(p2));
    }

    public static void compare2(ColoredPoint p1, ColoredPoint p2){
        // Das ist nicht die Lösung :-)
        System.out.println(p1.equals(p2));
    }

}
