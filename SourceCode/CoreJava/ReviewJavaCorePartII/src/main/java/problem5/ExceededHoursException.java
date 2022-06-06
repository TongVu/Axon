package problem5;

public class ExceededHoursException extends Exception{
    public ExceededHoursException(){
        super("The rented hours is larger than 30 hours");
    }
}
