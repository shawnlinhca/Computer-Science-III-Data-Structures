import java.util.Arrays;

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
        for(int[] i:m){
            Arrays.fill(i, -1);
        }
        while (filled != FILLED) {
            m[r][c] = ++filled;
            dir = 1;
            changeDir();
        }

    }

    public void changeDir() {
        if (dir == 1) {
            if (r == m.length-1 || m[r+1][c] != -1) {
                dir++;

            }
            else{
                r++;
            }

        }
         if (dir == 2) {
            if (c == m.length-1 || m[r][c+1] != -1) {
                dir++;


            }
            else c++;
        }
         if (dir == 3) {
            if (r== 0 || m[r-1][c] != -1 ) {
                dir++;

            }
            else r--;
        }

            if (dir == 4) {
            if (c == 0 || m[r][c-1] != -1) {
                dir++;

            }
            else c--;
        }
       // System.out.println( r+ " " + c+ " " + filled + " " + dir );
    }

    @Override
    public String toString() {
        String s = "";

        for (int[] e : m) {

            for (int a : e) {
                s += (a + "\t");
            }

            s += ("\n");

        }

        return s;
    }

}