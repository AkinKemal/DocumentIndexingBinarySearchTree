import java.io.File;
import java.io.FilenameFilter;

public class MyFileNameFilter implements FilenameFilter {

    public MyFileNameFilter() {

    }

    @Override
    public boolean accept(File directory, String fileName) {
        return fileName.endsWith(".txt");
    }

}