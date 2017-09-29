class HexToDec {
    static Long convert(String hexNum){
        long number = 0;
        int  digit;
        for(int i = 0; i < hexNum.length(); i++) {
            digit = Character.digit(hexNum.toLowerCase().charAt(i), 16);
            number += digit * Math.pow(16, (hexNum.length() - 1 - i));
        }
        return number;
    }
}
