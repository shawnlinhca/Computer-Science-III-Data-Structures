import java.util.*;

import static java.lang.Integer.parseInt;

public class Fibonacci {
     int number;
     int[] arr;
    public Fibonacci(String s){
        number = parseInt(s);
        arr = new int[number];
        arr[0] = 1;
        if(number != 1){
            arr[1] = 1;
            for(int i = 2;i<arr.length;i++){
                arr[i] = arr[i-1] + arr[i-2];
            }
        }
    }
    public int getNum(String s){
        int index = parseInt(s)-1;
        if(index>=0 && index<arr.length){
            return arr[index];
        }
        return -1;
    }
    public String toString(){
       return Arrays.toString(arr);
    }
}