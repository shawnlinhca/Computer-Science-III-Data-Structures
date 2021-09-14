import javax.swing.*;


import static java.lang.Integer.parseInt;

public class BingoCardCreationFrame extends JFrame {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    public static int seed;
    public static int days;
    public static int winners;
    public static int bingoCards;

    public BingoCardCreationFrame(String frameName){
        super(frameName);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);


        JOptionPane seedInput = new JOptionPane();
        add(seedInput);
        seed = parseInt(JOptionPane.showInputDialog(seedInput,"Enter game number"));

        JOptionPane daysInput = new JOptionPane();
        add(daysInput);
        days = parseInt(JOptionPane.showInputDialog(daysInput,"Enter number of days"));

        JOptionPane winnersInput = new JOptionPane();
        add(winnersInput);
        winners = parseInt(JOptionPane.showInputDialog(winnersInput,"Enter number of winners"));

        JOptionPane bingoCardsInput = new JOptionPane();
        add(bingoCardsInput);
        bingoCards = parseInt(JOptionPane.showInputDialog(bingoCardsInput,"Enter number of bingo cards you want to create"));

        BingoCardCreationPanel panel = new BingoCardCreationPanel();
        add(panel);

        setVisible(true);
        setResizable(false);
    }



}