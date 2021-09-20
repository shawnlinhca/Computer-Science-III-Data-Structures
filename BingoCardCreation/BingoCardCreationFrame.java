import javax.swing.*;


import static java.lang.Integer.parseInt;

public class BingoCardCreationFrame extends JFrame {
    private static final int WIDTH = 1920;
    private static final int HEIGHT = 1080;
    public static int seed;
    public static int days;
    public static int winners;
    public static int bingoCards;


    public static JButton howToUseButton = new JButton("How To Use");
    public static JButton seeWinners = new JButton("See Winners");
    public static JButton seeBalls = new JButton("See Balls");
    public static JButton seeCards = new JButton("See Cards");
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

        howToUseButton.setLocation(0,0);
        howToUseButton.setSize(130,50);
        add(howToUseButton);
        howToUseButton.setActionCommand("howToUse");

        seeWinners.setLocation(0,50);
        seeWinners.setSize(130,50);
        add(seeWinners);
        seeWinners.setActionCommand("winners");

        seeBalls.setLocation(0,100);
        seeBalls.setSize(130,50);
        add(seeBalls);
        seeBalls.setActionCommand("balls");

        seeCards.setLocation(0,150);
        seeCards.setSize(130,50);
        add(seeCards);
        seeCards.setActionCommand("cards");


        BingoCardCreationPanel cardPanel = new BingoCardCreationPanel();
        add(cardPanel);
        setVisible(true);
        setResizable(true);
    }



}