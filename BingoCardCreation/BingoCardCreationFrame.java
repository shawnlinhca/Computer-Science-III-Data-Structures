
import javax.swing.*;

public class BingoCardCreationFrame extends JFrame{

    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;

    public BingoCardCreationFrame(String framename){
        super(framename);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        add(new BingoCardCreationPanel());
        setVisible(true);
        setResizable(false);
    }
}