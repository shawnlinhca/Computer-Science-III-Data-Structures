import java.awt.*;
import java.util.ArrayList;
import java.util.UUID;

public class BingoCard {
    private final String id;
    private static int[][] valueGrid;
    private static boolean[][] pulled;
    private boolean winner = false;
    private static ArrayList<Integer> arr = new ArrayList<>();
    private static ArrayList<Integer> arrnew = new ArrayList<>();
    private static int count = 0;
    public BingoCard(){
        id = String.valueOf(UUID.randomUUID());

        valueGrid =new  int[5][5];
        makeValueGrid();

        pulled = new boolean[5][5];
        pulled[2][2] = true;
    }
    public String toString(){
        return id;
    }
    public boolean checkWinner(){
        if(pulled[0][0] && pulled[0][1] && pulled[0][2] && pulled[0][3] && pulled[0][4]){
            winner = true;
        }

        if(pulled[0][0] && pulled[1][0] && pulled[2][0] && pulled[3][0] && pulled[4][0]){
            winner = true;
        }

        if(pulled[0][0] && pulled[1][1] && pulled[2][2] && pulled[3][3] && pulled[4][4]){
            winner = true;
        }

        if(pulled[4][0] && pulled[3][1] && pulled[2][2] && pulled[1][3] && pulled[0][4]){
            winner = true;
        }

        if(pulled[1][0] && pulled[1][1] && pulled[1][2] && pulled[1][3] && pulled[1][4]){
            winner = true;
        }

        if(pulled[0][1] && pulled[1][1] && pulled[2][1] && pulled[3][1] && pulled[4][1]){
            winner = true;
        }

        if(pulled[2][0] && pulled[2][1] && pulled[2][2] && pulled[2][3] && pulled[2][4]){
            winner = true;
        }

        if(pulled[0][2] && pulled[1][2] && pulled[2][2] && pulled[3][2] && pulled[4][2]){
            winner = true;
        }

        if(pulled[3][0] && pulled[3][1] && pulled[3][2] && pulled[3][3] && pulled[3][4]){
            winner = true;
        }

        if(pulled[0][3] && pulled[1][3] && pulled[2][3] && pulled[3][3] && pulled[4][3]){
            winner = true;
        }

        if(pulled[4][0] && pulled[4][1] && pulled[4][2] && pulled[4][3] && pulled[4][4]){
            winner = true;
        }

        if(pulled[0][4] && pulled[1][4] && pulled[2][4] && pulled[3][4] && pulled[4][4]){
            winner = true;
        }
        return winner;
    }
    public void makeValueGrid(){
        for(int i = 0;i<5;i++) {
            valueGrid[i][0] = getNum();
        }
        for(int i = 0;i<5;i++) {
            valueGrid[i][1] = getNum()+15;


        }
        for(int i = 0;i<5;i++) {
            if(i==2){continue;}
            valueGrid[i][2] = getNum()+30;


        }
        for(int i = 0;i<5;i++) {
            valueGrid[i][3] = getNum() +45;


        }
        for(int i = 0;i<5;i++) {
            valueGrid[i][4] = getNum() + 60;


        }
    }
    public static int getNum(){
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
        int randomi = BingoCardCreationPanel.rand.nextInt(arr.size());
        int out = arr.get(randomi);
        arr.remove(randomi);
        count++;
        return out;
    }
    public void drawBall(int num){
        if(!winner) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (valueGrid[i][j] == num) {
                        pulled[i][j] = true;
                    }
                }
            }
        }
    }
    public void makeBingoCard(Graphics g,int x,int y){
        pulled[2][2] = true;

        g.drawImage(BingoCardCreationPanel.bingocard,x,y,208,242,null);
        /*g.drawRect(300,300,100,20);
        g.drawString("Play Bingo",300,310);*/
        for(int i = 0;i<5;i++) {

            g.drawString(Integer.toString(valueGrid[i][0]), x+10, y+70+(i*40));

        }
        for(int i = 0;i<5;i++) {

            g.drawString(Integer.toString(valueGrid[i][1]), x+50, y+70+(i*40));

        }
        for(int i = 0;i<5;i++) {
            if(i==2){continue;}

            g.drawString(Integer.toString(valueGrid[i][2]),x+ 90, y+70+(i*40));

        }
        for(int i = 0;i<5;i++) {

            g.drawString(Integer.toString(valueGrid[i][3]), x+130, y+70+(i*40));

        }
        for(int i = 0;i<5;i++) {

            g.drawString(Integer.toString(valueGrid[i][4]), x+170, y+70+(i*40));

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
}
