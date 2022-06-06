package problem4;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public abstract class Transaction implements TransactionExchange{
    private String id;
    private LocalDate transactionalDate;
    private double price;
    private int quantity;
    private String type;

    @Override
    public double totalExchange(){
        return this.quantity * this.price;
    }
}
