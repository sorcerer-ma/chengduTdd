import org.hamcrest.core.Is;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by Shaman on 3/14/15.
 */
public class StringMatchTDDTest {
    StringMatchTDD stringMatchTDD = new StringMatchTDD();

    @Test
    public void should_return_self_if_two_strings_identical() {
        assertEquals("a", stringMatchTDD.match("a", "a"));
    }

    @Test
    public void should_return_empty_if_totally_different() {
        assertEquals("", stringMatchTDD.match("a", "b"));
    }

    @Test
    public void should_return_substring_when_one_contains_the_other_one() {
        assertEquals("b", stringMatchTDD.match("ab", "b"));
        assertEquals("a", stringMatchTDD.match("a", "ab"));
        assertEquals("ab", stringMatchTDD.match("ab", "abc"));
    }


    @Test
    public void should_return_substring_if_partial_match() {
        assertEquals("b", stringMatchTDD.match("ab", "bc"));
        assertEquals("c", stringMatchTDD.match("abc", "cde"));
        assertEquals("bc", stringMatchTDD.match("abc", "bce"));
        assertEquals("bcd", stringMatchTDD.match("abcd", "bcde"));
    }

    @Test
    public void should_return_substring_if_partial_match_with_different_length() {
        assertEquals("b", stringMatchTDD.match("zdab", "bc"));
    }

    @Test
    public void should_return_substring_from_head() {
        assertEquals("a", stringMatchTDD.match("acd", "ab"));
        assertEquals("ab", stringMatchTDD.match("abcd", "abx"));
    }

    @Test
    public void should_return_substring_from_tail() {
        assertEquals("bcd", stringMatchTDD.match("abcd", "xbcd"));
    }

    @Test
    public void should_return_substring_in_middle() {
        assertEquals("bcd", stringMatchTDD.match("abcdv", "xbcdy"));
    }

    @Test(expected = NullPointerException.class)
    public void null_got_null_exception() throws Exception {
        a_b_got_c(null, "", null);
        a_b_got_c("", null, null);

    }

    @Test
    public void test_same_return_any() throws Exception {
        a_b_got_c("a", "a", "a");
        a_b_got_c("abc", "abc", "abc");
        a_b_got_c("abcd", "abcd", "abcd");
    }

    @Test
    public void one_of_empty() throws Exception {
        a_b_got_c("abc", "", "");
        a_b_got_c("", "abc", "");
    }

    @Test
    public void contains_special() throws Exception {
        a_b_got_c("\"abc", "\"", "\"");

        a_b_got_c("!abc", "!", "!");
    }

    @Test
    public void test_one_contains_another() throws Exception {
        // a contains b
        a_b_got_c("abc", "a", "a");

        // b contains a
        a_b_got_c("a", "abc", "a");
    }

    @Test
    public void part_match() throws Exception {
        // head or tail substring
        a_b_got_c("abcde", "abc", "abc");
        a_b_got_c("abddecd", "abcd", "ab");// cd

        // middel substring
        a_b_got_c("abcde", "ebcda", "bcd");
        a_b_got_c("abcdef", "adefabca", "abc");
        a_b_got_c("ab", "ba", "b");
        a_b_got_c("abcba", "ebfba", "ba");
        a_b_got_c("eeeffffffffdddd", "cceefffffffsddd", "eefffffff");

        a_b_got_c("ac*******cba", "eb******fba", "******");
        a_b_got_c("ngfedcbtal", "aagfadcbtg", "dcbt");
    }

    @Test
    public void part_match_short_an_long() throws Exception {
        // head or tail substring
        a_b_got_c("abc","abcde", "abc");
        a_b_got_c("abcd","abddecd", "ab");// cd

        // middel substring
        a_b_got_c("ebcda","abcde", "bcd");
        a_b_got_c("adefabca","abcdef", "abc");
        a_b_got_c("ba","ab", "a");
        a_b_got_c("ebfba","abcba", "ba");
        a_b_got_c("cceefffffffsddd","eeeffffffffdddd", "eefffffff");

        a_b_got_c("ac*******cba", "eb******fba", "******");
        a_b_got_c("aagfadcbtg", "ngfedcbtal", "dcbt");
    }

    void a_b_got_c(String a, String b, String c) {
        assertThat(stringMatchTDD.match(a, b), Is.is(c));
    }


}
