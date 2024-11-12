package Java_platform.Inheritance_polymorphism.PatterGenerator0507;
import java.lang.StringBuilder;
//package edu.pnu.draw
public class IsoscelesDrawer extends PatternDrawer {
    public String drawPattern(int numOfLines) {
        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=numOfLines;i++){
            
            for(int k=numOfLines-i;k>0;k--){
                sb.append(" ");
            }
            for(int j=0;j<i*2-1;j++){
                sb.append("+");
            }
            if(i==numOfLines) break;
            sb.append("\n");
        }
        String pattern = sb.toString();
        return pattern;
    }
}
