package problem5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public abstract class Invoice {
    private String id;
    private LocalDate date;
    private String customerName;
    private String roomId;
    private double price;

    @Override
    public boolean equals(Object o){
        return (o instanceof Invoice
                && ((Invoice) o).getId().equalsIgnoreCase(this.id));
    }

    public abstract double total() throws ExceededHoursException;
}
