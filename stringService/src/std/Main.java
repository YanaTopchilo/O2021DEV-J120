package std;

import static java.lang.System.*;
import static std.StringService.sort;

public class Main {
    public static void main(String[] args)throws StringArrayException {
        String[] as = {"Каждый", "охотник", "желает", "знать", "где", "сидит", "фазан"};
        sort(as, false);
        for (String s : as)
            System.out.println(s);
}
}
