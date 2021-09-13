import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static java.lang.Integer.parseInt;

public class BingoCardTextField extends JTextField implements PropertyChangeListener {
    private String s;

    public BingoCardTextField(String s, int i ){
        super(s,i);
    }
    public void propertyChange(PropertyChangeEvent evt) {
        s = evt.getNewValue().toString();

    }
    public int getNum(){
        return parseInt(s);
    }

}
