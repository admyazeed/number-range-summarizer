package numberrangesummarizer;

import java.util.*;
import numberrangesummarizer.NumberRangeSummarizer;

public class Solution implements NumberRangeSummarizer {

    @Override
    public Collection<Integer> collect(String input) {
        String[] splitInput = input.split(",");
        Collection<Integer> collected = new TreeSet<>();

        for (String str : splitInput) {
            try {
                collected.add(Integer.parseInt(str.trim()));
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid string in input: " + str);
            }
        }

        return collected;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        List<Integer> nums = new ArrayList<>(input);
        List<String> parts = new ArrayList<>(); // Contains each part of the output string

        if ((input == null) | input.isEmpty()) {
            return "";
        }

        //Initialize
        int start = nums.get(0);
        int end = nums.get(0);
        int prev = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {
            int current = nums.get(i);
            if (current == prev + 1) {
                end = current;
                prev = current;
            } else {
                parts.add(formatPart(start, end));
                start = current;
                end = current;
                prev = current;
            }
        }

        parts.add(formatPart(start, end)); // Add final part
        return String.join(",", parts);
    }

    private String formatPart(int start, int end) {
        if (start == end) {
            return String.valueOf(start);
        } else {
            return start + "-" + end;
        }
    }
}
