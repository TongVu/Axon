package problem5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HourlyInvoice extends Invoice implements TotalIncome{
    private int rentedHours;

    @Override
    public double total() throws ExceededHoursException { // catch exception should be in setter
        if(rentedHours > 30) throw new ExceededHoursException();
        if (24 < rentedHours && rentedHours < 30)
            return 24 * getPrice();

        return rentedHours * getPrice();
    }
}
