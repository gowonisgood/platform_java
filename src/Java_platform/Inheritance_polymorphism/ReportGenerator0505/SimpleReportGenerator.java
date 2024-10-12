package Java_platform.Inheritance_polymorphism.ReportGenerator0505;
import java.util.*;
public class SimpleReportGenerator extends AbstractReportGenerator {
    protected boolean customerReportCondition(Customer customer) {
        return true ;
    }
    protected String getReportHeader(List<Customer> customers) {
        return String.format("고객의 수: %d 명\n", customers.size()) ;
    }
    protected String getReportForCustomer(Customer customer) {
        return String.format("%s: %d\n", customer.getName(),
                customer.getPoint()) ;
    }
    protected String getReportFooter(List<Customer> customers) {
        return "" ;
    }

}

