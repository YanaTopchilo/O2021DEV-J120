package converter;
import java.io.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;



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
        ArrayList <String> line = new ArrayList<>();
        try {
            BufferedReader input = new BufferedReader(new FileReader(inputFileName));
           FileWriter output = new FileWriter(outputFileName);

        Charset charset = Charset.forName(charSet);

           while (input.ready()){
            line.add(input.readLine());}
          for (int i = 0; i < line.size(); i++) {
            byte[] byteWord = line.get(i).getBytes(charset);
        String[] binary = new String[byteWord.length];
            for(int j=0 ; j<byteWord.length ; j++){
               binary[j]=String.format("%8s", Integer.toBinaryString(byteWord[j])).replace(" ", "0");
             output.write(binary[j] + " ");
                  output.flush();
            }}
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    return outputFileName;
}

    @Override
    public String toText(String inputFileName, String outputFileName, String charSet) {
        if(inputFileName == null)
            throw new IllegalArgumentException("inputFileName can't be null.");
        ArrayList <String> line = new ArrayList<>();
        try {
            BufferedReader input = new BufferedReader(new FileReader(inputFileName));
            FileWriter output = new FileWriter(outputFileName);
            Charset charset = Charset.forName(charSet);
            while (input.ready()){
                line.add(input.readLine());}
            for (int i = 0; i < line.size(); i++) {
                byte[] bytes = line.get(i).getBytes(charset);
                byte[] textByte = new byte[bytes.length];
                for (int j = 0; j < bytes.length; j++) {
                    textByte[j] = Byte.parseByte(String.valueOf(bytes[j]), 2);
                    output.write(textByte[j] + " ");
                    output.flush();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputFileName;
    }


}

