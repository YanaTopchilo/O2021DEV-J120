package converter;

import java.nio.charset.Charset;
public interface IFileConverter {

    String toBinary(String inputFileName, String outputFileName,String charSet);

    String toText(String inputFileName, String outputFileName,
                  String charSet);
}
