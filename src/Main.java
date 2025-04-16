import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
    public static void main(String[] args) {
        World world = new World(
                new SpriteSheet("assets/SheetMaster.png", 12, 12, 16),
                1900/32,
                1000/32,
                32
        );
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(world.getPixelWidth(), world.getPixelHeight());
        frame.add(world);
        frame.setVisible(true);
    }
}
