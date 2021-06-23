package ie.gmit.dip;

import java.util.HashMap;
import java.util.Map;

public class PolybiusSquare {
  private static final Map<Character, String> charTo_Encode = new HashMap<>();
  private static final Map<String, Character> encodeTo_Char = new HashMap<>();

  	//Hashmap to set alphabet letters to encoded character
  static {
    charTo_Encode.put('P', "AA");
    charTo_Encode.put('H', "AD");
    charTo_Encode.put('0', "AF");
    charTo_Encode.put('Q', "AG");
    charTo_Encode.put('G', "AV");
    charTo_Encode.put('6', "AX");
    charTo_Encode.put('4', "DA");
    charTo_Encode.put('M', "DD");
    charTo_Encode.put('E', "DF");
    charTo_Encode.put('A', "DG");
    charTo_Encode.put('1', "DV");
    charTo_Encode.put('Y', "DX");
    charTo_Encode.put('L', "FA");
    charTo_Encode.put('2', "FD");
    charTo_Encode.put('N', "FF");
    charTo_Encode.put('O', "FG");
    charTo_Encode.put('F', "FV");
    charTo_Encode.put('D', "FX");
    charTo_Encode.put('X', "GA");
    charTo_Encode.put('K', "GD");
    charTo_Encode.put('R', "GF");
    charTo_Encode.put('3', "GG");
    charTo_Encode.put('C', "GV");
    charTo_Encode.put('V', "GX");
    charTo_Encode.put('S', "VA");
    charTo_Encode.put('5', "VD");
    charTo_Encode.put('Z', "VF");
    charTo_Encode.put('W', "VG");
    charTo_Encode.put('7', "VV");
    charTo_Encode.put('B', "VX");
    charTo_Encode.put('J', "XA");
    charTo_Encode.put('9', "XD");
    charTo_Encode.put('U', "XF");
    charTo_Encode.put('T', "XG");
    charTo_Encode.put('I', "XV");
    charTo_Encode.put('8', "XX");

    // Additional alphabet
    charTo_Encode.put('-', "YA");
    charTo_Encode.put('.', "YD");
    charTo_Encode.put('(', "YF");
    charTo_Encode.put(')', "YG");
    charTo_Encode.put(',', "YX");
    charTo_Encode.put('?', "YV");
    charTo_Encode.put('!', "YY");
    charTo_Encode.put(';', "AY");
    charTo_Encode.put(':', "DY");
    charTo_Encode.put('_', "FY");
    charTo_Encode.put('=', "XY");
    charTo_Encode.put('*', "VY");
    charTo_Encode.put('\"', "AZ");
    charTo_Encode.put(' ', "DZ");
    charTo_Encode.put('&', "FZ");
    charTo_Encode.put('\'', "GZ");
    charTo_Encode.put('|', "XZ");
    charTo_Encode.put('\r', "VZ");
    charTo_Encode.put('/', "GY");
    charTo_Encode.put('#', "YZ");
    charTo_Encode.put('£', "ZA");
    charTo_Encode.put('$', "ZF");
    charTo_Encode.put('<', "ZG");
    charTo_Encode.put('>', "ZX");
    charTo_Encode.put('@', "ZF");
    charTo_Encode.put('\n', "ZY");
    charTo_Encode.put('^', "ZZ");

  //Hashmap to set encoded character to alphabet letters
    encodeTo_Char.put("AA", 'P');
    encodeTo_Char.put("AD", 'H');
    encodeTo_Char.put("AF", '0');
    encodeTo_Char.put("AG", 'Q');
    encodeTo_Char.put("AV", 'G');
    encodeTo_Char.put("AX", '6');
    encodeTo_Char.put("DA", '4');
    encodeTo_Char.put("DD", 'M');
    encodeTo_Char.put("DF", 'E');
    encodeTo_Char.put("DG", 'A');
    encodeTo_Char.put("DV", '1');
    encodeTo_Char.put("DX", 'Y');
    encodeTo_Char.put("FA", 'L');
    encodeTo_Char.put("FD", '2');
    encodeTo_Char.put("FF", 'N');
    encodeTo_Char.put("FG", 'O');
    encodeTo_Char.put("FV", 'F');
    encodeTo_Char.put("FX", 'D');
    encodeTo_Char.put("GA", 'X');
    encodeTo_Char.put("GD", 'K');
    encodeTo_Char.put("GF", 'R');
    encodeTo_Char.put("GG", '3');
    encodeTo_Char.put("GV", 'C');
    encodeTo_Char.put("GX", 'V');
    encodeTo_Char.put("VA", 'S');
    encodeTo_Char.put("VD", '5');
    encodeTo_Char.put("VF", 'Z');
    encodeTo_Char.put("VG", 'W');
    encodeTo_Char.put("VV", '7');
    encodeTo_Char.put("VX", 'B');
    encodeTo_Char.put("XA", 'J');
    encodeTo_Char.put("XD", '9');
    encodeTo_Char.put("XF", 'U');
    encodeTo_Char.put("XG", 'T');
    encodeTo_Char.put("XV", 'I');
    encodeTo_Char.put("XX", '8');

    // Additional alphabet
    encodeTo_Char.put("YA", '-');
    encodeTo_Char.put("YD", '.');
    encodeTo_Char.put("YF", '(');
    encodeTo_Char.put("YG", ')');
    encodeTo_Char.put("YX", ',');
    encodeTo_Char.put("YV", '?');
    encodeTo_Char.put("YY", '!');
    encodeTo_Char.put("AY", ';');
    encodeTo_Char.put("DY", ':');
    encodeTo_Char.put("FY", '_');
    encodeTo_Char.put("GY", '/');
    encodeTo_Char.put("XY", '=');
    encodeTo_Char.put("VY", '*');
    encodeTo_Char.put("AZ", '"');
    encodeTo_Char.put("DZ", ' ');
    encodeTo_Char.put("FZ", '&');
    encodeTo_Char.put("GZ", '\'');
    encodeTo_Char.put("XZ", '|');
    encodeTo_Char.put("VZ", '\r');
    encodeTo_Char.put("YZ", '#');
    encodeTo_Char.put("ZA", '£');
    encodeTo_Char.put("ZD", 'Û');
    encodeTo_Char.put("ZF", '$');
    encodeTo_Char.put("ZG", '<');
    encodeTo_Char.put("ZX", '>');
    encodeTo_Char.put("ZV", '@');
    encodeTo_Char.put("ZY", '\n');
    encodeTo_Char.put("ZZ", '^');
  }

  public String getEncode(char c) {
    String code = charTo_Encode.get(c);
    if (code == null) {
      throw new IllegalStateException(String.format("Invalid char: '%s'", c));
    }
    return code;
  }

  public char getChar(String code) {
    Character c = encodeTo_Char.get(code);
    if (c == null) {
      throw new IllegalStateException("Invalid code: " + code);
    }
    return c;
  }
}
