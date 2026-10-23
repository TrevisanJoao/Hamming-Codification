package hammingCode;

public class hammingCode {

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
    public static String toBinary(int number) {
        return Integer.toBinaryString(number);
    }public static double squareRoot(double number) {
        return Math.sqrt(number);
    }
    public static String toBinary(String input) {
        StringBuilder binary = new StringBuilder();

        for (char c : input.toUpperCase().toCharArray()) {
            int value = c - 'A';

            if (value < 0 || value > 25) {
                throw new IllegalArgumentException(
                        "Only letters A-Z are supported"
                );
            }

            String bits = Integer.toBinaryString(value);
            binary.append("0".repeat(5 - bits.length())).append(bits);
        }

        if (binary.length() > 26) {
            throw new IllegalArgumentException(
                    "String is too long to fit in 26 bits"
            );
        }

        // Pad with zeros on the RIGHT
        return binary + "0".repeat(26 - binary.length());
    }
    public String fromBinary(String binary) {
        if (binary.length() != 31) {
            throw new IllegalArgumentException(
                    "Binary string must be exactly 31 bits long"
            );
        }

        if (!binary.matches("[01]+")) {
            throw new IllegalArgumentException(
                    "Input must contain only 0s and 1s"
            );
        }

        StringBuilder dataBits = new StringBuilder();

        // Positions are counted from the left, starting at 1
        for (int i = 0; i < binary.length(); i++) {
            int position = i + 1;

            // Skip positions that are powers of 2
            if (isPowerOfTwo(position)) {
                continue;
            }

            dataBits.append(binary.charAt(i));
        }

        StringBuilder word = new StringBuilder();

        // Decode the remaining data in groups of 5 bits
        for (int i = 0; i + 5 <= dataBits.length(); i += 5) {
            String bits = dataBits.substring(i, i + 5);
            int value = Integer.parseInt(bits, 2);

            if (value > 25) {
                throw new IllegalArgumentException(
                        "Invalid 5-bit value: " + bits
                );
            }

            word.append((char) ('A' + value));
        }

        return word.toString();
    }

    public String codification(String word) {
        String binary = toBinary(word);
        if(binary.length() != 26){
            return "ERROR: binary length is not 26\n";
        }
        for(int i = 0; i < binary.length(); i++){
            if(binary.charAt(i) != '0' && binary.charAt(i) != '1'){
                return "ERROR: input is not a binary\n";
            }
        }

        char[] codeArray = new char[31];
        int codeArrayCount = 0;
        int originalStringCount = 0;
        while(codeArrayCount < codeArray.length){
            if(isPowerOfTwo(codeArrayCount+1)){
                codeArray[codeArrayCount] = 'A';
                codeArrayCount++;
                continue;
            }
            codeArray[codeArrayCount] = binary.charAt(originalStringCount);
            codeArrayCount++;
            originalStringCount++;
        }

        for (int i = 0; i < codeArray.length; i++) {
            if (codeArray[i] == 'A') {
                int balance = 0;
                int parityPosition = i + 1;

                for (int j = 0; j < codeArray.length; j++) {
                    int bitPosition = j + 1;
                    if (j == i) {
                        continue;
                    }
                    if ((bitPosition & parityPosition) != 0) {
                        if (codeArray[j] == '1') {
                            balance++;
                        }
                    }
                }
                codeArray[i] = (balance % 2 == 0) ? '0' : '1';
            }
        }

        String code = new String(codeArray);
        return code;
    }
}
