public class Main {

    final static int _EARTHIAN_YEAR = 365,
                     _MARTIAN_YEAR  = 687;

    private static int simulate(int planet1Day, int orbitalYear1,
                                int planet2Day, int orbitalYear2) {
        int day = 0;
        while (true) {
            if (planet1Day == planet2Day &&
                planet1Day == 0) {

                return day;
            }
            planet1Day = (planet1Day == (orbitalYear1 - 1)) ? 0 : planet1Day + 1;
            planet2Day = (planet2Day == (orbitalYear2 - 1)) ? 0 : planet2Day + 1;
            day += 1;
        }
    }

    public static void main(String[] args) {
        // Initializes Kattis' input/output utility class.
        Kattio io = new Kattio(System.in, System.out);
        StringBuilder sb = new StringBuilder();
        int caseNo = 0;
        while (io.hasMoreTokens()) {
            int e = io.getInt();
            int m = io.getInt();
            int days = simulate(e, _EARTHIAN_YEAR, m, _MARTIAN_YEAR);
            caseNo += 1;
            sb.append("Case " + caseNo + ": " + days + "\n");
        }
        io.print(sb.toString());
        io.close();
    }
}