public class Spiral {

    int m[][];

    int r, c, filled, FILLED, dir;

    public Spiral(String s) {

        int length = Integer.parseInt(s);

        m = new int[length][length];
        r = 0;
        c = 0;
        filled = 0;
        FILLED = length * length;

        while (filled != FILLED) {
            m[r][c] = ++count;



        }

    }

    public void changeDir(){
        if (dir == 1) {
            if(r> m.length)
        }
        if (dir == 2){

        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for (int[] e : m) {

            for (int a : e) {
                s.append(a + '\t');
            }

            s.append('\n');

        }

        return s.toString();
    }

}