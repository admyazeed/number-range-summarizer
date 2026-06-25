package numberrangesummarizer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private Solution summarizer;

    @BeforeEach
    void setUp() {
        summarizer = new Solution();
    }

    // =====================================================
    // collect() tests
    // =====================================================

    @Test
    void collect_ValidInput_ReturnsCollection() {
        Collection<Integer> result = summarizer.collect("1,2,3");

        assertEquals(Set.of(1, 2, 3), result);
    }

    @Test
    void collect_ContainsWhitespace_TrimsValues() {
        Collection<Integer> result = summarizer.collect(" 1, 2 , 3 ");

        assertEquals(Set.of(1, 2, 3), result);
    }

    @Test
    void collect_ContainsDuplicates_RemovesDuplicates() {
        Collection<Integer> result = summarizer.collect("1,2,2,3,3");

        assertEquals(Set.of(1, 2, 3), result);
    }

    @Test
    void collect_UnsortedInput_ReturnsSortedCollection() {
        Collection<Integer> result = summarizer.collect("5,1,4,2,3");

        assertIterableEquals(List.of(1, 2, 3, 4, 5), result);
    }

    @Test
    void collect_ContainsInvalidValues_IgnoresInvalidValues() {
        Collection<Integer> result = summarizer.collect("1,abc,2,xyz,3");

        assertIterableEquals(List.of(1, 2, 3), result);
    }

    @Test
    void collect_EmptyInput_ReturnsEmptyCollection() {
        Collection<Integer> result = summarizer.collect("");

        assertTrue(result.isEmpty());
    }

    // =====================================================
    // summarizeCollection() tests
    // =====================================================

    @Test
    void summarizeCollection_EmptyCollection_ReturnsEmptyString() {
        assertEquals("", summarizer.summarizeCollection(List.of()));
    }

    @Test
    void summarizeCollection_NullCollection_ReturnsEmptyString() {
        assertEquals("", summarizer.summarizeCollection(null));
    }

    @Test
    void summarizeCollection_SingleValue_ReturnsSingleValue() {
        assertEquals("5", summarizer.summarizeCollection(List.of(5)));
    }

    @Test
    void summarizeCollection_SequentialValues_ReturnsSingleRange() {
        assertEquals(
            "1-5",
            summarizer.summarizeCollection(List.of(1, 2, 3, 4, 5))
        );
    }

    @Test
    void summarizeCollection_NonSequentialValues_ReturnsIndividualValues() {
        assertEquals(
            "1, 3, 5, 7",
            summarizer.summarizeCollection(List.of(1, 3, 5, 7))
        );
    }

    @Test
    void summarizeCollection_MixedRangesAndValues_ReturnsCorrectSummary() {
        assertEquals(
            "1-3, 5, 7-8, 10",
            summarizer.summarizeCollection(List.of(1, 2, 3, 5, 7, 8, 10))
        );
    }

    // =====================================================
    // Integration test
    // =====================================================

    @Test
    void collectAndSummarize_ExampleInput_ReturnsExpectedSummary() {
        Collection<Integer> nums = summarizer.collect(
            "1,3,6,7,8,12,13,14,15,21,22,23,24,31"
        );

        assertEquals(
            "1, 3, 6-8, 12-15, 21-24, 31",
            summarizer.summarizeCollection(nums)
        );
    }

    @Test
    void collectAndSummarize_MixedInput_ReturnsCorrectSummary() {
        Collection<Integer> nums = summarizer.collect(
            " 5, 1, 4, 2, 3, 3, abc, 8, 7, 6, xyz, 10, 10 "
        );

        assertEquals("1-8, 10", summarizer.summarizeCollection(nums));
    }
}
