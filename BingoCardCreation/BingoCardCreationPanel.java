import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.*;
import java.util.Objects;
import java.util.Random;
public class BingoCardCreationPanel extends JPanel implements MouseListener, KeyListener {
    public static BufferedImage bingocard;
    public static final Random rand = new Random(BingoCardCreationFrame.seed);
    protected  static boolean[][] pulled = new boolean[5][5];
    public BingoCardCreationPanel(){
        addMouseListener(this);
        addKeyListener(this);
        try{
            bingocard = ImageIO.read(Objects.requireNonNull(BingoCardCreationPanel.class.getResource("bingocard.png")));
        }
        catch(Exception E){
            System.out.println("Exception Error");
        }
    }


    public void paint(Graphics g){

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
