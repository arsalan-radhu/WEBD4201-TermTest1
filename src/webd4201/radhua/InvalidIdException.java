package webd4201.radhua;

/**
 * This class represents the Invalid Exception class
 * @author Arsalan Arif Radhu
 * @version 1.0
 * @since 1.0
 */

public class InvalidIdException extends Exception{
    private static final long serialVersionUID = 1L;

    public InvalidIdException(String message)
    {
        super(message);
    }

    public InvalidIdException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public InvalidIdException(Throwable cause)
    {
        super(cause);
    }

    public InvalidIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public InvalidIdException()
    {

    }

}
