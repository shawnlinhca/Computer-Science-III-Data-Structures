import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static java.lang.Integer.parseInt;

public class BingoCardTextField extends JPanel {


    public JSpinner getNumberField() {
        return NumberField;
    }

    public void setNumberField(JSpinner numberField) {
        NumberField = numberField;
    }

    public JLabel getLabel() {
        return Label;
    }

    public void setLabel(JLabel label) {
        Label = label;
    }

    private JSpinner NumberField;

    private JLabel Label;

    public BingoCardTextField() {

        NumberField = new JSpinner();
        Label = new JLabel();

        super.add( Label);
        super.add( NumberField);

    }
}
