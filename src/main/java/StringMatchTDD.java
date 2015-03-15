/**
 * Created by Shaman on 3/14/15.
 */
public class StringMatchTDD {
    public String match(String str1, String str2) {
        String longStr, shortStr;
        longStr = getLongString(str1, str2);
        shortStr = getShortString(str1, str2);

        for (int matchCount = shortStr.length(); matchCount > 0; matchCount--)
            for (int beginIndex = 0; beginIndex < shortStr.length() - matchCount + 1; beginIndex++)
                if (longStr.contains(shortStr.substring(beginIndex, beginIndex + matchCount)))
                    return shortStr.substring(beginIndex, beginIndex + matchCount);

        return "";
    }

    private String getShortString(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return str1;
        } else {
            return str2;
        }
    }

    private String getLongString(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return str2;
        } else {
            return str1;
        }
    }

}
