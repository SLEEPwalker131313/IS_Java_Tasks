import java.util.Arrays;
import java.util.stream.Stream;

class StreamZip {
    static Stream zip(Stream first_stream, Stream second_stream){
        Object[] first_list = first_stream.toArray();
        Object[] second_list = second_stream.toArray();
        int result_length = Math.min(first_list.length, second_list.length);
        Object[] result_list = new Object[2 * result_length];
        int j = 0;
        for (int i = 0; i < result_length; ++i){
            result_list[j++] = first_list[i];
            result_list[j++] = second_list[i];
        }
        return Arrays.stream(result_list);
    }
}
