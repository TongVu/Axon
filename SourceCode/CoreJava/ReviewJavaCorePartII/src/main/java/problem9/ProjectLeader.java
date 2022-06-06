package problem9;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProjectLeader extends Programmer{

    @Override
    public double getMonthlySalary() {
        return getTheBasicMonthlySalary() + 0.2 * getTheBasicMonthlySalary();
    }
}
