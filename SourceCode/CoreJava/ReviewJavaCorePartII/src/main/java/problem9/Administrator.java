package problem9;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Administrator extends Employee{
    private String department;

    @Override
    public double getMonthlySalary() {
        return getTheBasicMonthlySalary() + 0.4 * getTheBasicMonthlySalary();
    }
}
