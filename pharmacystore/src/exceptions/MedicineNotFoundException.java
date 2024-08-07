package exceptions;

public class MedicineNotFoundException extends Exception{
    public MedicineNotFoundException(String message){
        super(message);
    }
}
