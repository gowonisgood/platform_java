package Java_platform.Class_overloading.StaticMemberAndMethod;
import java.util.Map;
import java.util.HashMap;

public class EmployeeRepository {
    //your code here
    //private static final String d = "DEFALUT";
    //private static final Employee = new Employee(null,0);

    private static final EmployeeRepository Instance = new EmployeeRepository();

    private Map<String, Employee> employees = new HashMap<String, Employee>();

    private EmployeeRepository(){}

    public static EmployeeRepository getInstance() {
        //your code here
        return Instance;
    }

    public void add(Employee employee) {
        employees.put(employee.getName(), employee);
    }

    public boolean contains(Employee employee) {
        return employees.containsKey(employee.getName());
    }

    public Employee get(Employee employee) {
        return employees.get(employee.getName());
    }
}