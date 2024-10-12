package Java_platform.prepare_lab1;

import java.util.Scanner;
import java.lang.StringBuilder;

public class characterEncoder{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String word = sc.nextLine();
        int n = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<word.length();i++){
            if(!Character.isLetter(word.charAt(i))){
                System.out.print("he string contains characters that cannot be encoded.");
                System.exit(0);
            }

            char c = shiftChar(word.charAt(i),n);
            sb.append(c);
        }

        System.out.print("Encoded string "+sb);
        sc.close();
    }
    public static char shiftChar(char c, int shift){
        char Base = Character.isUpperCase(c) ? 'A':'a';
        return (char)((c -Base+ shift)%26 + Base);
    }
}

