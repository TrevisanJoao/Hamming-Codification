package Main;
import hammingCode.hammingCode;

public class main {
    public static void main(String[] args){
        hammingCode coder = new hammingCode();
        String code = coder.codification("hello");
        String decode = coder.fromBinary(code);
        System.out.println(decode);
    }
}
