

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.Objects;


public class FourCornersPanel extends JPanel implements MouseListener {
    private BufferedImage im1, im2, im3, im4, im1a, im2a, im3a, im4a, choicea,choiceb, choicec, choiced;
    public FourCornersPanel(){
        try
        {
            im1 = ImageIO.read(Objects.requireNonNull(FourCornersPanel.class.getResource("/Images/Astroworld-1-628x628.jpeg.png")));
            im2 = ImageIO.read(Objects.requireNonNull(FourCornersPanel.class.getResource("/Images/Birds-in-the-Trap-sing-McKnight-1-628x628.jpeg.png")));
            im3 = ImageIO.read(Objects.requireNonNull(FourCornersPanel.class.getResource("/Images/Kodak-Black-music.jpg")));
            im4 = ImageIO.read(Objects.requireNonNull(FourCornersPanel.class.getResource("/Images/lil-uzi-vert-vs-world-2.jpg")));
            im1a = ImageIO.read(Objects.requireNonNull(FourCornersPanel.class.getResource("/Images/Marshall-Mathers-LP-1-633x628.jpeg.png")));
            im2a = ImageIO.read(Objects.requireNonNull(FourCornersPanel.class.getResource("/Images/pasted image 0.png")));
            im3a = ImageIO.read(Objects.requireNonNull(FourCornersPanel.class.getResource("/Images/trippie-redd-jpg-4.jpeg")));
            im4a = ImageIO.read(Objects.requireNonNull(FourCornersPanel.class.getResource("/Images/xxxtentacion.jpg")));
        }
        catch(Exception E){
            System.out.println("Exception Error");

        }
        choicea =  im1;
        choiceb =  im2;
        choicec =  im3;
        choiced =  im4;
        addMouseListener(this);
    }
    public void paint(Graphics g){
        g.drawImage(choicea,0,0,628,628,null);
        g.drawImage(choiceb,1292,0,628,540,null);
        g.drawImage(choicec,0,702,625,378,null);
        g.drawImage(choiced,1290,540,630,540,null);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if(x>=0&&x<=628&&y>=0&&y<=628){
            choicea = im1a;
        }
        if(x>=1292&&x<=1920&&y>=0&&y<=540){
            choiceb = im2a;
        }
        if(x>=0&&x<=625&&y>=702&&y<=1080){
            choicec = im3a;
        }
        if(x>=1290&&x<=1920&&y>=540&&y<=1080){
            choiced = im4a;
        }
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}