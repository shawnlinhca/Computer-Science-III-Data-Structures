import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.Objects;
import java.util.Random;
public class BingoCardCreationPanel extends JPanel implements MouseListener, KeyListener, ActionListener {
    public static BufferedImage bingocard;
    public static final Random rand = new Random(BingoCardCreationFrame.seed);
    public BingoCardCreationPanel(){
        addMouseListener(this);
        addKeyListener(this);
        BingoCardCreationFrame.cardButton.addActionListener(this);
        BingoCardCreationFrame.ballButton.addActionListener(this);
        BingoCardCreationFrame.winnerButton.addActionListener(this);
        BingoCardCreationFrame.bingobox.addActionListener(this);
        BingoCardCreationFrame.howToUseButton.addActionListener(this);
        try{
            bingocard = ImageIO.read(Objects.requireNonNull(BingoCardCreationPanel.class.getResource("bingocard.png")));
        }
        catch(Exception E){
            System.out.println("Exception Error");
        }
    }

    Graphics graphics;
    public void paint(Graphics g){
        g.setColor(Color.blue);
        g.fillRect(600,10,600,100);

        g.setColor(Color.black);
        Font currentFont = g.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 5F);
        g.setFont(newFont);
        g.drawString("BINGO SIMULATOR", 620,80);

        if(pane.equals("BingoDisplay")){
            g.setColor(Color.blue);
            g.fillRect(810,200,300,300);
            g.drawImage(bingocard, 850,250, 208,242,null);
        }
        graphics = g;
    }

    private String pane = "Main Menu";
    BingoCard currentCard;
    @Override
    public void actionPerformed(ActionEvent e) {
        boolean bingopane = false;
        if(e.getActionCommand().equals("card")){
            BingoCardCreationFrame.bingobox.setVisible(true);
            pane = "BingoDisplay";
            repaint();
            bingopane = true;
        }
        if(e.getActionCommand().equals("bingobox")){
            if(bingopane){
                currentCard = (BingoCard) BingoCardCreationFrame.bingobox.getSelectedItem();
                assert currentCard != null;
               currentCard.makeBingoCard(graphics,850,250);
           }
        }

    }













    @Override
    public void mouseClicked(MouseEvent e) {


    }


    @Override
    public void keyTyped(KeyEvent e) {

    }










    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void mousePressed(MouseEvent e) {

    }
    @Override
    public void mouseReleased(MouseEvent e) {

    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }


}
