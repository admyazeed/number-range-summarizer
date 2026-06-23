import java.util.*;
import numberrangesummarizer.NumberRangeSummarizer;

public class Solution implements NumberRangeSummarizer {

    public ArrayList<Integer> collect(String input) {
        String[] splitInput = input.split(",");
        ArrayList<Integer> collected = new ArrayList<Integer>();

        for (String str : splitInput) {
            try {
                collected.add(Integer.parseInt(str));
            }
            catch {
                System.out.println("Invalid string: " + str);
        }
        }

        return collected;
    }

    public String summarizeCollection(Collection<Integer> input) {
        return "";
    }
}
