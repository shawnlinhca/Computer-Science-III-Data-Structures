import java.util.Scanner;
public class BingoCardCreationRunner {
    public static int s;
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type seed:");
        s = scanner.nextInt();
        BingoCardCreationFrame frame = new BingoCardCreationFrame("Bingo Card");
    }
}