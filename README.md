
Polybius Square Assignment.
The Project entitled polybius-square-java contain 5 Classes outlined below.
References are found at the bottom of each class. This program encrypts and decrypts from txt files.
<p align="center">
  <img src="(https://github.com/sandrarawat/file-encryption-tool/blob/master/fileencryptiontoolgif.gif "File Encryption Tool Gif")" alt="animated" />
</p>

![alt text](https://github.com/sandrarawat/file-encryption-tool/blob/master/fileencryptiontoolgif.gif "File Encryption Tool Gif")

Runner 
	This class contains the main method. Using JFrame and JFilechooser this is where user input and output occur which are required for encryption and decryption.  When the program is run, the user selects Input Filepath, Output Filepath and requires a specific keyword, which the user sets, in order for encryption and decryption to run.


PolybiusSquare
	This class sets the alphabet Characters to their encoded Characters and vice versa using a Hashmap.

EncryptDecrypt
	This class creates a matrix using the  keyword and performs columnar transposition. This class creates encrypted text using the Polybius Square. For decryption it returns the encoded characters to original pairs. This class uses Stringbuilder to add padding to the Polybius Square to equal keyword length.


PolybiusSquareCypher
	This class contains the methods for encryption and decryption which uses the matrix and performs columnar Transposition. It contains methods for Encrypt and Decrypt using the Stringbuilder. This class also needs a method for padding the PolybiusSquare to equal keyword length. 


Matrix 
	This class is used for creating an array of original indexes and sorts columns alphabetically using the keyword, reads and loops over content column by column and reorders columns.
  
