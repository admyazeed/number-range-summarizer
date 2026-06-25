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
}
