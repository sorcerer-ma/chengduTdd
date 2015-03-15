import static org.junit.Assert.*;

import org.hamcrest.core.AnyOf;
import org.hamcrest.core.Is;
import org.junit.Test;

public class StringMatchTest {

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
        a_b_got_c("ab", "ba", "a");
        a_b_got_c("abcba", "ebfba", "ba");
        a_b_got_c("eeeffffffffdddd", "cceefffffffsddd", "eefffffff");

        a_b_got_c("ac*******cba", "eb******fba", "******");
        a_b_got_c("ngfedcbtal","aagfadcbtg","dcbt");
    }

    @Test
    public void part_match_short_an_long() throws Exception {
        // head or tail substring
        a_b_got_c("abc","abcde", "abc");
        a_b_got_c("abcd","abddecd", "ab");// cd
        a_b_got_c("abdsdfababfddes","fdieabodiababuddw", "abab");// cd

        // middel substring
        a_b_got_c("ebcda","abcde", "bcd");
        a_b_got_c("adefabca","abcdef", "abc");
        a_b_got_c("ba","ab", "b");
        a_b_got_c("ebfba","abcba", "ba");
        a_b_got_c("cceefffffffsddd","eeeffffffffdddd", "eefffffff");

        a_b_got_c("ac*******cba", "eb******fba", "******");
        a_b_got_c("aagfadcbtg","ngfedcbtal","dcbt");
    }

    void a_b_got_c(String a, String b, String c) {
        assertThat(StringMatch.getMaxMatch(a, b), Is.is(c));
    }




}
