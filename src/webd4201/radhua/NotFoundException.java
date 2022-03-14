package webd4201.radhua;


public class NotFoundException extends Throwable {
    /**
     * Default serial Version UID
     */
    private static final long serialVersionUID = 1L;
    /**
     * Parameterized constructor
     * @param message of the exception
     */
    public NotFoundException(String message) {
        super(message);
    }

    /**
     * Default constructor
     */
    public NotFoundException() {
        super();
    }

}
