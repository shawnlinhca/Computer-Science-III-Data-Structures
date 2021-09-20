

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

public class BingoCardCreationRunner {

    public static ArrayList<BingoCard> bingoCards = new ArrayList<>();
    public static ArrayList<Integer> winnerIndex = new ArrayList<>();
    public static boolean finished = false;
    public static ArrayList<BingoCard> bingoCards2 = new ArrayList<>();
    public static void main(String[]args)throws IOException{
        BingoCardCreationFrame frame = new BingoCardCreationFrame("Bingo");

        BufferedImage bingoFile = new BufferedImage(1063,1375,BufferedImage.TYPE_INT_ARGB);
        Graphics g = bingoFile.getGraphics();
        File fileFolder = new File("C:\\BingoCardFolder");
        fileFolder.mkdirs();
        int x;
        int y;
        int counter = 0;
        String fileName;
        int winnerCount = 0;
        for(int i = 0;i<BingoCardCreationFrame.bingoCards;i++){
            bingoCards.add(new BingoCard());
        }
        bingoCards2.addAll(bingoCards);
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
                    bingoCards.get(counter).makeBingoCard(g,x,y);
                    counter = counter + 1;
                }
                else if(i==1 ){
                    x=532;
                    y=0;
                    g.drawString(bingoCards.get(counter).toString(),x, y+300);
                    bingoCards.get(counter).makeBingoCard(g,x,y);
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
                    bingoCards.get(counter).makeBingoCard(g,x,y);
                    counter = counter + 1;
                }



            }

            fileName = "C:\\BingoCardFolder\\"+"bingoCards"+j+".png";

            ImageIO.write(bingoFile, "png", new File(fileName));

        }

        PrintWriter winnerOut = new PrintWriter("C:\\BingoCardFolder\\winnerFile.txt");
        winnerOut.println("Winners:");
        PrintWriter ballOut = new PrintWriter("C:\\BingoCardFolder\\ballFile.txt");
        ballOut.println("Balls:");
        ArrayList<Ball> balls = new ArrayList<>();
        ArrayList<Ball> ballsPulled = new ArrayList<>();
        for(int i = 1;i<=75;i++){
            balls.add(new Ball(i));
        }
        ArrayList<String> winnerId = new ArrayList<>();


        int ballcounter = 0;
        int[][] ballsondays = new int[BingoCardCreationFrame.days][2];
        String day = "Monday";
        x = 0;
        y = 0;
        int counterballprint = 0;

        ArrayList<BingoCard> winnerCards = new ArrayList<>();


        while(winnerCards.size()<BingoCardCreationFrame.winners){

            counter = BingoCardCreationPanel.rand.nextInt(balls.size());

            for(int i = 0; i<bingoCards2.size(); i++){

                if(bingoCards2.get(i) == null){continue;}
                bingoCards2.get(i).drawBall(balls.get(counter).getNum());
                bingoCards.get(i).drawBall(balls.get(counter).getNum());
                if(bingoCards2.get(i).checkWinner()){
                    winnerId.add(bingoCards2.get(i).toString());
                    bingoCards.get(i).checkWinner();
                    winnerCards.add(bingoCards2.get(i));
                    winnerCards.get(winnerCount).setBallWon(ballcounter);
                    winnerCount++;
                    bingoCards2.set(i,null);
                    winnerIndex.add(i);

                }

            }
            ballsPulled.add(balls.get(counter));
            balls.remove(counter);
            ballcounter++;
        }

        int averageBalls = ballcounter/(BingoCardCreationFrame.days*2);
        for(int i = 0; i< ballsondays.length; i++){
            for(int j = 0;j<2;j++){
                ballsondays[i][j] = averageBalls;
            }
        }
        if(averageBalls * (BingoCardCreationFrame.days*2) < ballcounter){
            for(int i = 0;i<ballcounter%(BingoCardCreationFrame.days*2);i++){
                ballsondays[x][y] = ballsondays[x][y] + 1;

                if(y == 0)y++;
                else {y = 0;x++;}
            }
        }
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
                ballOut.println(day + "AM"+ ballsPulled.get(counterballprint).toString());
                for (BingoCard winnerCard : winnerCards) {
                    if (counterballprint == winnerCard.getBallWon()) winnerCard.setDayWon(day, "AM");
                }
                counterballprint++;
            }
            for(int j = 0; j< ballsondays[i][1]; j++){
                ballOut.println(day + "PM"+ ballsPulled.get(counterballprint).toString());
                for (BingoCard winnerCard : winnerCards) {
                    if (counterballprint == winnerCard.getBallWon()) winnerCard.setDayWon(day, "PM");
                }
                counterballprint++;
            }
        }
        for(int i = 0; i< winnerCards.size(); i++){
            winnerOut.println(winnerId.get(i)+" " + winnerCards.get(i).getDayWon());
        }
        ballOut.close();
        winnerOut.close();
        finished = true;



    }



}