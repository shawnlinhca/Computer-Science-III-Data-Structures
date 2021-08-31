import java.util.*;
import java.io.*;
public class FibonacciRunner {
    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(new File("Fibonacci/fibonacci.txt"));

        String[] arr;
        while(input.hasNext()){

            arr = input.nextLine().split(" ",-1);
            Fibonacci f = new Fibonacci(arr[0]);
            for(int i =1;i<arr.length;i++) System.out.println(f.getNum(arr[i]));
            System.out.println("XXXXXX");
        }
    }
}