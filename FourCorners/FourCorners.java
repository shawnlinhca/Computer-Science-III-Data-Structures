import java.awt.*;
import javax.swing.*;

public class FourCorners extends JFrame{
    private static final int WIDTH = 1600;
    private static final int HEIGHT = 1600;
    public FourCorners(String framename){
        super(framename);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        add(new FourCornersPanel());
        setVisible(true);
    }
}