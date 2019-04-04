public class Main {

    static int maxCurrent;

    final static int TOTAL_BATTERY_NO  = 2,
                     TOTAL_MAX_BATTERY = 4711,
                     INPUT_TERMINATOR  = 0;

    static int calculate(int current, int batteries) {
        if (current   == 0) return 0;
        if (current   == 1) return 1;
        if (batteries == 1) return current;

        int minSteps = TOTAL_MAX_BATTERY;

        for (int step = 1; step <= current; step++) {
            int c = 1 + Math.max(
                    calculate(current - step, batteries),
                    calculate(step - 1, batteries - 1)
            );
            minSteps = Math.min(c, minSteps);
        }

        return minSteps;
    }

    public static void main(String[] args) {
        // Initializes Kattis' input/output utility class.
        Kattio io = new Kattio(System.in, System.out);
        StringBuilder sb = new StringBuilder();
        boolean firstLine = true;

        while (io.hasMoreTokens()) {
            // Read the value from input stream.
            // If value equals to input terminator: exit input loop.
            int maxCurrent = io.getInt();
            if (maxCurrent == INPUT_TERMINATOR)
                break;
            if (!firstLine)
                sb.append("\n");

            int result;

            // Test-case for 1 and 2 are known and can be predefined
            if (maxCurrent == 1)
                result = 0;
            else if (maxCurrent == 2)
                result = 1;
            else
                result = calculate(maxCurrent, TOTAL_BATTERY_NO);

            sb.append(result);

            if (firstLine) firstLine = false;
        }
        io.print(sb.toString());
        io.close();
    }
}