import java.util.*;

public class SpiralRunner{
    public static void main(String []args) throws Exception {
        Scanner input = new Scanner( new File("sprial.txt") );

        while (input.hasNextLine()) {
            System.out.println( new Spiral( input.nextLine() ) );
        }

    }
}