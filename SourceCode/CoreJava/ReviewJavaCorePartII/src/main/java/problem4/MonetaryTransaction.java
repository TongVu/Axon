package problem4;

import lombok.*;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MonetaryTransaction extends Transaction {
    private String id;
    private LocalDate transactionalDate;
    private double price;
    private int quantity;
    private String type; // usd, EURO, VN

    private double unitPrice;

    @Override
    public double totalExchange(){
        return this.unitPrice * this.getPrice() * this.getQuantity();
    }
}
