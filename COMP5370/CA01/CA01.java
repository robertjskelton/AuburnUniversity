// Robert Skelton
// COMP 5370
// 9.21.2014 

import java.util.*;
import java.io.*;
@SuppressWarnings("unchecked")

public class CA01 {
    // main method to take in a string and key and encypt it
    public static void main(String[] args) throws IOException {
        String plaintext = "";
        String key = "";

        Scanner s = null;
        try {
                    s = new Scanner(new BufferedReader(new FileReader("plaintext.txt")));
                    key = s.nextLine();

                    while (s.hasNextLine()) {
                        plaintext += s.nextLine();
                    }
                } finally {
                    if (s != null) {
                        s.close();
                    }
                }

        String encryptedKey = encrypt(plaintext, key);

        // Print out result to result.txt
        File file = new File("result.txt");
        file.createNewFile();
        FileWriter writer = new FileWriter(file); 
        writer.write("\nPlaintext:         " + plaintext);
        writer.write("\nKey:               " + key);
        writer.write("\nEncrypted Message: " + encryptedKey);
        writer.flush();
        writer.close();     
    }

    // method for running encyption based on the Vigenere tableau
    static String encrypt(String text, String key) {
        ArrayList result1 = new ArrayList(); // result for storing all characters
        ArrayList temp1 = new ArrayList();   // used to store values of the plaintext
        ArrayList temp2 = new ArrayList();   // used to store values of the key
        ArrayList c = new ArrayList();       // used to store plaintext+key value
        ArrayList cN = new ArrayList();      // used to store eToDaI

        String result = "";
        int p1 = 0; // used to store value of char from plaintext
        int k1 = 0; // used to store value of char from key
        int shift = 0;
        text = text.toUpperCase(); // the entire string must be in upper case
        key = key.toUpperCase();
        int r = 0;
        for (int i = 0; i < text.length(); i++) {
            char p = text.charAt(i); // p i the ith letter of the plaintext c
            char k = key.charAt(r);  // k is the ith letter of the key
            p1 = convert(p); // step1, plaintext
            temp1.add(p1);
            k1 = convert(k); // step2, key
            temp2.add(k1);  
            shift = p1 + k1; // step3, plaintext shifted by key, d(pi)+d(ki)
            c.add(shift);
            // ei is the ith letter of the enciphered text
            // screw it, heres everything in one huge step
            if (i == 0)
                cN.add(((int)temp1.get(i) + (int)temp2.get(r)) % 38);

            else      
                cN.add(((int)temp1.get(i) + (int)temp2.get(r) + (int)cN.get(i-1)) % 38);
            // THIS IS CORRECT! 
            // now just convert back to letters (maybe new switch case)
            // and then add I/O Functionality
            r = ++r % (key.length());
        }

        for (int poop = 0; poop < cN.size(); poop++) { // creative variable names
                result += deconvert((int)cN.get(poop)); 
            }

            return result.toUpperCase();
        }

    // method to convert all letters and numbers into the appropriate numbers
        static int convert(char a) {
            int value = 0;
            switch(a) {
                case ' ' : value = 0; break;
                case 'A' : value = 1; break;
                case 'B' : value = 2; break;
                case 'C' : value = 3; break;
                case 'D' : value = 4; break;
                case 'E' : value = 5; break;
                case 'F' : value = 6; break;
                case 'G' : value = 7; break;
                case 'H' : value = 8; break;
                case 'I' : value = 9; break;
                case 'J' : value = 10; break;
                case 'K' : value = 11; break;
                case 'L' : value = 12; break;
                case 'M' : value = 13; break;
                case 'N' : value = 14; break;
                case 'O' : value = 15; break;
                case 'P' : value = 16; break;
                case 'Q' : value = 17; break;
                case 'R' : value = 18; break;
                case 'S' : value = 19; break;
                case 'T' : value = 20; break;
                case 'U' : value = 21; break;
                case 'V' : value = 22; break;
                case 'W' : value = 23; break;
                case 'X' : value = 24; break;
                case 'Y' : value = 25; break;
                case 'Z' : value = 26; break;
                case '0' : value = 27; break;
                case '1' : value = 28; break;
                case '2' : value = 29; break;
                case '3' : value = 30; break;
                case '4' : value = 31; break;
                case '5' : value = 32; break;
                case '6' : value = 33; break;
                case '7' : value = 34; break;
                case '8' : value = 35; break;
                case '9' : value = 36; break;
                default : value = 37; break;
            }
            return value;
        }

        static char deconvert(int a) {
            char value;
            switch(a) {
                case 0  : value = ' '; break;
                case 1 : value = 'A'; break;
                case 2 : value = 'B'; break;
                case 3 : value = 'C'; break;
                case 4 : value = 'D'; break;
                case 5 : value = 'E'; break;
                case 6 : value = 'F'; break;
                case 7 : value = 'G'; break;
                case 8 : value = 'H'; break;
                case 9 : value = 'I'; break;
                case 10 : value = 'J'; break;
                case 11 : value = 'K'; break;
                case 12 : value = 'L'; break;
                case 13 : value = 'M'; break;
                case 14 : value = 'N'; break;
                case 15 : value = 'O'; break;
                case 16 : value = 'P'; break;
                case 17 : value = 'Q'; break;
                case 18 : value = 'R'; break;
                case 19 : value = 'S'; break;
                case 20 : value = 'T'; break;
                case 21 : value = 'U'; break;
                case 22 : value = 'V'; break;
                case 23 : value = 'W'; break;
                case 24 : value = 'X'; break;
                case 25 : value = 'Y'; break;
                case 26 : value = 'Z'; break;
                case 27 : value = '0'; break;
                case 28 : value = '1'; break;
                case 29 : value = '2'; break;
                case 30 : value = '3'; break;
                case 31 : value = '4'; break;
                case 32 : value = '5'; break;
                case 33 : value = '6'; break;
                case 34 : value = '7'; break;
                case 35 : value = '8'; break;
                case 36 : value = '9'; break;
                default : value = '.'; break;
            }
            return value;
        }
    } 