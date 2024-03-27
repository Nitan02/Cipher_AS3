

/*
 * Class: CMSC203 
 * Instructor:Ashique Tanveer
 * Description: (Caesar Cipher and Bellaso Cipher)
 * Due: 3/27/2024
 * Platform/compiler:
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Touch Nitan
*/


public class CryptoManager {

    private static final char LOWER_RANGE = ' ';
    private static final char UPPER_RANGE = '_';
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

    public static boolean isStringInBounds(String plainText) {
        for (char c : plainText.toCharArray()) {
            if (c < LOWER_RANGE || c > UPPER_RANGE) {
                return false;
            }
        }
        return true;
    }

    public static String caesarEncryption(String plainText, int key) {
        if (!isStringInBounds(plainText)) {
            return "The selected string is not in bounds, Try again.";
        }

        StringBuilder encryptedText = new StringBuilder();
        for (char c : plainText.toCharArray()) {
            if (c >= LOWER_RANGE && c <= UPPER_RANGE) {
                int shifted = ((c - LOWER_RANGE + key) % RANGE) + LOWER_RANGE;
                if (shifted < LOWER_RANGE) {
                    shifted += RANGE;
                }
                encryptedText.append((char) shifted);
            } else {
                // If the character is not within the specified range, leave it unchanged
                encryptedText.append(c);
            }
        }
        return encryptedText.toString();
    }

    public static String caesarDecryption(String encryptedText, int key) {
        if (!isStringInBounds(encryptedText)) {
            return "The encrypted string is not in bounds, Try again.";
        }

        StringBuilder decryptedText = new StringBuilder();
        for (char c : encryptedText.toCharArray()) {
            if (c >= LOWER_RANGE && c <= UPPER_RANGE) {
                int shifted = ((c + LOWER_RANGE - key + RANGE) % RANGE) + LOWER_RANGE;
                if (shifted < LOWER_RANGE) {
                    shifted += RANGE;
                }
                decryptedText.append((char) shifted);
            } else {
                // If the character is not within the specified range, leave it unchanged
                decryptedText.append(c);
            }
        }
        return decryptedText.toString();
    }


    public static String bellasoEncryption(String plainText, String bellasoStr) {
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char c = plainText.charAt(i);
            char keyChar = bellasoStr.charAt(i % bellasoStr.length());
            int shifted = shiftChar(c, keyChar);
            encryptedText.append((char) shifted);
        }
        return encryptedText.toString();
    }

    public static String bellasoDecryption(String encryptedText, String bellasoStr) {
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < encryptedText.length(); i++) {
            char c = encryptedText.charAt(i);
            char keyChar = bellasoStr.charAt(i % bellasoStr.length());
            int shifted = c - keyChar;
            if (shifted < LOWER_RANGE) {
                shifted += RANGE;
            }
            decryptedText.append((char) shifted);
        }
        return decryptedText.toString();
    }

    private static int shiftChar(char c, char keyChar) {
        int shifted = c + keyChar - 2 * LOWER_RANGE;
        if (shifted < LOWER_RANGE) {
            shifted += RANGE;
        } else if (shifted > UPPER_RANGE) {
            shifted -= RANGE;
        }
        return shifted;
    }
}