package ie.gmit.dip;


	public class EncryptDecrypt {

	  private final PolybiusSquare square = new PolybiusSquare();

	  public String encrypt(String content, String key) {
	    // To create encrypted text using the Polybius Square
	    String encryptedUsingPolybiusSquare = encryptUsingPolybiusSquare(content);

	    // To create a matrix from the code word
	    Matrix matrix = new Matrix(key);

	    // To perform a columnar transposition and read off the encrypted string from the matrix
	    return matrix.contentByColumns(padded(encryptedUsingPolybiusSquare, key));
	  }

	  public String decrypt(String encrypted, String key) {
	    // To return the square-encrypted-content from the matrix, which contains the logic of the columns
	    Matrix matrix = new Matrix(key);

	    String encryptedUsingPolybiusSquare = matrix.decrypt(encrypted);

	    return decryptUsingPolybiusSquare(encryptedUsingPolybiusSquare).trim();
	  }

	  private String encryptUsingPolybiusSquare(String content) {
	    StringBuilder sb = new StringBuilder();
	    for (char c : content.toUpperCase().toCharArray()) {
	      sb.append(square.getEncode(c));
	    }
	    return sb.toString();
	  }

	  private String decryptUsingPolybiusSquare(String encrypted) {
	    StringBuilder sb = new StringBuilder();
	    // To get the encode character in the original *pairs*
	    for (int i = 0; i < encrypted.length() / 2; i++) {
	      String code = "" + encrypted.charAt(2 * i) + encrypted.charAt(2 * i + 1);
	      sb.append(square.getChar(code));
	    }
	    return sb.toString();
	  }
	 // To add padding to form a square
	  private String padded(String s, String key) {
	    StringBuilder sb = new StringBuilder(s);

	    int padToMultipleOf = key.length();
	    if (padToMultipleOf % 2 == 1) {
	      padToMultipleOf *= 2;
	    }

	    String padding = square.getEncode(' ');
	    while (sb.length() % padToMultipleOf != 0) {
	      sb.append(padding);
	    }

	    return sb.toString();
	  }
	}

