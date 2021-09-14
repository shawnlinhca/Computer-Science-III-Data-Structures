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
    private static BufferedImage bingocard;
    public static final Random rand = new Random(BingoCardCreationFrame.seed);
    protected  static boolean[][] pulled = new boolean[5][5];
    public BingoCardCreationPanel(){
        addMouseListener(this);
        try{
            bingocard = ImageIO.read(Objects.requireNonNull(BingoCardCreationPanel.class.getResource("bingocard.png")));
        }
        catch(Exception E){
            System.out.println("Exception Error");
        }
    }
    public static void makeBingoCard(Graphics g,int x,int y, int[][] arr){
        pulled[2][2] = true;

        g.drawImage(bingocard,x,y,208,242,null);
        /*g.drawRect(300,300,100,20);
        g.drawString("Play Bingo",300,310);*/
        for(int i = 0;i<5;i++) {

            g.drawString(Integer.toString(arr[i][0]), x+10, y+70+(i*40));

        }
        for(int i = 0;i<5;i++) {

            g.drawString(Integer.toString(arr[i][1]), x+50, y+70+(i*40));

        }
        for(int i = 0;i<5;i++) {
            if(i==2){continue;}

            g.drawString(Integer.toString(arr[i][2]),x+ 90, y+70+(i*40));

        }
        for(int i = 0;i<5;i++) {

            g.drawString(Integer.toString(arr[i][3]), x+130, y+70+(i*40));

        }
        for(int i = 0;i<5;i++) {

            g.drawString(Integer.toString(arr[i][4]), x+170, y+70+(i*40));

        }
        /*g.setColor(Color.red);
        for(int i = 0;i<5;i++){
            for(int j = 0;j<5;j++){
                if(pulled[i][j]){
                    g.fillRect(i*40+5,j*40+40,40,40);
                }
            }
        }
        if(!game){g.setColor(Color.white);
            g.fillRect(400,300,100,10);
            g.setColor(Color.red);
            g.drawString("Ball: " + ball,400,310);}
        if(game){
            g.drawString("BINGO!",300,320);
        }*/
    }
    int pane = 0;
    public void paint(Graphics g){
        if(pane == 0) {
            g.drawRect(100, 400, 200, 75);
            g.drawRect(300, 400, 200, 75);
            g.drawRect(500, 400, 200, 75);
            g.drawString("View Cards", 110, 420);
            g.drawString("View Balls", 310, 420);
            g.drawString("View Winners", 510, 420);
        }
        if(pane == 1){
            for(int i = 0;i<BingoCardCreationFrame.bingoCards;i++){

            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

       if((e.getX()>100 && e.getX()<300)&&(e.getY()>400 && e.getY()<475)){
           pane = 1;
           repaint();
       }
       if((e.getX()>300 && e.getX()<500)&&(e.getY()>400 && e.getY()<475)){
            pane = 2;
            repaint();
       }
       if((e.getX()>500 && e.getX()<700)&&(e.getY()>400 && e.getY()<475)){
            pane = 3;
            repaint();
       }
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


    @Override
    public void keyTyped(KeyEvent e) {
        pane = 0;
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        pane = 0;
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pane = 0;
        repaint();
    }
}
