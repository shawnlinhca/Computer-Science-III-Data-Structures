
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;

public class FourCornersPanel extends JPanel{
    private BufferedImage im1, im2, im3, im4, im1a, im2a, im3a, im4a;
    public FourCornersPanel(){
        try
        {
            im1 = ImageIO.read(new File("FourCorners/Astroworld-1-638x628.jpeg.png"));
            im2 = ImageIO.read(new File("FourCorners/Birds-in-the-Trap-sing-McKnight-1-628x628.jpeg.png"));
            im3 = ImageIO.read(new File("FourCorners/Kodak-Black-music.jpg"));
            im4 = ImageIO.read(new File("FourCorners/lil-uzi-vert-vs-world-2.jpg"));
            im1a = ImageIO.read(new File("FourCorners/Marshall-mathers-LP-1-633x628.jpeg.png"));
            im2a = ImageIO.read(new File("FourCorners/pasted image 0.png"));
            im3a = ImageIO.read(new File("FourCorners/trippie-redd-jpg-4.jpeg"));
            im4a = ImageIO.read(new File("FourCorners/xxxtentacion.jpg"));
        }
    }
    public void paint(Graphics g){

    }
}