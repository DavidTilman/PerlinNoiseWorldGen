public class Vector2 {
    private double x, y;

    public Vector2(double a) {
        x = Math.sin(a);
        y = Math.cos(a);
    }

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2 add(Vector2 v) {
        return new Vector2(x + v.x, y + v.y);
    }

    public Vector2 sub(Vector2 v) {
        return new Vector2(x - v.x, y - v.y);
    }

    public Vector2 mul(double k) {
        return new Vector2(x * k, y * k);
    }

    public Vector2 div(double k) {
        return new Vector2(x / k, y / k);
    }

    public static Vector2 random() {
        return new Vector2(Math.random() * 2 * Math.PI);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double dot(Vector2 v) {
        return x * v.getX() + y * v.getY();
    }
}
