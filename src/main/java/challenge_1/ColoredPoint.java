package challenge_1;

import java.util.Objects;

public class ColoredPoint extends Point{
    private boolean isRed;

    public ColoredPoint(int x, int y, boolean isRed) {
        super(x, y);
        this.isRed = isRed;

    }

    public boolean isRed() {
        return isRed;
    }

    @Override
    public boolean equals(Object o) {
        if(!super.equals(o)) return false;
        ColoredPoint that = (ColoredPoint) o;
        return isRed == that.isRed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isRed);
    }
}