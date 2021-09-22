
#Polybius Square Assignment.
This program encrypts and decrypts from txt files, using a Polybuis Square Cypher.

![alt text](https://github.com/sandrarawat/file-encryption-tool/blob/master/fileencryptiontoolgif.gif "File Encryption Tool Gif")

##Classes

Runner 
	This class contains the main method. Using JFrame and JFilechooser this is where user selects file input and output which are required for encryption and decryption.  When the program is run, the user selects Input Filepath, Output Filepath and requires a specific keyword, which the user sets, in order for encryption and decryption to run.

PolybiusSquare
	This class sets the alphabet Characters to their encoded Characters and vice versa using a Hashmap.

EncryptDecrypt
	This class creates a matrix using the keyword and performs columnar transposition. This class creates encrypted text using the Polybius Square. For decryption it returns the encoded characters to original pairs. This class uses Stringbuilder to add [padding](https://github.com/sandrarawat/file-encryption-tool/blob/74dbc0d14c3ea038904a1b62e2671bbcd55add12/src/ie/gmit/dip/EncryptDecrypt.java#L46) to the Polybius Square to equal keyword length.

PolybiusSquareCypher
	This class contains the methods for encryption and decryption which uses the matrix and performs columnar Transposition. It contains methods for Encrypt and Decrypt using the Stringbuilder. This class also needs a method for padding the PolybiusSquare to equal keyword length. 


Matrix 
	This class is used for creating an array of original indexes and sorts columns alphabetically using the keyword, reads and loops over content column by column and reorders columns.
  
