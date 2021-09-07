import java.awt.*;
import javax.swing.*;

public class BingoCardCreationFrame extends JFrame{

    private static final int WIDTH = 208;
    private static final int HEIGHT = 242;

    public BingoCardCreationFrame(String framename){
        super(framename);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        add(new BingoCardCreationPanel());
        setVisible(true);
    }
}