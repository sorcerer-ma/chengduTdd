/**
 * Created by Shaman on 3/14/15.
 */
public class MaxSubStringTDD {

    public String match(String str1, String str2) {
        String longStr = str1;
        String shortStr = str2;

        if (str1.length() < str2.length()) {
            longStr = str2;
            shortStr = str1;
        }

        return matchPartialShortStr(longStr, shortStr, 0, "" ,"");
    }

    private String matchPartialShortStr(String longStr, String shortStr, int index, String matched, String result) {
        if (index == shortStr.length()) {
            return max(matched, result);
        }

        String partial = matched + shortStr.substring(index, index + 1);
        if (!longStr.contains(partial)) {
            return matchPartialShortStr(longStr, shortStr, index + 1, "", result);
        } else {
            return matchPartialShortStr(longStr, shortStr, index + 1, partial, max(partial, result));
        }
    }
    private String max(String a, String b) {
        return b.length() < a.length() ? a : b;
    }
}
