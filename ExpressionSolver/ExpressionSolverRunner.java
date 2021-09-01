import java.util.*;
import java.io.*;

public class ExpressionSolverRunner {
    public static void main(String []args) throws Exception {
        Scanner scanner = new Scanner(new File("ExpressionSolver/ExpressionSolver.txt"));
        String[] temp;
        String temp1;
        ExpressionSolver e;
        while(scanner.hasNext()){
            temp1 = scanner.nextLine();
            temp = temp1.split(" ");
            e = new ExpressionSolver(temp);
            System.out.println(temp1 + " = " + e.getOut());
        }


    }
}