package problem2;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Worker implements Comparable<Worker>{
    private int id;
    private String lastName;
    private String firstName;
    private int products;

    public double calculateUnitPrice() {
        if (products < 200) return 0.5;
        else if (products < 400) return 0.55;
        else if (products < 600) return 0.6;

        return 0.65;
    }

    public double calculateSalary() {
        return products * calculateUnitPrice();
    }

    @Override
    public int compareTo(Worker o) {
        return -(this.products - o.getProducts());
    }
}
