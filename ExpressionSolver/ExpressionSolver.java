import java.util.*;

import static java.lang.Integer.parseInt;

public class ExpressionSolver {


     ArrayList<String> al;
    public ExpressionSolver(String[] arr){


        al = new ArrayList<>();
        Collections.addAll(al, arr);
    }
    public int getOut(){
        if(al.size()<2){
            return parseInt(al.get(0));
        }
        for(int i = 1;i<al.size();i+=2){
            if(al.get(i).equals("/")){
                al.set(i-1,Integer.toString(parseInt(al.get(i-1))/parseInt(al.get(i+1))));

                if(al.size()<3){
                    return parseInt(al.get(0));
                }
                al.remove(i);
                al.remove(i);
            }
        }
        for(int i = 1;i<al.size();i+=2){
            if(al.get(i).equals("*")){
                al.set(i-1,Integer.toString(parseInt(al.get(i-1))*parseInt(al.get(i+1))));

                if(al.size()<3){
                    return parseInt(al.get(0));
                }
                al.remove(i);
                al.remove(i);
            }
        }
        for(int i = 1;i<al.size();i+=2){
            if(al.get(i).equals("-")){
                al.set(i-1,Integer.toString(parseInt(al.get(i-1))-parseInt(al.get(i+1))));

                if(al.size()<3){
                    return parseInt(al.get(0));
                }
                al.remove(i);
                al.remove(i);
            }
        }
        for(int i = 1;i<al.size();i += 2){
            if(al.get(i).equals("+")){
                al.set(i-1,Integer.toString(parseInt(al.get(i-1))+parseInt(al.get(i+1))));

                if(al.size()<3){
                    return parseInt(al.get(0));
                }
                al.remove(i);
                al.remove(i);
            }
        }
        return parseInt(al.get(0));

    }
}