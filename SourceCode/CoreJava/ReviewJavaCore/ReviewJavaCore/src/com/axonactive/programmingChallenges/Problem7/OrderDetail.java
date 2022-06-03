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

    public Product getProduct() {
        return product;
    }

    public void setQuantity(int quantity){
        while(quantity < 0){
            System.out.println("QUANTITY HAVE TO BE A POSITIVE NUMBER. ENTER AGAIN: ");
            setQuantity(quantity);
        }
        this.quantity = quantity;
    }

    public double calcTotalPrice(){ // quantity * price
        return product.getPrice() * (double)quantity;
    }

    @Override
    public String toString(){
        return product.toString() + "QUANTITY : " + quantity + "\n";
    }

}
