public class Rect {
    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;

    public Rect(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public int[] getP1() {
        return new int[] {x1, y1};
    }

    public int[] getP2() {
        return new int[] {x2, y2};
    }

    public int[] getRectValues() {
        return new int[] {x1, y1, x2, y2};
    }
}
