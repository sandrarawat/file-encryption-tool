package ie.gmit.dip;

import java.util.Locale;

public class PolybiusSquareCypher {

  private final PolybiusSquare square = new PolybiusSquare();

  // Method for encryption
  public String encrypt(String content, String key) {
    // Encrypted Text
    String encryptedWithPolybiusSquare = encryptWithPolybiusSquare(content);

    // Matrix Object
    Matrix matrix = new Matrix(key);

    // Perform columnar transposition and read off the encrypted string from the matrix
    return matrix.contentByColumns(padded(encryptedWithPolybiusSquare, key));
  }

  	// Method for decryption
  public String decrypt(String encrypted, String key) { 
	  // Return the square encrypted content from the matrix
    Matrix matrix = new Matrix(key);
    String encryptedWithPolybiusSquare = matrix.decrypt(encrypted);
    return decryptUsingPolybiusSquare(encryptedWithPolybiusSquare).trim();
  }
 
  	// Method for encrypting with StringBuilder
  private String encryptWithPolybiusSquare(String content) {
    StringBuilder sb = new StringBuilder();
    for (char c : content.toUpperCase(Locale.ENGLISH).toCharArray()) {
      sb.append(square.getEncode(c));
    }
    return sb.toString();
  }

//Method for decrypting with StringBuilder
  private String decryptUsingPolybiusSquare(String encrypted) {
    StringBuilder sb = new StringBuilder();
    // Get the pairs of encoded characters
    for (int i = 0; i < encrypted.length() / 2; i++) {
      String code = "" + encrypted.charAt(2 * i) + encrypted.charAt(2 * i + 1);
      sb.append(square.getChar(code));
    }
    return sb.toString();
  }
  
  //Padding to ensure Polybius Square matches Keyword Length
  private String padded(String s, String key) {
    StringBuilder sb = new StringBuilder(s);

    int padMultiple_Key = key.length();
    if (padMultiple_Key % 2 == 1) {
      padMultiple_Key *= 2;
    }

    String padding = square.getEncode(' ');
    while (sb.length() % padMultiple_Key != 0) {
      sb.append(padding);
    }

    return sb.toString();
  }
}

/*
 https://www.geeksforgeeks.org/stringbuilder-class-in-java-with-examples/
 https://docs.microsoft.com/en-us/dotnet/api/system.text.stringbuilder.length?view=netframework-4.8
 https://stackoverflow.com/questions/11880644/use-stringbuilder-to-pad-string-with-blank-spaces-or-other-characters
 https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html
 */
  
