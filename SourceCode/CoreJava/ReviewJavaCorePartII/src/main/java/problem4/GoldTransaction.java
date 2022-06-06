package problem4;

import lombok.*;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class GoldTransaction extends Transaction {
    private String id;
    private LocalDate transactionalDate;
    private double price;
    private int quantity;
    private String type;
}
