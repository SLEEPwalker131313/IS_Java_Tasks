import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FileToList {

    public static List<String> getList(String path, int num) throws IOException {
        int lineLength = 80;
        File file = new File(path);
        List<String> fileList = new ArrayList<>((int) (file.length() / lineLength) * 2);
        int count = 0;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            fileList.add(line);
            ++count;
        }
        reader.close();

        // Random lines
        List<String> output = new ArrayList<>(num);
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            output.add(fileList.get(random.nextInt(count - 1)));
        }
        return output;
    }
}