import java.io.File;
import java.util.*;

public class SpiralRunner{
    public static void main(String []args) throws Exception {
        Scanner input = new Scanner( new File("spiral.txt") );

        while (input.hasNextLine()) {
            System.out.println( new Spiral( input.nextLine() ) );
        }

    }
}