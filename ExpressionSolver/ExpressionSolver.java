import java.util.*;

import static java.lang.Integer.parseInt;

public class ExpressionSolver {
    ArrayList<String> myArrayList;

    public ExpressionSolver(String[] stringArray){
        myArrayList = new ArrayList<>();
        Collections.addAll(myArrayList, stringArray);
    }

    private void removeSignAndSecondNumber(int i) {
        if (i+2 > myArrayList.size()) {
            return;
        }
        myArrayList.remove(i);
        myArrayList.remove(i);
    }

    private int divide_or_multiple() {
        for(int i = 1; i< myArrayList.size(); i += 2){
            if(myArrayList.get(i).equals("/")){
                myArrayList.set(i-1,Integer.toString(parseInt(myArrayList.get(i-1))/parseInt(myArrayList.get(i+1))));
                return i;
            } else if(myArrayList.get(i).equals("*")){
                myArrayList.set(i-1,Integer.toString(parseInt(myArrayList.get(i-1))*parseInt(myArrayList.get(i+1))));
                return i;
            }
        }
        return 0;
    }

    private int add_or_subtract() {
        for(int i = 1; i< myArrayList.size(); i += 2){
            if(myArrayList.get(i).equals("+")){
                myArrayList.set(i-1,Integer.toString(parseInt(myArrayList.get(i-1))+parseInt(myArrayList.get(i+1))));
                return i;
            } else if(myArrayList.get(i).equals("-")){
                myArrayList.set(i-1,Integer.toString(parseInt(myArrayList.get(i-1))-parseInt(myArrayList.get(i+1))));
                return i;
            }
        }
        return 0;
    }

    private int iterate() {
        int i = divide_or_multiple();
        if (i < 1) {
            i = add_or_subtract();
        }

        if (i > 0) {
            removeSignAndSecondNumber(i);
        }
        return i;
    }

    public int findAnswer(){
        int i;
        while(myArrayList.size() > 1){
            i = iterate();
            if (i < 1) {
                break;
            }
        }

        return parseInt(myArrayList.get(0));
    }
}