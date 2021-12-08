package std;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class StringService {
    /**
     * Метод сортирует массив строк, заданных параметром as.
     *
     * @param as  исходный массив строк.
     * @param dir определяет порядок сортировки строк: если
     *            данный параметр равен true, то строки сортируются в
     *            алфавитном порядке, а если данный параметр равен
     *            false, то строки сортируются в обратном порядке.
     * @return возвращается отсортированный массив строк.
     * @throws StringArrayException данное исключение
     *                              выбрасывается в случае, если ссылка на исходный массив as
     *                              равна null или в случае когда массив as пуст.
     */
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
            for (int i = 0; i < as.length/2; i++) {
                String s = as[i];
                as[i] = as[as.length - 1 - i];
                as[as.length - 1 - i] = s;
            }
                return as;
            }
            return as;
        }

        /**
         * Метод возвращает набор символов, каждый из которых хотя
         * бы один раз встречается в исходной строке str.
         *
         * @param str исходная строка.
         * @return массив уникальный символов, каждый из которых
         * хотя бы один раз встречается в исходной строке str. Если
         * ссылка на исходный массив равна null, то метод также
         * возвращает null. Если исходная строка пуста, то
         * возвращается пустой массив.
         */
        public static char[] getCharStat (String str){
            return null;
        }

}
