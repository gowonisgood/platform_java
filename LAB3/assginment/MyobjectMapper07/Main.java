import controller.TestController;
import mapper.JsonRequestProcessor;

public class Main {
    public static void main(String[] args) throws Exception {
        TestController controller = new TestController();

        String personJsonString = "{\"name\": \"Jöhn Döe\", \"age\": 30}";
        JsonRequestProcessor.processRequest(controller, "savePerson", personJsonString);

        String studentJsonString = "{\"studentName\": \"Alice\", \"studentId\": 123, \"gpa\": 3.5}";
        JsonRequestProcessor.processRequest(controller, "saveStudent", studentJsonString);
    }
}
