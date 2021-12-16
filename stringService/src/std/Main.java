package std;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws StringArrayException {
        try {
        String[] as = {"Каждый", "охотник", "желает", "знать", "где", "сидит", "фазан"};
        StringService.sort(as, false);
        for (String s : as)
            System.out.println(s);}
        catch (StringArrayException ex){
            System.out.println(ex.getMessage());
        }
        String str = "Mама мыла раму в субботу";
        System.out.println(Arrays.toString(StringService.getCharStat (str)));
}
}