import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SpriteSheet {
    private final String path;
    private final int spritesX;
    private final int spritesY;
    private final int spriteSize;
    private BufferedImage image;

    public SpriteSheet(String path, int spritesX, int spritesY, int spriteSize) {
        this.path = path;
        this.spritesX = spritesX;
        this.spritesY = spritesY;
        this.spriteSize = spriteSize;

        try {
            this.image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public int getSpriteSize() {
        return spriteSize;
    }

    public Rect getSourceRect(int spriteIndex) {
        int tlx, tly, brx, bry;

        tlx = (spriteIndex % spritesX)*spriteSize;
        tly = (spriteIndex / spritesX)*spriteSize;
        brx = tlx+spriteSize;
        bry = tly+spriteSize;

        return new Rect(
                tlx, tly,
                brx, bry
        );
    }

    public Image getSprite(int spriteIndex) {
        Rect spriteRect = getSourceRect(spriteIndex);
        int[] rectValues = spriteRect.getRectValues();

        return image.getSubimage(
                rectValues[0], rectValues[1],
                this.getSpriteSize(), this.getSpriteSize()
        );
    }
}
