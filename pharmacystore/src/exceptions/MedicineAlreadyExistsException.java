package exceptions;

public class MedicineAlreadyExistsException extends Exception {
    public MedicineAlreadyExistsException(String message){
        super(message);
    }
}
