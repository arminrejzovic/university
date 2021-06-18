package FinalExam;

public class DigitNotALlowedException extends Exception {

    public DigitNotALlowedException( )
    {
        super("Digits are not allowed!");
    }

    public DigitNotALlowedException(String message)
    {
        super(message);
    }
}