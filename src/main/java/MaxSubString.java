/**
 * Created by Shaman on 3/14/15.
 */
public class MaxSubString {
    public String match (String str1, String str2){
        if (str1.length() > str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        final int length = str1.length();
        String result = "";
        for (int i = 0; i < length; i++) {
            for (int j = 1; j <= length - i; j++) {
                String s = str1.substring(i, i + j);
                if (str2.contains(s)) {
                    if (s.length() >= result.length()) {
                        result = s;
                    }

                }
            }
        }
        return result;
    }
}
