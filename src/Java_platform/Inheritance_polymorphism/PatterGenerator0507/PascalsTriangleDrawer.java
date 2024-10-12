package Java_platform.Inheritance_polymorphism.PatterGenerator0507;
import java.lang.StringBuilder;
//package edu.pnu.draw
public class PascalsTriangleDrawer extends PatternDrawer{
    @Override
    public String drawPattern(int numOfLines){
        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=numOfLines;i++){
            int c = 1;
            for(int j=numOfLines-i;j>0;j--){
                sb.append(" ");
            }
            for(int k=1;k<=i;k++){
                sb.append(c);
                c = c*(i-k)/k;
                sb.append(" ");
            }
            if(i==numOfLines) break;
            sb.append("\n");
        }

        String pattern = sb.toString();
        return pattern;
    }


}
