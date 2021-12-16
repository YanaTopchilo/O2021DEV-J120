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
        //byte[] textByte = new byte[symbol.length];
        try {
            BufferedReader input = new BufferedReader(new FileReader(inputFileName));
            FileWriter output = new FileWriter(outputFileName);
            Charset charset = Charset.forName(charSet);
            String line = input.readLine();
            String[] simbols = line.split(" ");;
            byte[] bytes = new byte[simbols.length];
                for (int i = 0; i < simbols.length; i++) {
                    bytes[i] = Byte.parseByte(simbols[i], 2);
                    //textByte[i] = bytes.getBytes(charset);
                }
                    String  text = new String(bytes, charSet);
                    output.write(text);
                    output.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputFileName;
    }
    @Override
   public double getSum(String fileName) throws ConverterException{
        File file = new File(fileName);
        if(fileName == null)
            throw new ConverterException("FileName can't be null.");
        if(file.length() == 0)
            throw new ConverterException("FileName is empty");
        ArrayList <String> line = new ArrayList<>();
        try {
            BufferedReader input = new BufferedReader(new FileReader(fileName));
           while (input.ready()){
                line.add(input.readLine());}
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        double sum = 0 ;
        for (int i = 0; i < line.size(); i++) {
            String str = line.get(i);
            for (int j = 0; j < str.length(); j++) {
                char num = str.charAt(j);
                if (Character.isDigit(num)){
                    double number = Double.parseDouble(String.valueOf(num));
                    sum = sum + number;
                }
            }
        }
     return sum;
}
}

