//import  java.util.*;

public class vigenereCypher {
    public static char alphabet[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static void main(String[] args) {
        vigenereEncrypt("MarcusVincentHolzhaeuser", "Polen");
    }

    public static String makeLenght(int len, String input) {
        int desLen = len;
        StringBuilder wordLock = new StringBuilder(input);
        StringBuilder word = wordLock;
        while (word.length() != desLen) {
            if (word.length() < desLen) {
                word.insert(word.length(), wordLock);
            } else {
                word.deleteCharAt(word.length() - 1);
            }
        }
        return(word.toString());
    }

    public static int getCharValue(char in) {
        in = Character.toUpperCase(in);
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == in) {
                return i;
            }
        }
        throw new IllegalArgumentException(
            "Invalid character: " + in
        );
    }

    public static String vigenereEncrypt(String plaintextIn, String keyword) {
        StringBuilder plaintext = new StringBuilder(plaintextIn.toUpperCase());
        keyword = makeLenght(plaintext.length(), keyword);
        int i = 0;
        int j = 0;
        while(i < plaintext.length()) {
            j = (getCharValue(plaintext.charAt(i)) + getCharValue(keyword.charAt(i))) % 26;
            StringBuilder sb = new StringBuilder(plaintext);
            sb.setCharAt(i, alphabet[j]);
            plaintext = sb;
            i++;
        }
        System.out.println("Encryption Done!");
        System.out.println("Encrypted Output: " + plaintext);
        System.out.println("Unencrypted Plaintext: " + plaintextIn);
        System.out.println("En/Decryption Keyword: " + keyword);
        return plaintext.toString();
    }
}