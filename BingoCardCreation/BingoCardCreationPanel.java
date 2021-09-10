

import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class BingoCardCreationPanel extends JPanel implements MouseListener {

    private int count = 0;
    private ArrayList<Integer> arr = new ArrayList<>();
    private ArrayList<Integer> arrnew = new ArrayList<>();
    private BufferedImage bingocard;
    private final Random rand = new Random(BingoCardCreationRunner.s);
    private boolean game = false;
    private int[][] valuegrid = new int[5][5];
    private boolean[][] pulled = new boolean[5][5];

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
    @Override
    public void paint( Graphics g){


        g.drawImage(bingocard,0,0,208,242,null);
        g.drawRect(300,300,100,20);
        g.drawString("Play Bingo",300,310);
        for(int i = 0;i<5;i++) {
            valuegrid[i][0] = getNum();
            g.drawString(Integer.toString(valuegrid[i][0]), 10, 70+(i*40));

        }
        for(int i = 0;i<5;i++) {
            valuegrid[i][1] = getNum()+15;
            g.drawString(Integer.toString(valuegrid[i][1]), 50, 70+(i*40));

        }
        for(int i = 0;i<5;i++) {
            if(i==2){continue;}
            valuegrid[i][2] = getNum()+30;
            g.drawString(Integer.toString(valuegrid[i][1]), 90, 70+(i*40));

        }
        for(int i = 0;i<5;i++) {
            valuegrid[i][3] = getNum() +45;
            g.drawString(Integer.toString(valuegrid[i][3]), 130, 70+(i*40));

        }
        for(int i = 0;i<5;i++) {
            valuegrid[i][4] = getNum() + 60;
            g.drawString(Integer.toString(valuegrid[i][4]), 170, 70+(i*40));

        }

    }


    @Override
    public void mouseClicked(MouseEvent e) {

       if((e.getX(
       )>=300 || e.getX()<=400)&&(e.getY()>=300 || e.getY()<=320)){
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
    public void play(){
        if(!game){

        }
    }
}
