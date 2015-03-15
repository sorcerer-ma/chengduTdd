import junit.framework.Assert;
import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by Shaman on 3/14/15.
 */
public class MaxSubStringTDDTest {

    @Test
    public void should_return_it_self_when_same_string() {
        assertEquals("", new MaxSubStringTDD().match("", ""));
        assertEquals("a", new MaxSubStringTDD().match("a", "a"));
    }

    @Test
    public void two_char_of_shortStr_match() {
        assertEquals("ab", new MaxSubStringTDD().match("abc", "ab"));
        assertEquals("bc", new MaxSubStringTDD().match("abc", "bc"));
    }

    @Test
    public void should_return_empty_when_different_string() {
        assertEquals("", new MaxSubStringTDD().match("a", "b"));
        assertEquals("", new MaxSubStringTDD().match("", "ab"));
        assertEquals("", new MaxSubStringTDD().match("a", "cd"));
    }

    @Test
    public void should_return_substring_when_one_contains_another() {
        assertEquals("a", new MaxSubStringTDD().match("ab", "a"));
        assertEquals("b", new MaxSubStringTDD().match("ab", "b"));
    }

    @Test
    public void should_return_same_result_without_order() {
        assertEquals("a", new MaxSubStringTDD().match("ab", "a"));
        assertEquals("a", new MaxSubStringTDD().match("a", "ab"));
    }

    @Test
    public void should_return_same_char_in_different_string() {
        assertEquals("b", new MaxSubStringTDD().match("abc", "bd"));
        assertEquals("d", new MaxSubStringTDD().match("adc", "bd"));
    }

    @Test
    public void longer_match_is_ahead_of_shorter_match() {
        assertEquals("ab", new MaxSubStringTDD().match("abcde", "abd"));
    }

    @Test
    public void same_result_if_reverse_str1_and_str2() {
        assertTrue(new MaxSubStringTDD().match("abc", "ba").equals(new MaxSubString().match("ba", "abc")));
    }

    StringMatchTDD stringMatchTDD = new StringMatchTDD();

    @Test
    public void should_return_self_if_two_strings_identical() {
        Assert.assertEquals("a", stringMatchTDD.match("a", "a"));
    }

    @Test
    public void should_return_empty_if_totally_different() {
        Assert.assertEquals("", stringMatchTDD.match("a", "b"));
    }

    @Test
    public void should_return_substring_when_one_contains_the_other_one() {
        Assert.assertEquals("b", stringMatchTDD.match("ab", "b"));
        Assert.assertEquals("a", stringMatchTDD.match("a", "ab"));
        Assert.assertEquals("ab", stringMatchTDD.match("ab", "abc"));
    }


    @Test
    public void should_return_substring_if_partial_match() {
        Assert.assertEquals("b", stringMatchTDD.match("ab", "bc"));
        Assert.assertEquals("c", stringMatchTDD.match("abc", "cde"));
        Assert.assertEquals("bc", stringMatchTDD.match("abc", "bce"));
        Assert.assertEquals("bcd", stringMatchTDD.match("abcd", "bcde"));
    }

    @Test
    public void should_return_substring_if_partial_match_with_different_length() {
        Assert.assertEquals("b", stringMatchTDD.match("zdab", "bc"));
    }

    @Test
    public void should_return_substring_from_head() {
        Assert.assertEquals("a", stringMatchTDD.match("acd", "ab"));
        Assert.assertEquals("ab", stringMatchTDD.match("abcd", "abx"));
    }

    @Test
    public void should_return_substring_from_tail() {
        Assert.assertEquals("bcd", stringMatchTDD.match("abcd", "xbcd"));
    }

    @Test
    public void should_return_substring_in_middle() {
        Assert.assertEquals("bcd", stringMatchTDD.match("abcdv", "xbcdy"));
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
