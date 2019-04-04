import java.util.HashSet;

public class ProblemA {
   /*   Solution:
        Uses hashmap to identify if the phrase contains duplicates.
        Worst-case time complexity: O(n), where n is the total number of words -
        if all words in the phrase are unique the algorithm will test every single word.
    */

    private HashSet<String> set = new HashSet<>();

    // Answers if the word is repeated by comparing data in the hashset.
    public boolean isRepeated(String word) {
        if (set.contains(word)) {
            return true;
        }
        set.add(word);
        return false;
    }

    public static void main(String[] args) {
        // Initializes Kattis' input/output utility class.
        Kattio io = new Kattio(System.in, System.out);
        ProblemA problemA = new ProblemA();
        String answer = "yes";

        while (io.hasMoreTokens()) {
            if (problemA.isRepeated(io.getWord())) {
                answer = "no";
                break;
            }
        }

        io.println(answer);
        io.close();
    }
}