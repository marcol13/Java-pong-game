import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;

public class IconUtils {

    public static ImageIcon getIconByName(String fileName) {
        InputStream stream = IconUtils.class.getResourceAsStream(fileName);
        try {
            return new ImageIcon((ImageIO.read(stream)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
