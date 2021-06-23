package ie.gmit.dip;

import java.util.ArrayList;
import java.util.List;

class Matrix {

  private final List<Integer> indexes;

  Matrix(String key) {

    // Create array of original indexes
    indexes = new ArrayList<>();
    for (int i = 0; i < key.length(); i++) {
      indexes.add(i);
    }

    // Sort by the label in the columns
    indexes.sort((i1, i2) -> {
 
      // Get the column labels for those indexes to compare
      Character col1Label = key.charAt(i1);
      Character col2Label = key.charAt(i2);

      return col1Label.compareTo(col2Label);
    });

  }

  String contentByColumns(String squareEncryptedContent) {
    List<List<Character>> columns = new ArrayList<>();

    // Initialise columns to equal number of letters the key
    for (int i = 0; i < indexes.size(); i++) {
      columns.add(new ArrayList<>());
    }

    // Loop over each letter in squareEncryptedContent and add to the correct column
    for (int i = 0; i < squareEncryptedContent.length(); i++) {
      // Compute correct column index
      int column = i % indexes.size();
      columns.get(column).add(squareEncryptedContent.charAt(i));
    }

    StringBuilder sb = new StringBuilder();

    // Loop over the columns in the sorted order
    for (int index : indexes) {
      // For each letter in the column, append to string builder
      for (char c : columns.get(index)) {
        sb.append(c);
      }
    }

    return sb.toString();
  }
  
  // Decrypt method
  String decrypt(String encrypted) {


    List<List<Character>> columns = new ArrayList<>();

    // Initialise columns to equal number of letters in the key
    for (int i = 0; i < indexes.size(); i++) {
      columns.add(new ArrayList<>());
    }

    // Compute how many of the columns have +1 item
    int minLettersPerColumn = encrypted.length() / indexes.size();
    int columnStartIndex = 0;

    // Fill the long columns
    for (int j = 0; j < encrypted.length() % indexes.size(); j++) {
      // Use minLettersPerColumn + 1 letters from the encrypted text
      for (int k = 0; k < minLettersPerColumn + 1; k++) {
        columns.get(j).add(encrypted.charAt(columnStartIndex + k));
      }
      columnStartIndex += minLettersPerColumn + 1;
    }

    // Fill the short columns
    for (int j = encrypted.length() % indexes.size(); j < columns.size(); j++) {
      // Use minLettersPerColumn + 1 letters from the encrypted text
      for (int k = 0; k < minLettersPerColumn; k++) {
        columns.get(j).add(encrypted.charAt(columnStartIndex + k));
      }
      columnStartIndex += minLettersPerColumn;
    }
    
    // Restore original order of columns from indexes and read row-by-row
    List<List<Character>> restored = new ArrayList<>();
    
    // Allocate list of the required size
    for (int i = 0; i < indexes.size(); i++) {
      restored.add(null);
    }
    // Set columns at the right positions
    for (int i = 0; i < indexes.size(); i++) {
      restored.set(indexes.get(i), columns.get(i));
    }

    // Read letters row-by-row
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < encrypted.length(); i++) {
      sb.append(restored.get(i % indexes.size()).get(i / indexes.size()));
    }
    
    // Return to String
    return sb.toString();
  }
}
