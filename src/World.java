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

        for (int x = 0; x < cellsX; x++) {
            for (int y = 0; y < cellsY; y++) {
                tiles[x][y] = new Tile(x,y);
            }
        }

        NoiseMapGenerator noiseMapGenerator = new NoiseMapGenerator(cellsX+1, cellsY+1);
        double[][] noiseMap = noiseMapGenerator.generateNoiseMap(0, 10, 4, 0.5, 0.5 );
        for (int x = 0; x < cellsX + 1; x++) {
            for (int y = 0; y < cellsY + 1; y++) {
                noiseMap[x][y] = bound(noiseMap[x][y]);
            }
        }

        for (int x = 0; x < cellsX; x++) {
            for (int y = 0; y < cellsY; y++) {
                SPRITEGROUP[] corners = new SPRITEGROUP[] {
                        SPRITEGROUP.values()[(int)noiseMap[x][y]],
                        SPRITEGROUP.values()[(int)noiseMap[x+1][y]],
                        SPRITEGROUP.values()[(int)noiseMap[x][y+1]],
                        SPRITEGROUP.values()[(int)noiseMap[x+1][y+1]]
                };
                SPRITE s = SPRITE.fromEdges(corners, random);
                tiles[x][y].setSprite(s);

            }
        }

        double[][] topMap = noiseMapGenerator.generateNoiseMap(0, 8, 4, 0.4, 0.5);
        for (int x = 0; x < cellsX + 1; x++) {
            for (int y = 0; y < cellsY + 1; y++) {
                if (topMap[x][y] > 0.7) {
                    topMap[x][y] = 1;
                } else if (topMap[x][y] < 0.3) {
                    topMap[x][y] = 2;
                } else {
                    topMap[x][y] = 0;
                }
            }
        }

        for (int x = 0; x < cellsX-1; x++) {
            for (int y = 0; y < cellsY - 1; y++) {
                if (x == 0 || y == 0) {
                    topMap[x][y] = 0;
                    continue;
                }

                topMap[x][y] =
                        topMap[x][y] != 0 &&
                                tiles[x][y].getSprite().getGroup() == SPRITEGROUP.GRASS &&
                                tiles[x][y + 1].getSprite().getGroup() == SPRITEGROUP.GRASS &&
                                tiles[x + 1][y + 1].getSprite().getGroup() == SPRITEGROUP.GRASS &&
                                tiles[x + 1][y].getSprite().getGroup() == SPRITEGROUP.GRASS &&
                                tiles[x + 1][y - 1].getSprite().getGroup() == SPRITEGROUP.GRASS &&
                                tiles[x][y - 1].getSprite().getGroup() == SPRITEGROUP.GRASS &&
                                tiles[x - 1][y - 1].getSprite().getGroup() == SPRITEGROUP.GRASS &&
                                tiles[x - 1][y].getSprite().getGroup() == SPRITEGROUP.GRASS &&
                                tiles[x - 1][y + 1].getSprite().getGroup() == SPRITEGROUP.GRASS ? topMap[x][y] : 0;
            }
        }

        for (int x = 0; x < cellsX-1; x++) {
            for (int y = 0; y < cellsY-1; y++) {
                Tile[] cornerTiles = new Tile[] {
                        tiles[x][y],
                        tiles[x + 1][y],
                        tiles[x][y + 1],
                        tiles[x + 1][y + 1],
                };
                SPRITEGROUP[] corners = new SPRITEGROUP[4];
                for (int i = 0; i < 4; i++) {
                    switch ((int) topMap[cornerTiles[i].getX()][cornerTiles[i].getY()]) {
                        case 0:
                            corners[i] = SPRITEGROUP.AIR;
                            break;
                        case 1:
                            corners[i] = SPRITEGROUP.TREE;
                            break;
                        case 2:
                            corners[i] = SPRITEGROUP.TREE_1;
                            break;
                    }
                }
                SPRITE s = SPRITE.fromEdges(corners, random);
                tiles[x][y].setTopSprite(s);
            }
        }
    }

    private void bucketFill(int sx, int sy, int v, SPRITE sprite, int[][] bucketMap, boolean[][] explored) {
        if (tiles[sx][sy].getSprite() != sprite) { return; }
        Queue<Tile> queue = new LinkedList<>();
        queue.add(tiles[sx][sy]);
        while (!queue.isEmpty()) {
            Tile tile = queue.remove();
            explored[tile.getX()][tile.getY()] = true;
            if (tile.getSprite() == sprite) {
                bucketMap[tile.getX()][tile.getY()] = v;
                if (tile.getX() > 0) {
                    Tile t = tiles[tile.getX()-1][tile.getY()];
                    if (!explored[t.getX()][t.getY()]) {
                        queue.add(t);
                    }
                }
                if (tile.getX() < cellsX-1) {
                    Tile t = tiles[tile.getX()+1][tile.getY()];
                    if (!explored[t.getX()][t.getY()]) {
                        queue.add(t);
                    }
                }
                if (tile.getY() > 0) {
                    Tile t = tiles[tile.getX()][tile.getY()-1];
                    if (!explored[t.getX()][t.getY()]) {
                        queue.add(t);
                    }
                }
                if (tile.getY() < cellsY-1) {
                    Tile t = tiles[tile.getX()][tile.getY()+1];
                    if (!explored[t.getX()][t.getY()]) {
                        queue.add(t);
                    }
                }
            }
        }
    }



    private double bound(double v) {
        if (v > 0.7) {
            return SPRITEGROUP.ROCK.ordinal();
        } else if (v > 0.3) {
            return SPRITEGROUP.GRASS.ordinal();
        } else if (v > 0.1) {
            return SPRITEGROUP.WATER.ordinal();
        } else if (v >= 0) {
            return SPRITEGROUP.DEEPWATER.ordinal();
        }
        System.out.println(v);
        return -1;
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