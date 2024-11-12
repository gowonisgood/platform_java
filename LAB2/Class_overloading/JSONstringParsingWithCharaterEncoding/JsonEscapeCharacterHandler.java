package Java_platform.Class_overloading.JSONstringParsingWithCharaterEncoding;

public class JsonEscapeCharacterHandler {

    public String handleEscapedCharacters(String str) {

        StringBuilder result = new StringBuilder();

        boolean isEscaping = false;

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);
            //result.append(c);
            // Implement your code
            if(c=='\\'){
                isEscaping =true;
            }

            if(isEscaping){
                switch(c) {
                    case 'n':
                        result.append("\n");
                        isEscaping = false;
                        break;
                    case '"':
                        result.append('"');
                        isEscaping = false;
                        break;
                    case 'u':
                        if(i+4 < str.length()){
                            String hexCode = str.substring(i+1, i+5);
                            char unicodeChar = (char)Integer.parseInt(hexCode,16);
                            result.append(unicodeChar);
                            i=i+4;
                        }
                        isEscaping = false;
                        break;
                    default:
                        break;

                    }
                }
            else {
                result.append(c);
                isEscaping = false;
            }



        }

        return result.toString();

    }
}