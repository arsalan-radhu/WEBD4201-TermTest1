package webd4201.radhua;

/**
 * This class represents the College Interface class
 * @author Arsalan Arif Radhu
 * @version 1.0
 * @since 1.0
 */

public interface CollegeInterface {
    //Declarations
    /**
     * Stores the name of the College
     */
    final String COLLEGE_NAME = "Durham College";
    /**
     * Stores the phone number
     */
    final String PHONE_NUMBER = "(905)742-2000";
    /**
     * Stores the minimum ID number
     */
    final long MINIMUM_ID_NUMBER = 100000000;
    /**
     * Stores the maximum ID number
     */
    final long MAXIMUM_ID_NUMBER = 999999999;
    /**
     * Stores the minimum password length
     */
    final byte MINIMUM_PASSWORD_LENGTH = 8;
    /**
     * Stores the maximum password length
     */
    final byte MAXIMUM_PASSWORD_LENGTH = 20;

    /**
     * Method header for getTypeForDisplay()
     * @return
     */

    public abstract String getTypeForDisplay();

}