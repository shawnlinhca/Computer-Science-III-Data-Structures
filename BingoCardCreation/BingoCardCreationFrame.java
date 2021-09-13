import javax.swing.*;
import java.awt.*;
public class BingoCardCreationFrame extends JFrame {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private final BingoCardTextField inputSeed;
    private final BingoCardTextField inputWinners;
    private final BingoCardTextField inputDays;
    public static int seed;
    public static int days;
    public static int winners;
    public BingoCardCreationFrame(String frameName){
        super(frameName);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        BingoCardCreationPanel panel = new BingoCardCreationPanel();
        panel.makeValueGrid();
        inputSeed = new BingoCardTextField();
        inputSeed.getLabel().setText("Enter Game Number");
        inputSeed.setSize(200,60);
        inputSeed.setLocation(300, 340);
        seed = (int) inputSeed.getNumberField().getValue();
        add(inputSeed);
        inputDays = new BingoCardTextField();
        inputDays.getLabel().setText("Enter Number of Days");
        inputDays.setSize(200,60);
        inputDays.setLocation(300, 400);
        days = (int) inputDays.getNumberField().getValue();
        add(inputDays);
        inputWinners = new BingoCardTextField();
        inputWinners.getLabel().setText("Enter Number of Winners");
        inputWinners.setSize(200,60);
        inputWinners.setLocation(300, 460);
        winners = (int) inputWinners.getNumberField().getValue();
        add(inputWinners);
        add(panel);
        setVisible(true);
        setResizable(false);
    }

}