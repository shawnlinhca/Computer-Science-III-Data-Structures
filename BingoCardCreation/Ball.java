import java.util.ArrayList;

public class Ball {
    private final int num;
    private final String column;


    public Ball(int i){
        num = i;

        if(num<16){
            column = "B";
        }
        else if(num<31){
            column = "I";
        }
        else if(num<46){
            column = "N";
        }
        else if(num<61){
            column = "G";
        }
        else {
            column = "O";
        }
    }
    public int getNum(){
        return num;
    }
    public String toString(){
        return column + " - " + num;
    }
}
