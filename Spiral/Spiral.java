

public class Spiral {

    int[][] m;

    int r, c, filled, FILLED, dir;

    public Spiral(String s) {

        int length = Integer.parseInt(s);

        m = new int[length][length];
        r = 0;
        c = 0;
        filled = 1;
        FILLED = length * length;
        dir=1;
        while (filled-1 != FILLED) {

            m[r][c] = filled;
            changeDir();
            filled++;


        }

    }

    public void changeDir() {
        //System.out.println( r+ " " + c+ " " + filled + " " + dir );
        if (dir == 1) {
            if (r == m.length-1 || m[r+1][c] != 0) {
                dir++;

            }
            else{
                r++;
            }

        }
        if (dir == 2) {
            if (c == m.length-1 || m[r][c+1] != 0) {
                dir++;


            }
            else c++;
        }
        if (dir == 3) {
            if (r== 0 || m[r-1][c] != 0 ) {
                dir++;

            }
            else r--;
        }

        if (dir == 4) {
            if (c == 0 || m[r][c-1] != 0) {
                dir = 1;
                if (r == m.length-1 || m[r+1][c] != 0) {
                    dir++;

                }
                else{
                    r++;
                }
            }
            else c--;
        }

    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for (int[] e : m) {

            for (int a : e) {
                s.append(a).append("\t");
            }

            s.append("\n");

        }

        return s.toString();
    }

}