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

        for (int x = 0; x < cellsX; x++) {
            for (int y = 0; y < cellsY; y++) {
                tiles[x][y] = new Tile(x,y);
            }
        }

        double[][] noiseMap = noiseMapGenerator.generateNoiseMap(0, 10, 4, 0.5, 0.5 );
        for (int x = 0; x < cellsX + 1; x++) {
            for (int y = 0; y < cellsY + 1; y++) {
                noiseMap[x][y] = bound(noiseMap[x][y]);
            }
        }

        for (int x = 0; x < cellsX; x++) {
            for (int y = 0; y < cellsY; y++) {
                SPRITE s = SPRITE.fromEdges(getCorners(x, y, noiseMap), random);
                tiles[x][y].setSprite(s);
            }
        }

        double[][] noiseMapD = noiseMapGenerator.generateNoiseMap(1, 10, 4, 0.5, 0.5 );
        for (int x = 0; x < cellsX; x++) {
            for (int y = 0; y < cellsY; y++) {
                noiseMapD[x][y] = noiseMapD[x][y] > 0.7 ?  SPRITEGROUP.DESERT.ordinal() : -1;
            }
        }

        double[][] topMap = noiseMapGenerator.generateNoiseMap(0, 8, 4, 0.4, 0.5);
        for (int x = 0; x < cellsX + 1; x++) {
            for (int y = 0; y < cellsY + 1; y++) {
                topMap[x][y] = boundTopMap(topMap[x][y]);
            }
        }

        conflateWithBoundary(topMap, SPRITEGROUP.AIR, SPRITEGROUP.GRASS);

        for (int x = 0; x < cellsX-1; x++) {
            for (int y = 0; y < cellsY-1; y++) {
                SPRITE s = SPRITE.fromEdges(getCorners(x,y, topMap), random);
                tiles[x][y].setTopSprite(s);
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

    private void conflateWithBoundary(double[][] map, SPRITEGROUP nullGroup ,SPRITEGROUP testGroup) {
        for (int x = 0; x < cellsX-1; x++) {
            for (int y = 0; y < cellsY - 1; y++) {
                if (x == 0 || y == 0) {
                    map[x][y] = nullGroup.ordinal();
                    continue;
                }

                map[x][y] =
                        map[x][y] != 0 &&
                                tiles[x][y].getSprite().getGroup() == testGroup &&
                                tiles[x][y + 1].getSprite().getGroup() == testGroup &&
                                tiles[x + 1][y + 1].getSprite().getGroup() == testGroup &&
                                tiles[x + 1][y].getSprite().getGroup() == testGroup &&
                                tiles[x + 1][y - 1].getSprite().getGroup() == testGroup &&
                                tiles[x][y - 1].getSprite().getGroup() == testGroup &&
                                tiles[x - 1][y - 1].getSprite().getGroup() == testGroup &&
                                tiles[x - 1][y].getSprite().getGroup() == testGroup &&
                                tiles[x - 1][y + 1].getSprite().getGroup() == testGroup
                                ? map[x][y] : nullGroup.ordinal();
            }
        }
    }

    private double bound(double v) {
        if (v < 0.2) { return SPRITEGROUP.DEEPWATER.ordinal(); }
        if (v < 0.35) { return SPRITEGROUP.WATER.ordinal(); }
        if (v > 0.8) { return SPRITEGROUP.ROCK.ordinal(); }
        return SPRITEGROUP.GRASS.ordinal();
    }

    private double boundTopMap(double v) {
        if (v > 0.7) {
            return SPRITEGROUP.TREE.ordinal();
        } else if (v < 0.3) {
            return SPRITEGROUP.TREE_1.ordinal();
        }
        return SPRITEGROUP.AIR.ordinal();
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