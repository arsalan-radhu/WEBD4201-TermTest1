package webd4201.radhua;

/**
 * This class represents the Invalid Name Exception class
 * @author Arsalan Arif Radhu
 * @version 1.0
 * @since 1.0
 */
public class InvalidNameException extends Exception{

    //Attributes
    private static final long serialVersionUID = 1L;

    /**
     * Parametrized Constructor
     * @param message
     */
    public InvalidNameException(String message)
    {
        super(message);
    }

}
