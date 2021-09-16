import javax.swing.*;
import java.util.Dictionary;
import java.util.Enumeration;

public class BingoComboBox extends JComboBox
{
    private final Dictionary<String,BingoCard> dictionary = new Dictionary<String, BingoCard>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public Enumeration<String> keys() {
            return null;
        }

        @Override
        public Enumeration<BingoCard> elements() {
            return null;
        }

        @Override
        public BingoCard get(Object key) {
            return null;
        }

        @Override
        public BingoCard put(String key, BingoCard value) {
            return null;
        }

        @Override
        public BingoCard remove(Object key) {
            return null;
        }
    };
    public BingoComboBox(String[] arr){
        super(arr);
        for(int i = 0;i<BingoCardCreationFrame.bingoCards;i++){
            dictionary.put(BingoCardCreationRunner.bingoCards.get(i).toString(),BingoCardCreationRunner.bingoCards.get(i));
        }
    }
    public BingoCard getBingoCard(String s){
        return dictionary.get(s);
    }
}
