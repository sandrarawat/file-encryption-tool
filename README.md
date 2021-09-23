
# Polybius Square Assignment.
This program encrypts and decrypts txt files with a Polybuis Square Cypher. This application is built using Jframe and JFileChooser Graphical User Interface widgets from JSwing.

![alt text](https://github.com/sandrarawat/file-encryption-tool/blob/master/fileencryptiontoolgif.gif "File Encryption Tool Gif")

##Classes

## Runner 
	This class contains the main method. When the program is run, the user selects Input Filepath, Output Filepath and requires a specific keyword, which the user sets, in order for encryption and decryption to run. JFrame and JFilechooser are used to allow the user to select file input and output.

## PolybiusSquare
	This class uses a Hashmmap to set the alphabet Characters to their encoded Characters and encoded characters to the alphabet characters.

## EncryptDecrypt
Contains the [Encrypt](https://github.com/sandrarawat/file-encryption-tool/blob/3b81dace36e9b6fb6ce45a1f1c67c036c6e7b034/src/ie/gmit/dip/EncryptDecrypt.java#L8) method which creates a [matrix using the key](https://github.com/sandrarawat/file-encryption-tool/blob/74dbc0d14c3ea038904a1b62e2671bbcd55add12/src/ie/gmit/dip/EncryptDecrypt.java#L13) and [performs](https://github.com/sandrarawat/file-encryption-tool/blob/74dbc0d14c3ea038904a1b62e2671bbcd55add12/src/ie/gmit/dip/EncryptDecrypt.java#L16) [columnar transposition](https://www.google.com/search?q=+Columnar+Transposition&client=safari&rls=en&sxsrf=AOaemvIX09Ll1mEBVm2QOf-Bu2MmPxd-gA:1632391254166&ei=VlBMYefMCbGD8gKBtJn4Dw&oq=+Columnar+Transposition&gs_lcp=Cgdnd3Mtd2l6EAMyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAESgQIQRgAUL6pJ1i-qSdgobAnaABwAngAgAFbiAFbkgEBMZgBAKABAqABAcABAQ&sclient=gws-wiz&ved=0ahUKEwjnz9qm65TzAhWxgVwKHQFaBv8Q4dUDCA0&uact=5
) and reads the encrypted string from the matrix. The [decrypt method](https://github.com/sandrarawat/file-encryption-tool/blob/3b81dace36e9b6fb6ce45a1f1c67c036c6e7b034/src/ie/gmit/dip/EncryptDecrypt.java#L19) returns the encoded characters to original pairs. This class uses Stringbuilder to add [padding](https://github.com/sandrarawat/file-encryption-tool/blob/74dbc0d14c3ea038904a1b62e2671bbcd55add12/src/ie/gmit/dip/EncryptDecrypt.java#L46) to the Polybius Square to form a sqaure using keyword length.

## PolybiusSquareCypher
This class contains the methods for [encryption](https://github.com/sandrarawat/file-encryption-tool/blob/9851242757098292e10df4ffa99d5cfddaa4adc9/src/ie/gmit/dip/PolybiusSquareCypher.java#L10) and [decryption](https://github.com/sandrarawat/file-encryption-tool/blob/9851242757098292e10df4ffa99d5cfddaa4adc9/src/ie/gmit/dip/PolybiusSquareCypher.java#L21) which uses the Matrix Object and [performs](https://github.com/sandrarawat/file-encryption-tool/blob/9851242757098292e10df4ffa99d5cfddaa4adc9/src/ie/gmit/dip/PolybiusSquareCypher.java#L18) Columnar Transposition. It contains methods for [Encrypt](https://github.com/sandrarawat/file-encryption-tool/blob/9851242757098292e10df4ffa99d5cfddaa4adc9/src/ie/gmit/dip/PolybiusSquareCypher.java#L29) and [Decrypt](https://github.com/sandrarawat/file-encryption-tool/blob/9851242757098292e10df4ffa99d5cfddaa4adc9/src/ie/gmit/dip/PolybiusSquareCypher.java#L38) using the Stringbuilder. This class also utilises a [method for padding](https://github.com/sandrarawat/file-encryption-tool/blob/9851242757098292e10df4ffa99d5cfddaa4adc9/src/ie/gmit/dip/PolybiusSquareCypher.java#L49) to ensure the PolybiusSquare columns are equal to the keyword length. 


## Matrix 
Creates an array of original [indexes](https://github.com/sandrarawat/file-encryption-tool/blob/ee7ba404000cd78aa1260469b8cd06a4407a72d1/src/ie/gmit/dip/Matrix.java#L13) with the keyword as a header. The columns are [sorted](https://github.com/sandrarawat/file-encryption-tool/blob/ee7ba404000cd78aa1260469b8cd06a4407a72d1/src/ie/gmit/dip/Matrix.java#L19) alphabetically according to the keyword. The columns are initialised [to equal](https://github.com/sandrarawat/file-encryption-tool/blob/ee7ba404000cd78aa1260469b8cd06a4407a72d1/src/ie/gmit/dip/Matrix.java#L33) the number of characters in the key. Each character is added to the [correct column](https://github.com/sandrarawat/file-encryption-tool/blob/ee7ba404000cd78aa1260469b8cd06a4407a72d1/src/ie/gmit/dip/Matrix.java#L38). Finally,each character is [appended](https://github.com/sandrarawat/file-encryption-tool/blob/ee7ba404000cd78aa1260469b8cd06a4407a72d1/src/ie/gmit/dip/Matrix.java#L50) to the string builder, and stringbuilder is returned.
	

