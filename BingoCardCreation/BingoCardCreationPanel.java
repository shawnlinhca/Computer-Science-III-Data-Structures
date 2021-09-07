import org.jetbrains.annotations.NotNull;

import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class BingoCardCreationPanel extends JPanel{


    private BufferedImage bingocard;
    public BingoCardCreationPanel(){
        try{
            bingocard = ImageIO.read(Objects.requireNonNull(BingoCardCreationPanel.class.getResource("bingocard.png")));
        }
        catch(Exception E){
            System.out.println("Exception Error");
        }
    }
    @Override
    public void paint(@NotNull Graphics g){
        ArrayList<String> arr = new ArrayList<>(15);
        for(int i = 0;i<15;i++){
            arr.set(i,Integer.toString(i+1));
        }
        g.drawImage(bingocard,0,0,208,242,null);
        Random rand = new Random(BingoCardCreationRunner.s);
        for(int i = 0;i<5;i++) {
            g.drawString(arr.get(rand.nextInt(arr.size())), 10, 70+(i*40));
        }
        for(int i = 0;i<5;i++) {
            g.drawString(Integer.toString(rand.nextInt(15)+16), 50, 70+(i*40));
        }
        for(int i = 0;i<5;i++) {
            if(i==2){continue;}
            g.drawString(Integer.toString(rand.nextInt(15)+31), 90, 70+(i*40));
        }
        for(int i = 0;i<5;i++) {
            g.drawString(Integer.toString(rand.nextInt(15)+46), 130, 70+(i*40));
        }
        for(int i = 0;i<5;i++) {
            g.drawString(Integer.toString(rand.nextInt(15)+61), 170, 70+(i*40));
        }
    }
}