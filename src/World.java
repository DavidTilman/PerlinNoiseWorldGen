import javax.swing.*;
import java.awt.*;
import java.util.*;

public class World extends JPanel {
    private final SpriteSheet spriteSheet;

    private final int cellsX;
    private final int cellsY;

    private final int cellSize;

    private final int pixelWidth;
    private final int pixelHeight;

    private Tile[][] tiles;

    Random random = new Random(0);

    public World(SpriteSheet spriteSheet, int cellsX, int cellsY, int cellSize) {
        this.spriteSheet = spriteSheet;
        this.cellsX = cellsX;
        this.cellsY = cellsY;
        this.cellSize = cellSize;
        this.pixelWidth = cellSize * cellsX;
        this.pixelHeight = cellSize * cellsY;
        this.tiles = new Tile[cellsX][cellsY];

        NoiseMapGenerator noiseMapGenerator = new NoiseMapGenerator(cellsX+1, cellsY+1);
        Random rand = new Random();

        for (int x = 0; x < cellsX; x++) {
            for (int y = 0; y < cellsY; y++) {
                tiles[x][y] = new Tile(x,y);
            }
        }

        double[][] noiseMap = noiseMapGenerator.generateNoiseMap(0, 8, 4, 0.5, 0.5);
        for (int x = 0; x < cellsX+1; x++) {
            for (int y = 0; y < cellsY+1; y++) {
                double noise = noiseMap[x][y];
                if (noise > 0.7) { noiseMap[x][y] = SPRITEGROUP.SHALLOW.ordinal(); continue; }
                if (noise > 0.5) { noiseMap[x][y] = SPRITEGROUP.BEACH.ordinal(); continue; }
                noiseMap[x][y] = SPRITEGROUP.GRASS.ordinal();
            }
        }
        for (int x = 0; x < cellsX; x++) {
            for (int y = 0; y < cellsY; y++) {
                SPRITEGROUP[] corners = getCorners(x,y, noiseMap);
                SPRITE s = SPRITE.fromEdges(corners, rand);
                tiles[x][y].setSprite(s);
            }
        }
    }

    private SPRITEGROUP[] getCorners(int x, int y, double[][]noiseMap) {
        SPRITEGROUP[] corners = new SPRITEGROUP[] {
                SPRITEGROUP.values()[(int)noiseMap[x][y]],
                SPRITEGROUP.values()[(int)noiseMap[x+1][y]],
                SPRITEGROUP.values()[(int)noiseMap[x][y+1]],
                SPRITEGROUP.values()[(int)noiseMap[x+1][y+1]]
        };
        return corners;
    }

    public int getPixelHeight() {
        return pixelHeight;
    }

    public int getPixelWidth() {
        return pixelWidth;
    }

    public Rect getCellRect(int x, int y) {
        return new Rect(x * cellSize, y * cellSize, (x+1) * cellSize, (y+1) * cellSize);
    }

    public void drawSprite(Graphics g, Tile tile) {
        SPRITE sprite = tile.getSprite();
        if (sprite == null) { return; }
        Image spriteImage = spriteSheet.getSprite(sprite.i);
        Rect rect = getCellRect(tile.getX(), tile.getY());
        g.drawImage(spriteImage, rect.getX1(), rect.getY1(), cellSize, cellSize, null);

        SPRITE topSprite = tile.getTopSprite();
        if (topSprite == null) { return; }
        Image topSpriteImage = spriteSheet.getSprite(topSprite.i);
        g.drawImage(topSpriteImage, rect.getX1(), rect.getY1(), cellSize, cellSize, null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int x = 0; x < cellsX; x++) {
            for (int y = 0; y < cellsY; y++) {
                drawSprite(g, tiles[x][y]);
            }
        }
    }
}