import java.util.HashSet;

public class Main {

    private static HashSet<String> set = new HashSet<>();
    /*
        Answers if the word is repeated by comparing data in the hashset.
    */
    public static boolean isRepeated(String word) {
        if (set.contains(word)) {
            return true;
        }
        set.add(word);
        return false;
    }

    /*
        Uses hashmap to identify if the phrase contains duplicates.
        Worst-case time complexity: O(n), where n is the total number of words -
        if all words in the phrase are unique the algorithm will test every single word.
     */
    public static void main(String[] args) {
        // Initializes Kattis' input/output utility class.
        Kattio io = new Kattio(System.in, System.out);
        String answer = "yes";
        while (io.hasMoreTokens()) {
            if (isRepeated(io.getWord()) == true) {
                answer = "no";
                break;
            }
        }
        io.println(answer);
        io.close();
    }
}