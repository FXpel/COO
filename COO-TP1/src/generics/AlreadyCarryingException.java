package generics;

public class AlreadyCarryingException extends IllegalStateException{

    public AlreadyCarryingException(){}

    public String getMessage(){
        return "Already carry something.";
    }
}
