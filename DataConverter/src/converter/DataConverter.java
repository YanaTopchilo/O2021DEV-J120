package converter;

import java.nio.charset.Charset;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DataConverter implements IFileConverter {
    /**
     * Метод преобразует текстовый файл в двоичное
     * представление. Метод реализует следующий алгоритм:
     * - обычный текст преобразуется в байтовое представление с
     * использованием заданной кодировки charSet;
     * - текстовое представление чисел в интегральном и
     * вещественном формате преобразуется в двоичном
     * представлении.
     *
     * @param inputFileName имя исходного файла данных в
     * текстовом формате.
     * @param outputFileName имя выходного файла с данными в
     * двоичном формате.
     * Если файл с таким именем уже существует, то он
     * перезаписывается данным методом.
     * @param charSet используемая кодировка текста.
     * @return строку с именем выходного файла, если конвертация
     * завершена корректно, или сообщение с описанием исключения,
     * возникшего в ходе выполнения конвертации.
     */
    @Override
 public String toBinary(String inputFileName, String outputFileName, String charSet) {
        if(inputFileName == null)
            throw new IllegalArgumentException("inputFileName can't be null.");
      File inputFile = new File(inputFileName);
      Charset charset = Charset.forName(charSet);
        String text = null;
        FileReader reader = null;
        try {
            reader = new FileReader(inputFile);
            char[] chars = new char[(int)inputFile.length()];
            reader.read(chars);
            text = new String(chars);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return text;
    }

    @Override
    public String toText(String inputFileName, String outputFileName, String charSet) {
        return null;
    }


}
