package Problem3;
import java.util.List;

public class Department {
    private String departmentName;
    private List<Employee> listOfEmployee;

    public Department(){}

    public String getDepartmentName(){
        return this.departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void addEmployee(Employee employee){ // employee is from usr input
        listOfEmployee.add(employee);
    }
    public void display(){
        // show something here
    }

    @Override
    public String toString(){
        return "return a string";
    }
}
