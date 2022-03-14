package webd4201.radhua;

/*
 * This class represents the User class
 * @author Arsalan Arif Radhu
 * @version 1.0
 * @since 1.0
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class User implements CollegeInterface{

    // Class Attributes
    /**
     * Default ID of User
     */
    protected static long DEFAULT_ID = 100123456;

    /**
     * Default Password of User
     */
    protected static String DEFAULT_PASSWORD = "password";

    /**
     * Minimum password length for User
     */
    public static final byte MINIMUM_PASSWORD_LENGTH = 8;

    /**
     * Maximum password length for User
     */
    public static final byte MAXIMUM_PASSWORD_LENGTH = 40;

    /**
     * Default First Name of User
     */
    protected static String DEFAULT_FIRST_NAME = "John";

    /**
     * Default Last Name of User
     */
    protected static String DEFAULT_LAST_NAME = "Doe";

    /**
     * Default Email Address of User
     */
    protected static String DEFAULT_EMAIL_ADDRESS = "john.doe@dcmail.com";

    /**
     * Default Status of User
     */
    protected static boolean DEFAULT_ENABLED_STATUS = true;

    /**
     * Default type of User
     */
    public static char DEFAULT_TYPE = 's';

    /**
     * Maximum number of characters in an ID
     */
    public static final long MINIMUM_ID_NUMBER = 100000000L;

    /**
     * Minimum number of characters in an ID
     */
    public static final long MAXIMUM_ID_NUMBER = 999999999L;

    /**
     * Maximum length of an ID
     */
    protected static byte ID_NUMBER_LENGTH = 9;

    /**
     * Format of Date
     */
    public static final DateFormat DF =
            DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CANADA);

    // Instance Attributes
    /**
     * Instance attribute of ID for a user
     */
    private long id;

    /**
     * Instance attribute of Password for a user
     */
    private String password;

    /**
     * Instance attribute of First Name for a user
     */
    private String firstName;

    /**
     * Instance attribute of Last Name for a user
     */
    private String lastName;

    /**
     * Instance attribute of Email Address for a user
     */
    private String emailAddress;

    /**
     * Instance attribute of Last Access for a user
     */
    private Date lastAccess;

    /**
     * Instance attribute of Date of enrolment for a user
     */
    private Date enrolDate;

    /**
     * Instance attribute of Enable for a user
     */
    private boolean enabled;

    /**
     * Instance attribute of type for a user
     */
    private char type;

    /**
     * accessor for ID
     * @return the id of User
     */
    public long getId()
    {
        return this.id;
    }

    /**
     * accessor for password
     * @return the password of User
     */
    public String getPassword()
    {
        return this.password;
    }

    /**
     * accessor for first name
     * @return the firstName of the User
     */
    public String getFirstName()
    {
        return this.firstName;
    }

    /**
     * accessor for last Name
     * @return the lastName
     */
    public String getLastName()
    {
        return this.lastName;
    }

    /**
     * accessor for email Address
     * @return the emailAddress
     *
     */
    public String getEmailAddress()
    {
        return this.emailAddress;
    }

    /**
     * accessor for lastAccess
     * @return the lastAccess
     */
    public Date getLastAccess()
    {
        return this.lastAccess;
    }

    /**
     * accessor for enrolDate
     * @return the enrolDate
     */
    public Date getEnrolDate()
    {
        return this.enrolDate;
    }

    /**
     * accessor for enabled
     * @return the enabled
     */
    public boolean enabled()
    {
        return this.enabled;
    }

    /**
     * accessor for type
     * @return the type
     */
    public char getType()
    {
        return this.type;
    }

    /**
     * mutator for ID
     * @param id - the ID to set
     * @throws InvalidIdException - Exception
     */
    public void setId(long id) throws InvalidIdException {
        if (verifyId(id)) {
            this.id = id;
        } else {
            throw new InvalidIdException(id + " is not a valid ID number.");
        }
    }

    /**
     * mutator for password
     * @param password - the Password to set
     * @throws InvalidPasswordException - Wrong password exception
     */
    public void setPassword(String password) throws InvalidPasswordException {
        if (password.length() >= MINIMUM_PASSWORD_LENGTH && password.length() <= MAXIMUM_PASSWORD_LENGTH) {
            this.password = password;
        } else {
            throw new InvalidPasswordException("The length of the password must be between"+ MINIMUM_PASSWORD_LENGTH + " and "+ MAXIMUM_PASSWORD_LENGTH + " characters long.");
        }
    }

    /**
     * mutator for firstName
     * This method validates the first name of User by not letting empty values or numeric values
     * @param firstName - the FirstName to set
     * @throws InvalidNameException - Wrong name entered.
     */
    public void setFirstName(String firstName) throws InvalidNameException {
        boolean isValid = false;

        try {
            double var3 = Double.parseDouble(firstName);
        } catch (NumberFormatException var5) {
            isValid = true;
        }

        if (!firstName.isEmpty() && isValid) {
            this.firstName = firstName;
        } else {
            throw new InvalidNameException(firstName + " is not a valid name. Make sure there are no numbers or special characters.");
        }
    }

    /**
     * mutator for lastName
     * This method validates the last name of User by not letting empty values or numeric values
     * @param lastName - the LastName to set
     * @throws InvalidNameException - Wrong name
     */
    public void setLastName(String lastName) throws InvalidNameException {
        boolean flag = false;

        try
        {
            double var3 = Double.parseDouble(lastName);
        }
        catch (NumberFormatException var5)
        {
            flag = true;
        }

        if (!lastName.isEmpty() && flag) {
            this.lastName = lastName;
        } else {
            throw new InvalidNameException(lastName + " is not a valid name. Make sure there are no numbers or special characters.");
        }
    }

    /**
     * mutator for email Address
     * @param emailAddress - the EmailAddress to set
     */
    public void setEmailAddress(String emailAddress)

    {
        this.emailAddress = emailAddress;
    }

    /**
     * mutator for lastAccess
     * @param lastAccess - the LastAccess to set
     */
    public void setLastAccess(Date lastAccess)

    {
        this.lastAccess = lastAccess;
    }

    /**
     * mutator for enrolDate
     * @param enrolDate - the EnrolDate to set
     */
    public void setEnrolDate(Date enrolDate)

    {
        this.enrolDate = enrolDate;
    }

    /**
     * mutator for enabled
     * @param enabled - the Enabled to set
     */
    public void setEnabled(boolean enabled)

    {
        this.enabled = enabled;
    }

    /**
     * mutator for type
     * @param type - the Type to set
     */
    public void setType(char type)

    {
        this.type = type;
    }

    /**
     * User Parameterized Constructor
     * @param id - ID of user
     * @param password - Password for user
     * @param firstName - First Name of user
     * @param lastName - Last Name of user
     * @param emailAddress - Email Address of user
     * @param lastAccess - Last Access date by User
     * @param enrolDate - Date of enrolment of User
     * @param enabled - Status of user
     * @param type - Type of user
     * @throws InvalidUserDataException - Exception for Invalid user data
     */
    public User(long id, String password, String firstName, String lastName, String emailAddress, Date lastAccess, Date enrolDate, boolean enabled, char type) throws InvalidUserDataException {
        try {
            this.setId(id);
            this.setPassword(password);
            this.setFirstName(firstName);
            this.setLastName(lastName);
            this.setEmailAddress(emailAddress);
            this.setLastAccess(lastAccess);
            this.setEnrolDate(enrolDate);
            this.setEnabled(enabled);
            this.setType(type);
        } catch (Exception var12) {
            throw new InvalidUserDataException(var12.getMessage());
        }
    }

    /**
     * Default constructor that will set the instance attributes to the
     * public class attributes by calling the parameterized constructor.
     *
     * @throws InvalidUserDataException if the passed data is invalid
     */
    public User() throws InvalidUserDataException {
        this(DEFAULT_ID, DEFAULT_PASSWORD, DEFAULT_FIRST_NAME,
                DEFAULT_LAST_NAME, DEFAULT_EMAIL_ADDRESS, new Date(),
                new Date(), DEFAULT_ENABLED_STATUS, DEFAULT_TYPE);
    }

    public String getTypeForDisplay()
    {
        return "User";
    }

    /**
     * Overload the toString method
     */
    @Override
    public String toString()
    {
        String var10000 = this.getTypeForDisplay();
        return var10000 + "\n{\nStudent ID    = " + this.getId() +
                "\n\tName          = " + this.getFirstName() + " " +
                this.getLastName() + "\n\tEmail Address = " +
                this.getEmailAddress() + "\n\tCreated On    = " +
                this.getEnrolDate() + "\n\tLast Access   = " +
                this.getLastAccess() + "\n}";
    }

    /**
     * Prints the toString method
     */
    public void dump()
    {
        System.out.println(this);
    }

    /**
     * verifyId Method for User to validate the identification number
     */
    public static boolean verifyId(long id) {
        boolean isValid = true;
        if (id > MAXIMUM_ID_NUMBER || id < MINIMUM_ID_NUMBER) {
            isValid = false;
        }

        return isValid;
    }

    public static String hashPassword(String password)
    {
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("SHA1");

            //Add password bytes to digest
            md.update(password.getBytes());

            //Get the hash's bytes
            byte[] bytes = md.digest();

            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(String.format("%02x", bytes[i]));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch ( NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        //  System.out.println(generatedPassword);
        return generatedPassword;
    }


}
