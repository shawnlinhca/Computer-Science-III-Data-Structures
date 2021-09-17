import javax.swing.*;


import static java.lang.Integer.parseInt;

public class BingoCardCreationFrame extends JFrame {
    private static final int WIDTH = 1920;
    private static final int HEIGHT = 1080;
    public static int seed;
    public static int days;
    public static int winners;
    public static int bingoCards;
    public static  JButton ballButton = new JButton();
    public static  JButton cardButton = new JButton();
    public static  JButton winnerButton = new JButton();
    public static  JComboBox<BingoCard> bingobox;

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

        cardButton = new JButton("See Cards");
        cardButton.setSize(300,100);
        cardButton.setLocation(500,700);
        add(cardButton);
        cardButton.setActionCommand("card");
        ballButton = new JButton("See Balls");
        ballButton.setSize(300,100);
        ballButton.setLocation(900,700);
        add(ballButton);
        ballButton.setActionCommand("ball");
        winnerButton = new JButton("See Winners");
        winnerButton.setSize(300,100);
        winnerButton.setLocation(1300,700);
        add(winnerButton);
        winnerButton.setActionCommand("winner");
        BingoCard[] bingoCardArray = BingoCardCreationRunner.bingoCards.toArray(new BingoCard[0]);
        bingobox = new JComboBox<>(bingoCardArray);
        bingobox.setSize(100,10);
        bingobox.setLocation(50,300);
        add(bingobox);
        bingobox.setActionCommand("bingobox");
        bingobox.setEnabled(false);



        BingoCardCreationPanel cardPanel = new BingoCardCreationPanel();
        add(cardPanel);
        setVisible(true);
        setResizable(true);
    }



}