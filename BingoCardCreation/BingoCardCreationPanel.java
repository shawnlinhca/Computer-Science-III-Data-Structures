import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.*;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
public class BingoCardCreationPanel extends JPanel implements MouseListener, KeyListener {
    private int count = 0;
    private ArrayList<Integer> arr = new ArrayList<>();
    private ArrayList<Integer> arrnew = new ArrayList<>();
    private BufferedImage bingocard;
    private final Random rand = new Random(BingoCardCreationFrame.seed);
    private boolean game = false;
    private final int[][] valueGrid = new int[5][5];
    private final boolean[][] pulled = new boolean[5][5];
    private int ball;
    public void play(){
        int randx = rand.nextInt(15)+1;
        int randy = (rand.nextInt(4)+1)*15;
        ball = randx + randy;
        if(!game){
            for(int i =0;i<5;i++){
                for(int j = 0;j<5;j++){
                    if(valueGrid[i][j] == ball){
                        pulled[i][j] = true;
                    }
                }
            }

            if(pulled[0][0] && pulled[0][1] && pulled[0][2] && pulled[0][3] && pulled[0][4]){
                game = true;
            }

            if(pulled[0][0] && pulled[1][0] && pulled[2][0] && pulled[3][0] && pulled[4][0]){
                game = true;
            }

            if(pulled[0][0] && pulled[1][1] && pulled[2][2] && pulled[3][3] && pulled[4][4]){
                game = true;
            }

            if(pulled[4][0] && pulled[3][1] && pulled[2][2] && pulled[1][3] && pulled[0][4]){
                game = true;
            }

            if(pulled[1][0] && pulled[1][1] && pulled[1][2] && pulled[1][3] && pulled[1][4]){
                game = true;
            }

            if(pulled[0][1] && pulled[1][1] && pulled[2][1] && pulled[3][1] && pulled[4][1]){
                game = true;
            }

            if(pulled[2][0] && pulled[2][1] && pulled[2][2] && pulled[2][3] && pulled[2][4]){
                game = true;
            }

            if(pulled[0][2] && pulled[1][2] && pulled[2][2] && pulled[3][2] && pulled[4][2]){
                game = true;
            }

            if(pulled[3][0] && pulled[3][1] && pulled[3][2] && pulled[3][3] && pulled[3][4]){
                game = true;
            }

            if(pulled[0][3] && pulled[1][3] && pulled[2][3] && pulled[3][3] && pulled[4][3]){
                game = true;
            }

            if(pulled[4][0] && pulled[4][1] && pulled[4][2] && pulled[4][3] && pulled[4][4]){
                game = true;
            }

            if(pulled[0][4] && pulled[1][4] && pulled[2][4] && pulled[3][4] && pulled[4][4]){
                game = true;
            }
        }
        repaint();
    }
    public BingoCardCreationPanel(){
        addMouseListener(this);
        try{
            bingocard = ImageIO.read(Objects.requireNonNull(BingoCardCreationPanel.class.getResource("bingocard.png")));
        }
        catch(Exception E){
            System.out.println("Exception Error");
        }
    }
    public int getNum(){
        if(arr.size()==0) {
            for (int i = 0; i < 15; i++) {
                arr.add(i + 1);
            }
            arrnew = arr;
        }



        if(count == 5){
            count = 0;
            arr = arrnew;
        }
        int randomi = rand.nextInt(arr.size());
        int out = arr.get(randomi);
        arr.remove(randomi);
        count++;
        return out;
    }
    public void makeValueGrid(){
        for(int i = 0;i<5;i++) {
            this.valueGrid[i][0] = getNum();
        }
        for(int i = 0;i<5;i++) {
            this.valueGrid[i][1] = getNum()+15;


        }
        for(int i = 0;i<5;i++) {
            if(i==2){continue;}
            this.valueGrid[i][2] = getNum()+30;


        }
        for(int i = 0;i<5;i++) {
            this.valueGrid[i][3] = getNum() +45;


        }
        for(int i = 0;i<5;i++) {
            this.valueGrid[i][4] = getNum() + 60;


        }
    }
    @Override
    public void paint( Graphics g){

        pulled[2][2] = true;
        g.drawImage(bingocard,0,0,208,242,null);
        g.drawRect(300,300,100,20);
        g.drawString("Play Bingo",300,310);
        for(int i = 0;i<5;i++) {

            g.drawString(Integer.toString(valueGrid[i][0]), 10, 70+(i*40));

        }
        for(int i = 0;i<5;i++) {

            g.drawString(Integer.toString(valueGrid[i][1]), 50, 70+(i*40));

        }
        for(int i = 0;i<5;i++) {
            if(i==2){continue;}

            g.drawString(Integer.toString(valueGrid[i][2]), 90, 70+(i*40));

        }
        for(int i = 0;i<5;i++) {

            g.drawString(Integer.toString(valueGrid[i][3]), 130, 70+(i*40));

        }
        for(int i = 0;i<5;i++) {

            g.drawString(Integer.toString(valueGrid[i][4]), 170, 70+(i*40));

        }
        g.setColor(Color.red);
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
        }

    }
    @Override
    public void mouseClicked(MouseEvent e) {

       if((e.getX()>=300 && e.getX()<=400)&&(e.getY()>=300 && e.getY()<=320)){
           play();
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

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
