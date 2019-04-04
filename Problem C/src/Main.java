import java.util.Arrays;

public class Main {

    final static int TOTAL_MAX_CURRENT = 4711,
                     INPUT_TERMINATOR  = 0;

    public static int[] generate() {
        int[] refTable = new int[TOTAL_MAX_CURRENT + 1];
        Arrays.fill(refTable, TOTAL_MAX_CURRENT);
        refTable[0] = 0;
        refTable[1] = 0;
        for (int i = 2; i <= TOTAL_MAX_CURRENT; i++) {
            for (int j = 1; j < i; j++) {
                int r = 1 + Math.max(
                        j - 1,
                        refTable[i - j]
                );
                refTable[i] = Math.min(refTable[i], r);
            }
        }
        return refTable;
    }

    public static void main(String[] args) {
        // Initializes Kattis' input/output utility class.
        Kattio io = new Kattio(System.in, System.out);
        StringBuilder sb = new StringBuilder();
        int[] referenceTable = generate();

        while(io.hasMoreTokens()) {
            int current = io.getInt();
            if (current != INPUT_TERMINATOR) {
                sb.append(referenceTable[current]);
                sb.append("\n");
            } else {
                break;
            }
        }
        io.print(sb.toString());
        io.close();
    }
}