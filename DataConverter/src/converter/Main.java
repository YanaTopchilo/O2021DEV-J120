package converter;

import converter.DataConverter;
import converter.IFileConverter;

public class Main {
    public static void main(String[] args)  {
        IFileConverter converter1 = new DataConverter();

       System.out.println(converter1.toBinary ("C:\\Users\\kosti\\Desktop\\try.txt", "C:\\Users\\kosti\\Desktop\\try1.txt" ,"ASCII"));



    }
}
