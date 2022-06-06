package problem9;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Programmer extends Employee{
    private String theLanguage;

    @Override
    public double getMonthlySalary() {
        if(this.theLanguage.equalsIgnoreCase("java"))
            return getTheBasicMonthlySalary() + 0.2 * getTheBasicMonthlySalary();
        return getTheBasicMonthlySalary();
    }
}
