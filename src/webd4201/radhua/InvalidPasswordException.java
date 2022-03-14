package webd4201.radhua;

/**
 * This class represents the Invalid Password Exception class
 * @author Arsalan Arif Radhu
 * @version 1.0
 * @since 1.0
 */

public class InvalidPasswordException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * parameterized constructor
     * @param message
     */
    public InvalidPasswordException(String message)
    {
        super(message);
    }


}
