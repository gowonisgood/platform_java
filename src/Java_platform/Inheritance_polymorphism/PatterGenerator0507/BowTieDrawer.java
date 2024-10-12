package Java_platform.Inheritance_polymorphism.PatterGenerator0507;
import java.lang.StringBuilder;
//package edu.pnu.draw
public class BowTieDrawer extends PatternDrawer {
    @Override
    public String drawPattern(int numOfLines) {
        StringBuilder sb = new StringBuilder();
        int n = (numOfLines + 1) / 2;
        //1.up
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                sb.append("*");
            }
            for (int m = 1; m <= (2 * n) - (2 * i); m++) {
                sb.append(" ");
            }
            for (int k = 1; k <= i; k++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        //2.down
        for (int i = 1; i < n; i++) {
            for (int j = n - i; j > 0; j--) {
                sb.append("*");
            }
            for (int m = 1; m <= 2 * i; m++) {
                sb.append(" ");
            }
            for (int k = n - i; k > 0; k--) {
                sb.append("*");
            }
            if(i==n-1) { break;}
            sb.append("\n");
        }
        String pattern = sb.toString();
        return pattern;
    }
}
