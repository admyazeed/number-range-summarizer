import java.util.Collection;
import java.util.Scanner;
import numberrangesummarizer.Solution;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Solution summarizer = new Solution();

        System.out.println("Enter a sequence of numbers separated by comma:\n");
        String input = in.nextLine();
        Collection<Integer> col = summarizer.collect(input);
        System.out.println("Integer collection: " + col);
        System.out.println(
            "Final summarized sequence:\n" + summarizer.summarizeCollection(col)
        );
    }
}
