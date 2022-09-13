import java.io.File;
import java.io.FilenameFilter;

public class GetFileNameFilter {

    public GetFileNameFilter() {

    }

    public int findFiles(String dir) {
        File file = new File(dir);
        int counter = 0;
        if (!file.exists()) {
            System.out.println(dir + " Directory doesn't exists");
        }
        FilenameFilter filter = new MyFileNameFilter();
        File[] listFiles = file.listFiles(filter);
        if (listFiles != null) {
            for (File f : listFiles) {
                counter++;
            }
        }
        return counter;
    }

}