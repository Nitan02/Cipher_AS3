
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

import org.junit.jupiter.api.Test;

public class CryptoManagerTestStudent {
	CryptoManager cryptoManager;

    @Test
    public void testStringInBounds() {
        assertTrue(CryptoManager.isStringInBounds("ESPRESSO"));
        assertTrue(CryptoManager.isStringInBounds("\"LATTE IS GOOD\""));
        assertTrue(CryptoManager.isStringInBounds("coffee"));
        assertTrue(CryptoManager.isStringInBounds("{COFFEE"));
        assertTrue(CryptoManager.isStringInBounds("\"THIS TEST THAT SHOULD FAIL BECAUSE { IS OUTSIDE THE RANGE\""));
    }

    private void assertTrue(boolean stringInBounds) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testEncryptCaesar() {
        assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("bean", 3));
        assertEquals("DEF", CryptoManager.caesarEncryption("ABC", 3));
        assertEquals("!\"#", CryptoManager.caesarEncryption("ABC", 96));
        assertEquals("1.558", CryptoManager.caesarEncryption("LATTE", 105));
        assertEquals("VQQMQQQQ", CryptoManager.caesarEncryption("COFFEE", 1));
        assertEquals("WKLV#LV#DQRWKHU#WHVW", CryptoManager.caesarEncryption("THIS IS ANOTHER TEST", 3));
    }

    @Test
    public void testDecryptCaesar() {
        assertEquals("COFFEE", CryptoManager.caesarDecryption("VQQMQQQQ", 1));
        assertEquals("COFFEE ANOTHER STRING", CryptoManager.caesarDecryption(";,:;05.G(56;/,9G:;905.", 999));
        assertEquals("LATTE LATTE", CryptoManager.caesarDecryption("4188;LC;>80", 300));
        assertEquals("THIS IS ANOTHER TEST", CryptoManager.caesarDecryption("WKLV#LV#DQRWKHU#WHVW", 3));
    }

    private void assertEquals(String string, String caesarDecryption) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testEncryptBellaso() {
        assertEquals("UZ$Y#Z$", CryptoManager.bellasoEncryption("ESPRESSO", "COFFEE_IS_LIFE"));
        assertEquals("UJ^^((HT^X[YYM\"", CryptoManager.bellasoEncryption("MERRY CHRISTMAS", "HOT_DRINK"));
        assertEquals("WU\\VR9F#N!RF88U-'HED", CryptoManager.bellasoEncryption("THIS IS ANOTHER TEST", "CAFFEINE"));
    }

    @Test
    public void testDecryptBellaso() {
        assertEquals("ESPRESSO", CryptoManager.bellasoDecryption("UZ$Y#Z$", "COFFEE_IS_LIFE"));
        assertEquals("MERRY CHRISTMAS", CryptoManager.bellasoDecryption("UJ^^((HT^X[YYM\"", "HOT_DRINK"));
        assertEquals("THIS IS ANOTHER TEST", CryptoManager.bellasoDecryption("WU\\VR9F#N!RF88U-'HED", "CAFFEINE"));
    }
}

