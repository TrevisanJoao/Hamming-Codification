package Main;
import hammingCode.hammingCode;

public class main {
    public static void main(String[] args){
        hammingCode hamming = new hammingCode();
        String code = hamming.codification("hello");
        String decode = hamming.fromBinary(code);
        System.out.println("Code: " + code + "\nWord: " + decode);

        System.out.println("Valid: " + hammingCode.isValidHammingCode(code));
        System.out.println("Error position: " + hammingCode.findErrorPosition(code));
    }
}
