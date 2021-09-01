import java.util.*;

import static java.lang.Integer.parseInt;

public class ExpressionSolver {


     ArrayList<String> al;
    public ExpressionSolver(String[] arr){


        al = new ArrayList<>();
        Collections.addAll(al, arr);
    }
    public int getOut(){
        while(al.size()>1){
            int old = al.size();
            for(int i = 1;i<al.size();i += 2){
                if(al.get(i).equals("/")){
                    al.set(i-1,Integer.toString(parseInt(al.get(i-1))/parseInt(al.get(i+1))));
                    al.remove(i);
                    al.remove(i);
                    break;
                }
                if(al.get(i).equals("*")){
                    al.set(i-1,Integer.toString(parseInt(al.get(i-1))*parseInt(al.get(i+1))));
                    al.remove(i);
                    al.remove(i);
                    break;
                }
            }
            if(al.size()<old){
                continue;
            }
            for(int i = 1;i<al.size();i += 2){
                if(al.get(i).equals("+")){
                    al.set(i-1,Integer.toString(parseInt(al.get(i-1))+parseInt(al.get(i+1))));
                    al.remove(i);
                    al.remove(i);
                    break;
                }
                if(al.get(i).equals("-")){
                    al.set(i-1,Integer.toString(parseInt(al.get(i-1))-parseInt(al.get(i+1))));
                    al.remove(i);
                    al.remove(i);
                    break;
                }
            }

        }


        return parseInt(al.get(0));

    }
}