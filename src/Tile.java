public class Tile {
    private int x, y;
    private SPRITE sprite = null;
    private SPRITE topSprite = null;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setSprite(SPRITE sprite) {
        this.sprite = sprite;
    }

    public SPRITE getSprite() {
        return sprite;
    }

    public void setTopSprite(SPRITE topSprite) {
        this.topSprite = topSprite;
    }

    public SPRITE getTopSprite() {
        return topSprite;
    }
}
