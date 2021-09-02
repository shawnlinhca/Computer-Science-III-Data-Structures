

import javax.swing.*;

public class FourCornersFrame extends JFrame{
    private static final int WIDTH = 1920;
    private static final int HEIGHT = 1080;
    public FourCornersFrame(String framename){
        super(framename);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        add(new FourCornersPanel());

        setVisible(true);
    }
}