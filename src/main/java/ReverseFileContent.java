import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class ReverseFileContent {
    private String readFileAndReturnContent(String filePath) {
        FileReader fileReader = null;
        String str = "";
        try {
            fileReader = new FileReader(filePath);
        int i;

        while ((i=fileReader.read()) != -1) {
            str+=(char)i;
        }
        fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return str;
    }

    protected String reverseContent(String str) {
        String revStr = "";
        for(int i=str.length()-1;i>=0;i--) {
            revStr+=(char)str.charAt(i);
        }
        return revStr;
    }

    private void writeToFile(String content, String filePath) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(filePath);
            fw.write(content);
        fw.flush();
        fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean reverseFileContent(String inputFile, String outputFile) {
        try {
            String str = readFileAndReturnContent(inputFile);
            String revStr = reverseContent(str);
            writeToFile(revStr, outputFile);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
/*    public static void main(String [] args) throws IOException {
        System.out.println(new ReverseFileContent().reverseFileContent("input.txt", "output.txt"));
    }*/
}
