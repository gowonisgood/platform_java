package Java_platform.MyScanner;
import java.util.regex.*;


public class MyScanner {

    String inputString;
    int currentIndex; //객체가 공유하는 변수
    Pattern pattern;

    public MyScanner(String input){
        this.inputString = input;
        this.currentIndex = 0;
    }

    public String next(){
        //      \s  Matches any space, tab or newline character.
        //      \S  Matches anything other than a space, tab or newline.
        Pattern wordPattern = Pattern.compile("\\S+");
        Matcher matcher = wordPattern.matcher(inputString);

        if (matcher.find(currentIndex)) {
            currentIndex = matcher.end();
            return matcher.group();
        }
        return "\0";
    }

    public int nextInt() {
        Pattern intPattern = Pattern.compile("-?\\d+");
        Matcher matcher = intPattern.matcher(inputString);

        if(matcher.find(currentIndex)){
            currentIndex = matcher.end();
            return Integer.parseInt(matcher.group());
        }
        return 0;
    }

    public Double nextDouble(){
        Pattern doublePattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        Matcher matcher = doublePattern.matcher(inputString);

        if(matcher.find(currentIndex)){
            currentIndex = matcher.end();
            return Double.parseDouble(matcher.group());
        }
        return 0.0;
    }

    public String nextLine(){
        Pattern linePattern = Pattern.compile(".*(\n|$)");
        Matcher matcher = linePattern.matcher(inputString);

        if(matcher.find(currentIndex)){
            currentIndex = matcher.end();
            return matcher.group();
        }
        return "\0";
    }

    public boolean hasNext(){
        Pattern wordPattern = Pattern.compile("\\S+");
        Matcher matcher = wordPattern.matcher(inputString);

        if(matcher.find(currentIndex)){
            currentIndex = matcher.end();
            return true;
        }
        return false;
    }

}
