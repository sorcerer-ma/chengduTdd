public class StringMatch {

    /**
     *
     * @param str1
     * @param str2
     * @return
     */
    public static String getMaxMatch(String str1, String str2) {

        if (str1 == null || str2 == null) {
            throw new NullPointerException();
        }
        if (str1.isEmpty() || str2.isEmpty()) {
            return "";
        }

        String longStr = str1;
        String shortStr = str2;
        if (str1.length() <= str2.length()) {
            shortStr = str1;
            longStr = str2;
        }

        int shortStringLength = shortStr.length();
        for (int matchLength = shortStringLength; matchLength > 0; matchLength--) {
            for (int i = 0; i <= shortStringLength - matchLength; i++) {
                String sub = shortStr.substring(i, i + matchLength);
                if (longStr.contains(sub)) {
                    return sub;
                }
            }
        }
        return "";
    }
}
