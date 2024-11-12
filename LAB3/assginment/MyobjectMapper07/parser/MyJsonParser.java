package parser;
// Reuse the MyJsonParser implemented in Assignment 042, if possible.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class MyJsonParser {

    public MyJsonParser() {
        //Implement your code

    }

    public HashMap<String, Object> parse(String jsonString) throws Exception {
        //Implement your code
        var map = parseJSONString(jsonString);
        //var jS = convertHashMapToJSONString(map);
        //return (HashMap<String, Object>)jS;
        //return convertStringToPrettyJSON(jS);
        return map;
    }

    private static HashMap<String, Object> parseJSONString(String json) {
        HashMap<String, Object> parsedMap = new HashMap<>();
        json = json.substring(1,json.length()-1); //양쪽 대괄호 제거

        for(String keyValue : splitJson(json)){
            String[] tokens = keyValue.split(":",2);

            String key = tokens[0].trim();
            key = key.substring(1,key.length()-1); //쌍따옴표 제거
            Object value = stringToObject(tokens[1]); //String 을 오브젝트로 바꿔줌
            parsedMap.put(key, value);
        }
        return parsedMap;
    }

    private static ArrayList<String> splitJson(String json) {
        json = json.trim();
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int brackets = 0;
        int brace = 0;
        boolean isString = false;

        for(int i = 0; i < json.length(); i++){
            char c = json.charAt(i);
            sb.append(c);
            switch(c){
                case '{' -> brackets++;
                case '}' -> brackets--;
                case '[' -> brace++;
                case ']' -> brace--;
                case '"' -> isString = !isString;
            }

            if (brackets ==0 && brace ==0 && !isString && c == ',' ) {
                sb.deleteCharAt(sb.length()-1); //쉼표 제거
                list.add(sb.toString());
                sb.setLength(0);
            }
        }
        list.add(sb.toString());
        return list;
    }

    private static Object stringToObject(String value) {
        value = value.trim();
        char c = value.charAt(0);

        switch(c){
            case '{'-> {
                return parseJSONString(value);
            }
            case '['-> {
                ArrayList<Object> valueList = new ArrayList<>();
                value = value.substring(1,value.length()-1); //양쪽 대괄호 제거
                for(String token : splitJson(value)){
                    valueList.add(stringToObject(token));
                }
                return valueList;
            }
            case '"'->{
                return value.substring(1,value.length()-1);
            }
            default -> {
                return parseInsOrDoubleBooleanOrRaw(value);
            }
        }
    }

    private static Object parseInsOrDoubleBooleanOrRaw(String value) {
        try{
            return Integer.parseInt(value);
        }catch (Exception e1){
            try{
                return Double.parseDouble(value);
            } catch (Exception e2){
                try{
                    return Boolean.parseBoolean(value);
                }catch (Exception e3){
                    e3.printStackTrace();
                    return value;
                }
            }
        }
    }

    private static String convertHashMapToJSONString(HashMap<String, Object> map) {
        StringBuilder sb = new StringBuilder("{");
        for(String key : getTreeMap(map).keySet()){
            sb.append(String.format("\"%s\":%s,",key,objectToString(map.get(key))));
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("}");

        return sb.toString();
    }

    public static <K,V> Map<K,V> getTreeMap(Map<K,V> hashMap){
        Map<K,V> treeMap = new TreeMap<>();
        for(Map.Entry<K,V> entry : hashMap.entrySet()){
            treeMap.put(entry.getKey(), entry.getValue());
        }
        return treeMap;
    }

    private static String objectToString(Object o){
        if(o instanceof ArrayList){
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for(Object value: (ArrayList<Object>)o){
                sb.append(objectToString(value));
                sb.append(',');
            }
            sb.deleteCharAt(sb.length()-1);
            //if(sb.length()>1) sb.deleteCharAt(sb.length()-2);
            sb.append(']');
            return String.format("\"%s\"",sb.toString());
            //return sb.toString();
        }else if(o instanceof HashMap){
            return convertHashMapToJSONString((HashMap<String,Object>)o);
        }else if (o instanceof String){
            return String.format("\"%s\"",o);
        }else{
            return o.toString();
        }
    }

    private static String convertStringToPrettyJSON(String jsonString){
        StringBuilder sb = new StringBuilder();
        int spaces = 0; //띄워쓰기 횟수
        boolean isString = false;

        for(int i = 0; i < jsonString.length(); i++){
            char c = jsonString.charAt(i);
            boolean isArray = false;
            if(isString) {
                sb.append(c);
                if (c == '"') {
                    isString = false;
                }
                continue;
            }
            switch(c){
                case '{','[' -> {
                    spaces += 2;
                    sb.append(c);
                    sb.append('\n');
                    sb.append(" ".repeat(spaces));
                }
                case '}',']'->{
                    spaces -= 2;
                    sb.append('\n');
                    sb.append(" ".repeat(spaces));
                    sb.append(c);
                }
                case '"'->{
                    isString = true;
                    sb.append(c);
                }
                case ','->{
                    sb.append(c);
                    sb.append('\n');
                    sb.append(" ".repeat(spaces));
                }
                case ':'->{
                    sb.append(c);
                    sb.append(' ');
                }
                default -> sb.append(c);
            }
        } /*else{
                if(c=='"'){
                    isString = true;
                }
                sb.append(c);
            }*/

        return sb.toString();
    }


}