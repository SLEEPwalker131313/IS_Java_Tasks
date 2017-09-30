import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class CharCounter {

    static int count(String file, char symbol) throws IOException {
        int count = 0;
        BufferedReader reader = new BufferedReader(
                new InputStreamReader ( new FileInputStream(file) ));
        int c;
        while((c = reader.read()) != -1) {
            char character = (char) c;
            if (character == symbol) ++count;
        }
        return count;
    }

}