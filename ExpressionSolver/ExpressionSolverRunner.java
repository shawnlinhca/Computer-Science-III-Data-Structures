import java.util.*;
import java.io.*;

public class ExpressionSolverRunner {
    public static void main(String []args) throws Exception {
        Scanner scanner = new Scanner(new File("ExpressionSolver/ExpressionSolver.txt"));
        String[] stringArray;
        String aLine;
        ExpressionSolver solver;
        while(scanner.hasNext()){
            aLine = scanner.nextLine();
            stringArray = aLine.split(" ");
            solver = new ExpressionSolver(stringArray);
            System.out.println(aLine + " = " + solver.findAnswer());
        }


    }
}