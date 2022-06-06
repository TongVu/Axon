package problem9;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Employee implements Comparable<Employee> {
    private int payrollNumber;
    private String name;
    private double theBasicMonthlySalary;

    public abstract double getMonthlySalary();

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Employee)) return false;
        if (this == o) return true;
        Employee employee = (Employee) o;
        return payrollNumber == employee.payrollNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(payrollNumber);
    }

    @Override
    public int compareTo(Employee e){
        return this.name.compareTo(e.getName());
    }
}

