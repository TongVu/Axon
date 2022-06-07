package problem5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DailyInvoice extends Invoice implements TotalIncome{
    private int rentedDays;

    @Override
    public double total(){
        if(rentedDays > 7)
            return 7 * getPrice()
                    + 0.8 * (rentedDays - 7) * getPrice();

        return this.rentedDays * getPrice();
    }
}
