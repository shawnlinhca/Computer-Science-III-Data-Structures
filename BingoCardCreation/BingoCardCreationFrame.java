import javax.swing.*;
import java.awt.*;
public class BingoCardCreationFrame extends JFrame {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private final BingoCardTextField inputSeed;
    private final BingoCardTextField inputWinners;
    private final BingoCardTextField inputDays;

    public BingoCardCreationFrame(String frameName){
        super(frameName);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        BingoCardCreationPanel panel = new BingoCardCreationPanel();
        panel.makeValueGrid();
        inputSeed = new BingoCardTextField("", 10);
        inputSeed.setSize(100,20);
        inputSeed.setLocation(300, 340);
        add(inputSeed);
        inputDays = new BingoCardTextField("", 10);
        inputDays.setSize(100,20);
        inputDays.setLocation(300, 380);
        add(inputDays);
        inputWinners = new BingoCardTextField("", 10);
        inputWinners.setSize(100,20);
        inputWinners.setLocation(300, 420);
        add(inputWinners);
        add(panel);
        setVisible(true);
        setResizable(false);
    }

}