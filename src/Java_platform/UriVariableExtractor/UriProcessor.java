package Java_platform.UriVariableExtractor;
import java.util.*;
import java.util.regex.*;

public class UriProcessor {
    private final Map<String, String> patternMappings;

    public UriProcessor(Map<String, String> patternMappings) {

        this.patternMappings = patternMappings;

    }


    public List<String> extractVariableValues(String request,String url){
        List<String> values = new ArrayList<String>();

        String urlTemplate = "/students/{studentId}/course/{courseId}";
        String regex = patternMappings.get(request+" "+urlTemplate);

        Pattern pattern = Pattern.compile(regex);
        //Pattern pattern = Pattern.compile("^GET\\/students\\/(\\w+)\\/course\\/(\\w+)$");
        Matcher matcher = pattern.matcher(request+" "+url);

        if(matcher.matches()){
            for(int i=1;i<=matcher.groupCount();i++){
                values.add(matcher.group(i));
            }
        }

        return values;
    }

    public List<String> extractVariableNames(String request, String url){
        List<String> Names = new ArrayList<String>();
        String key = request + " /students/{studentId}/course/{courseId}";

        //String urlTemplate = "/students/{studentId}/course/{courseId}";
        //String regex = patternMappings.get(request+" "+urlTemplate);

        Pattern pattern = Pattern.compile("\\{(\\w+)\\}");
        //Pattern pattern = Pattern.compile("^GET\\/students\\/(\\w+)\\/course\\/(\\w+)$");
        Matcher matcher = pattern.matcher(key);

        while(matcher.find()){
            Names.add(matcher.group(1));
        }

        return Names;
    }



    // implement your code
}
