import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class BingoCardCreationPanel extends JPanel implements MouseListener, KeyListener, ActionListener {
    public static BufferedImage bingocard;
    public static final Random rand = new Random(BingoCardCreationFrame.seed);
    public BingoCardCreationPanel(){
        addMouseListener(this);
        addKeyListener(this);
        BingoCardCreationFrame.howToUseButton.addActionListener(this);
        BingoCardCreationFrame.seeWinners.addActionListener(this);
        BingoCardCreationFrame.seeBalls.addActionListener(this);
        BingoCardCreationFrame.seeCards.addActionListener(this);
        try{
            bingocard = ImageIO.read(Objects.requireNonNull(BingoCardCreationPanel.class.getResource("bingocard.png")));
        }
        catch(Exception E){
            System.out.println("Exception Error");
        }
    }


    public void paint(Graphics g){
        g.setColor(Color.blue);
        g.fillRect(600,10,600,100);

        g.setColor(Color.black);
        Font currentFont = g.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 5F);
        g.setFont(newFont);
        g.drawString("BINGO SIMULATOR", 620,80);


    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("howToUse")){


            JOptionPane.showMessageDialog(null,"This simulation is automatically run. Cards should be visible after pressing see cards and the winnerFile.txt should have the list of winner IDs and the days and rounds they won in while the ballFile.txt should have the list of balls drawn and on which days and rounds. \nPages of bingo cards to print should be in pngs that can be shown by bingoCards(pg#).png. Press the buttons to view winner Ids in the graphic or balls drawn.");

        }
        else if(e.getActionCommand().equals("balls")){

            try {
                StringBuilder out = new StringBuilder();
                Scanner scanner = new Scanner(new File("C:\\BingoCardFolder\\ballFile.txt"));
                while(scanner.hasNext()){
                    out.append(scanner.nextLine()).append("\n");
                }
                JOptionPane.showMessageDialog(null, out.toString());
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }


        }
        else if(e.getActionCommand().equals("winners")){

            try {
                StringBuilder out = new StringBuilder();
                Scanner scanner = new Scanner(new File("C:\\BingoCardFolder\\winnerFile.txt"));
                while(scanner.hasNext()){
                    out.append(scanner.nextLine()).append("\n");
                }
                JOptionPane.showMessageDialog(null, out.toString());
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

        }
        else if(e.getActionCommand().equals("cards")){
                Graphics g = getGraphics();
                int x = 0;
                int y = 0;
                for(BingoCard card : BingoCardCreationRunner.bingoCards){
                    card.makeBingoCard(g,x*208,y*300+200);
                    g.drawString(card.toString(),x*208,);
                     x++;
                    if(x*208>=1920)x=0;y++;

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
