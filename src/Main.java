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
                new SpriteSheet("assets/punyworld-overworld-tileset.png", 27, 65, 16),
                1900/16,
                1000/16,
                16
        );
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(world.getPixelWidth(), world.getPixelHeight());
        frame.add(world);
        frame.setVisible(true);
    }
}
