import java.util.*;
public class ExpressionSolver {
    private int out;
    private String[] in;
    public ExpressionSolver(String[] arr){
        in = arr;
        out = 0;
    }
    public int getOut(){

        List<String> al = new ArrayList<String>();
        al = Arrays.asList(in);
        for(int i = 1;i<al.getSize();i= i+2){
            if(al.get(i).equals("*")){
                al.set(i-1,Integer.toString(Integer.parseInt(al.get(i-1))*Integer.parseInt(al.get(i+1)))) ;
                al.remove(i);
                al.remove(i);
                i = i-2;
            }
            if(al.get(i).equals("/")){
                al.set(i-1,Integer.toString(Integer.parseInt(al.get(i-1))/Integer.parseInt(al.get(i+1)))) ;
                al.remove(i);
                al.remove(i);
                i = i-2;
            }
        }
        for(int i = 1;i<al.getSize();i= i+2){
            if(al.get(i).equals("+")){
                al.set(i-1,Integer.toString(Integer.parseInt(al.get(i-1))+Integer.parseInt(al.get(i+1)))) ;
                al.remove(i);
                al.remove(i);
                i = i-2;
            }
            if(al.get(i).equals("-")){
                al.set(i-1,Integer.toString(Integer.parseInt(al.get(i-1))-Integer.parseInt(al.get(i+1)))) ;
                al.remove(i);
                al.remove(i);
                i = i-2;
            }
        }
        return Integer.parseInt(al.get(0));
    }
}