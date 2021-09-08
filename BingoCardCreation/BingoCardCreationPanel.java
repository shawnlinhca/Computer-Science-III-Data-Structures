

import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class BingoCardCreationPanel extends JPanel{

    private int count = 0;
    private ArrayList<Integer> arr = new ArrayList<>();
    private ArrayList<Integer> arrnew = new ArrayList<>();
    private BufferedImage bingocard;
    private Random rand = new Random(BingoCardCreationRunner.s);
    public BingoCardCreationPanel(){
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

        for(int i = 0;i<5;i++) {
            g.drawString(Integer.toString(getNum()), 10, 70+(i*40));

        }
        for(int i = 0;i<5;i++) {
            g.drawString(Integer.toString(getNum()+15), 50, 70+(i*40));

        }
        for(int i = 0;i<5;i++) {
            if(i==2){continue;}
            g.drawString(Integer.toString(getNum()+30), 90, 70+(i*40));

        }
        for(int i = 0;i<5;i++) {
            g.drawString(Integer.toString(getNum()+45), 130, 70+(i*40));

        }
        for(int i = 0;i<5;i++) {
            g.drawString(Integer.toString(getNum()+60), 170, 70+(i*40));

        }

    }

}