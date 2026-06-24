package numberrangesummarizer;

import java.util.*;
import numberrangesummarizer.NumberRangeSummarizer;

public class Solution implements NumberRangeSummarizer {

    public ArrayList<Integer> collect(String input) {
        String[] splitInput = input.split(",");
        ArrayList<Integer> collected = new ArrayList<Integer>();

        for (String str : splitInput) {
            try {
                collected.add(Integer.parseInt(str));
            } catch (Exception e) {
                System.out.println("Invalid string: " + str);
            }
        }

        return collected;
    }

    public String summarizeCollection(Collection<Integer> input) {
        ArrayList<Integer> nums = new ArrayList<Integer>(input);
        String finalString = "";

        if (nums.size() == 0) {
            return "Error: Input is empty. Please ensure provided string contains only numbers separated by commas";
        }

        //Initialize
        int start = nums.get(0);
        int end = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) - nums.get(i - 1) == 1) {
                end = nums.get(i);
            } else {
                if (start != end) {
                    finalString += start + "-" + end + ", ";
                } else {
                    finalString += start + ", ";
                }
                start = nums.get(i);
                end = nums.get(i);
            }
        }

        if (start != end) {
            finalString += start + "-" + end + ", ";
        } else {
            finalString += start + ", ";
        }
        finalString = finalString.substring(0, finalString.length() - 2);
        return finalString;
    }
}
