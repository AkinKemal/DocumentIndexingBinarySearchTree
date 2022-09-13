import java.io.FileReader;
import java.io.BufferedReader;

public class ReaderFile {

    public int controlFileName = 0;

    public ReaderFile() {

    }

    public String readerFile(String fileName) {
        String temporaryString = "";
        String temporaryFileName = "AllDocs\\" + fileName;
        try {
            String line = "";
            BufferedReader bufferedReader = new BufferedReader(new FileReader(temporaryFileName));
            while ((line = bufferedReader.readLine()) != null) {
                line = loverCase(line);
                for (int i = 0; i < line.length(); i++) {
                    if ((line.charAt(i) <= 'Z' && line.charAt(i) >= 'A') || (line.charAt(i) <= 'z' && line.charAt(i) >= 'a')) {
                        temporaryString += line.charAt(i);
                    } else {
                        temporaryString += " ";
                    }
                }
                temporaryString += " ";
            }
            controlFileName++;
            return temporaryString;
        } catch (Exception e) {
            System.out.println("EN: There was a problem reading file " + (controlFileName + 1) + ".txt .");
            System.out.println("TR: " + (controlFileName + 1) + ".txt dosyası okunurken bir sorun oluştu .");
        }
        controlFileName++;
        return "error";
    }

    public String loverCase(String temporaryString) {
        String result = "";
        for (int i = 0; i < temporaryString.length(); i++) {
            if (temporaryString.charAt(i) == 'I' || temporaryString.charAt(i) == 'İ') {
                result += "i";
            } else {
                result += temporaryString.toLowerCase().charAt(i);
            }
        }
        return result;
    }

}