package webd4201.radhua;

/**
 * This class represents the Invalid Exception class
 * @author Arsalan Arif Radhu
 * @version 1.0
 * @since 1.0
 */

public class InvalidUserDataException extends Exception{

    //Attributes
    private static final long serialVersionUID = 1L;


    /*
     * Parameterized Constructor
     * @param message
     */
    public InvalidUserDataException(String message)
    {
        super(message);
    }

}
