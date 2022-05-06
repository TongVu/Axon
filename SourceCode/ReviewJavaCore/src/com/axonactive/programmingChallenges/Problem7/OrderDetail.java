package com.axonactive.programmingChallenges.Problem7;

public class OrderDetail {
    private int quantity;
    private Product product;

    public OrderDetail(Product product, int quantity ) {
        this.quantity = quantity;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity){
        // do something here
    }

    public double calcTotalPrice(){ // quantity * price
        return 0.0d;
    }

    @Override
    public String toString(){
        return "Should return something here";
    }

}
