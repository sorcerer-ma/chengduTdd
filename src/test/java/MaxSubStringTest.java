import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Shaman on 3/14/15.
 */
public class MaxSubStringTest {
    MaxSubString stringMatch = new MaxSubString();

    @Test
    public void should_return_self_if_two_strings_identical() {
        assertEquals("a", stringMatch.match("a", "a"));
    }

    @Test
    public void should_return_empty_if_totally_different() {
        assertEquals("", stringMatch.match("a", "b"));
    }

    @Test
    public void should_return_substring_when_one_contains_the_other_one() {
        assertEquals("b", stringMatch.match("ab", "b"));
        assertEquals("a", stringMatch.match("a", "ab"));
    }


    @Test
    public void should_return_substring_if_partial_match() {
        assertEquals("b", stringMatch.match("ab","bc"));
        assertEquals("c", stringMatch.match("abc", "cde"));
        assertEquals("bc", stringMatch.match("abc", "bce"));
        assertEquals("bcd", stringMatch.match("abcd", "bcde"));
    }

    @Test
    public void large_number() {
        assertEquals("cksdd", stringMatch.match("ab12sacksddfcishadfasdkfuoweuasdfuoasdfasdf", "ccksddsadflkjaskdfhasdfhsadfke"));
        assertEquals(",,,,,", stringMatch.match("ab,,,,,,,12sacksdfc", ",,,,,ccksde"));
    }



}
