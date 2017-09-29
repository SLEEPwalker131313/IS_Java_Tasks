public class Rot13 {
    private static String encode_str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static String decode_str = "NOPQRSTUVWXYZABCDEFGHIJKLMnopqrstuvwxyzabcdefghijklm";

    public static StringBuilder encode(String input){
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); ++i) {
            output.append(decode_str.charAt(encode_str.indexOf(input.charAt(i))));
        }
        return output;
    }

    public static StringBuilder decode(String input){
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); ++i) {
            output.append(encode_str.charAt(decode_str.indexOf(input.charAt(i))));
        }
        return output;
    }
}
