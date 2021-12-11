package std;

import java.util.ArrayList;
import java.util.Arrays;


public class StringService {
    public static String[] sort(String[] as, boolean dir)
            throws StringArrayException {
        if (as == null || as.length == 0) {
            throw new StringArrayException("no elements in the array");
        }
        if (dir == true) {
            Arrays.sort(as, java.text.Collator.getInstance());
            return as;
        }
        if (dir == false) {
            Arrays.sort(as, java.text.Collator.getInstance());
            for (int i = 0; i < as.length / 2; i++) {
                String s = as[i];
                as[i] = as[as.length - 1 - i];
                as[as.length - 1 - i] = s;
            }
            return as;
        }
        return as;
    }

    public static char[] getCharStat(String str) {
        char[] charStr = str.toCharArray();
        char[] charStat = new char[charStr.length];
        if (str == null) {
            return null;
        }
        if (str != null) {
            ArrayList<Character> list = new ArrayList<>();
            list.add(charStr[0]);
            for (int i = 1; i < charStr.length - 1; i++) {
                if (!list.contains(charStr[i])) {
                    list.add(charStr[i]);
                }
            }
                int size = list.size();
            char[] containsInStr = new char[size];
            for (int i = 0; i < list.size(); i++) {
                containsInStr[i] = list.get(i);
            }
           charStat =  containsInStr;
            return charStat;
        }
        return charStat;
    }
}
