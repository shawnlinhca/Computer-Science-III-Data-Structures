import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

public class BingoCardCreationRunner {

    private static ArrayList<Ball> balls;
    private static ArrayList<String> winnerId;
    private static int[][] ballsondays;
    public static ArrayList<BingoCard> bingoCards;

    public static void main(String[]args)throws IOException{

        BingoCardCreationFrame frame = new BingoCardCreationFrame("Bingo");
        BufferedImage bingoFile = new BufferedImage(1063,1375,BufferedImage.TYPE_INT_ARGB);
        Graphics g = bingoFile.getGraphics();

        int x;
        int y;
        int counter = 0;
        String fileName;
        bingoCards = new ArrayList<>();
        for(int i = 0;i<BingoCardCreationFrame.bingoCards;i++){
            bingoCards.add(new BingoCard());
        }
        for(int j = 0;j<(BingoCardCreationFrame.bingoCards/4)+(BingoCardCreationFrame.bingoCards%4);j++) {
            g.clearRect(0,0,1063,1375);
            g.setColor(Color.white);
            g.fillRect(0,0,1063,1375);
            g.setColor(Color.red);
            for (int i = 0; i < 4; i++) {
                if(counter>=BingoCardCreationFrame.bingoCards) break;

                if(i==0 ){
                    x=0;
                    y=0;
                    g.drawString(bingoCards.get(counter).toString(),x, y+300);
                    BingoCardCreationPanel.makeBingoCard(g,x,y, bingoCards.get(counter).getValuearray());
                    counter = counter + 1;
                }
                else if(i==1 ){
                    x=532;
                    y=0;
                    g.drawString(bingoCards.get(counter).toString(),x, y+300);
                    BingoCardCreationPanel.makeBingoCard(g,x,y, bingoCards.get(counter).getValuearray());
                     counter = counter + 1;
                }
                else {
                    if(i==2 ){
                        x=0;
                    }
                    else {
                        x=532;
                    }
                    y=688;
                    g.drawString(bingoCards.get(counter).toString(),x, y+300);
                    BingoCardCreationPanel.makeBingoCard(g,x,y, bingoCards.get(counter).getValuearray());
                    counter = counter + 1;
                }



            }

            fileName = "bingoCards"+j+".png";

            ImageIO.write(bingoFile, "png", new File(fileName));
        }

        balls = new ArrayList<>();
        winnerId = new ArrayList<>();
        int winnerCount = 0;
        counter = 0;
        int ballcounter = 0;
        while(winnerCount < BingoCardCreationFrame.winners){
            balls.add(new Ball());
            if(counter< bingoCards.size()){
                bingoCards.get(counter).drawBall(balls.get(counter).getNum());
                if(bingoCards.get(counter).checkWinner()) {
                    winnerCount++;
                    winnerId.add(bingoCards.get(counter).toString());
                    if(bingoCards.size()>1){
                        bingoCards.remove(counter);
                    }
                    else break;
                }
                else {
                    if(counter == bingoCards.size()-1){
                        counter = 0;
                    }
                    else{
                        counter++;
                    }
                    ballcounter++;
                }
            }
            else break;
        }

        PrintWriter winnerOut = new PrintWriter("winnerFile.txt");
        winnerOut.println("Winners:");
        for(int i = 0; i< BingoCardCreationFrame.winners; i++){
            winnerOut.println(i+1 + " : " + winnerId.get(i));
        }
        winnerOut.close();

        ballsondays = new int[BingoCardCreationFrame.days][2];

        PrintWriter ballOut = new PrintWriter("ballFile.txt");
        ballOut.println("Balls:");
        int averageBalls = ballcounter/(BingoCardCreationFrame.days*2);
        for(int i = 0; i< ballsondays.length; i++){
            for(int j = 0;j<2;j++){
                ballsondays[i][j] = averageBalls;
            }
        }
        x = 0;
        y = 0;
        if(averageBalls * (BingoCardCreationFrame.days*2) < ballcounter){
            for(int i = 0;i<ballcounter%(BingoCardCreationFrame.days*2);i++){
                ballsondays[x][y] = ballsondays[x][y] + 1;
                x++;
                if(y == 0)y++;
                else y = 0;
            }
        }
        String day = null;
        int counterballprint = 0;
        for(int i = 0;i<BingoCardCreationFrame.days;i++){
            if(i ==0){
                day = "Monday";
            }
            if(i ==1){
                day = "Tuesday";
            }
            if(i ==2){
                day = "Wednesday";
            }
            if(i ==3){
                day = "Thursday";
            }
            if(i ==4){
                day = "Friday";
            }
            for(int j = 0; j< ballsondays[i][0]; j++){
                ballOut.println(day + "AM"+ balls.get(counterballprint).toString());
                counterballprint++;
            }
            for(int j = 0; j< ballsondays[i][1]; j++){
                ballOut.println(day + "PM"+ balls.get(counterballprint).toString());
                counterballprint++;
            }
        }
        ballOut.close();



    }



}