/**
 * Created by smtt on 4/9/17.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class ProductCipher {
    public static void main(String args[]) throws IOException {
        String substitutionInput = " ";
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            substitutionInput = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
        System.out.println("Plain text:");
        System.out.println(substitutionInput);

        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        ArrayList<Character> charList= new ArrayList();
        for(char s:chars){
            charList.add(s);
        }
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int o = random.nextInt(Math.min(substitutionInput.length(),10))+3;
        for (int i = 0; i < o; i++) {
            char c = chars[random.nextInt(chars.length)];
            if(charList.contains(c)) {
                charList.remove(charList.indexOf(c));
                sb.append(c);
            }
        }
        String key = sb.toString();
        int n = key.length();
// Substitution
        StringBuffer substitutionOutput = new StringBuffer();
        for (int i = 0; i < substitutionInput.length(); i++) {
            char c = substitutionInput.charAt(i);
            substitutionOutput.append((char) (c + 5));
        }
        System.out.println("\nSubstituted key:");
        System.out.println(substitutionOutput);

// Transposition
        String transpositionInput = substitutionOutput.toString();
        int modulus;
        if ((modulus = transpositionInput.length() % n) != 0) {
            modulus = n - modulus;

            for (; modulus != 0; modulus--) {
                transpositionInput += "%";
            }
        }
        StringBuffer transpositionOutput = new StringBuffer();
        System.out.println("\nTransposition Matrix:");
        int l =0;
        char[][] transPositionMatrix = new char[transpositionInput.length()/n][n];
        for (int i=0;i<transpositionInput.length() / n;i++){
            for (int j=0;j<n;j++){
                transPositionMatrix[i][j] = transpositionInput.charAt(l);
                l++;
            }
        }
        System.out.println(Arrays.deepToString(transPositionMatrix));



        char [] textA = key.toCharArray();
        int [] order = new int[key.length()];
        for (int i=0;i<textA.length ; i++){
            int k=0;
            for (int j=0;j<textA.length;j++){
                if(textA[i]!=textA[j]){
                    if(Character.toLowerCase(textA[i])>Character.toLowerCase(textA[j])) {
                        k++;
                    }
                }
                order[i]=k;
            }
        }

        for(int i: order){
            for(int j = 0;j<transpositionInput.length()/n;j++){
                transpositionOutput.append(transPositionMatrix[j][i]);
            }
        }

        System.out.println("\nFinal encrypted key:");
        System.out.println(transpositionOutput);

// Transposition decryption
        StringBuffer transpositionPlaintext = new StringBuffer();
        String [] array = transpositionOutput.toString().split("(?<=\\G.{"+transpositionInput.length()/n+"})");
        char [][] decryptMarix = new char[transpositionInput.length()/n][n];
        int p = 0;
        for (int i =0;i<order.length;i++){
                for(int k =0;k<transpositionInput.length()/n;k++) {
                    decryptMarix[k][order[i]] = array[i].charAt(k);
                }
            }
        System.out.println("\nDecrypt Matrix");
        System.out.println(Arrays.deepToString(decryptMarix));



        for (int i=0;i<transpositionInput.length() / n;i++){
            for (int j=0;j<n;j++){
                transpositionPlaintext.append(decryptMarix[i][j]);
            }
        }

        System.out.println("\nTransposition plaintext");
        System.out.println(transpositionPlaintext);

//Substitution decryption
        StringBuffer plaintext = new StringBuffer();
        for(int i=0 ; i<transpositionPlaintext.length() ; i++) {
            char c = transpositionPlaintext.charAt(i);
            plaintext.append((char) (c-5));
        }

        System.out.println("\nPlaintext:");
        System.out.println(plaintext);
    }
}