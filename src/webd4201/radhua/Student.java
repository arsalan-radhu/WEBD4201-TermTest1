package webd4201.radhua;

/**
 * This class represents the Student class
 * @author Arsalan Arif Radhu
 * @version 1.0
 * @since 1.0
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

public class Student extends User{

    //Class Attributes
    /**
     * Stores the default program code
     */
    public static final String DEFAULT_PROGRAM_CODE = "UNDC";

    /**
     * Stores the default program description
     */
    public static final String DEFAULT_PROGRAM_DESCRIPTION = "Undeclared";

    /**
     * Stores the default year
     */
    public static final int DEFAULT_YEAR = 1;

    //Instance Attributes
    /**
     * instance attribute for program code
     */
    private String programCode;

    /**
     * instance attribute for program description
     */
    private String programDescription;

    /**
     * instance attribute for year
     */
    private int year;

    /**
     * Vector instance attribute for marks
     */
    private Vector<Mark> marks;

    /**
     * Accessor for program code
     * @return the programCode
     */
    public String getProgramCode()
    {
        return this.programCode;
    }

    /**
     * Accessor for program description
     * @return the programDescription
     */
    public String getProgramDescription()
    {
        return this.programDescription;
    }

    /**
     * Accessor for year
     * @return the year
     */
    public int getYear()
    {
        return this.year;
    }

    /**
     * Accessor for marks
     * @return the marks
     */
    public Vector<Mark> getMarks()
    {
        return this.marks;
    }

    /**
     * @return string "Student"
     */
    public String getTypeForDisplay()
    {
        return "Student";
    }

    /**
     * mutator for program code
     * @param programCode - the programCode to set
     */
    public void setProgramCode(String programCode)
    {
        this.programCode = programCode;
    }

    /**
     * mutator for program description
     * @param programDescription - the programDescription to set
     */
    public void setProgramDescription(String programDescription)
    {
        this.programDescription = programDescription;
    }

    /**
     * mutator for year
     * @param year - the year to set
     */
    public void setYear(int year)
    {
        this.year = year;
    }

    /**
     * mutator for marks
     * @param marks - the marks to set
     */
    public void setMarks(Vector<Mark> marks)
    {
        this.marks = marks;
    }


    /**
     * Parameterized constructor
     * @param id
     * @param password
     * @param firstName
     * @param lastName
     * @param emailAddress
     * @param lastAccess
     * @param enrolDate
     * @param enabled
     * @param type
     * @param programCode
     * @param programDescription
     * @param year
     * @param marks
     * @throws InvalidUserDataException
     */
    public Student(long id, String password, String firstName, String lastName, String emailAddress, Date lastAccess, Date enrolDate, boolean enabled, char type, String programCode, String programDescription, int year, Vector<Mark> marks) throws InvalidUserDataException
    {
        super(id, password, firstName, lastName, emailAddress, lastAccess, enrolDate, enabled, type);
        this.setProgramCode(programCode);
        this.setProgramDescription(programDescription);
        this.setYear(year);
        this.setMarks(marks);
    }

    /**
     * Overloaded Constructor
     * @param id
     * @param password
     * @param firstName
     * @param lastName
     * @param emailAddress
     * @param lastAccess
     * @param enrolDate
     * @param enabled
     * @param type
     * @param programCode
     * @param programDescription
     * @param year
     * @throws InvalidUserDataException
     */
    public Student(long id, String password, String firstName, String lastName, String emailAddress, Date lastAccess, Date enrolDate, boolean enabled, char type, String programCode, String programDescription, int year) throws InvalidUserDataException
    {
        this(id, password, firstName, lastName, emailAddress, lastAccess, enrolDate, enabled, type, programCode, programDescription, year, new Vector());
    }

    /**
     * Default Constructor
     * @throws InvalidUserDataException
     */
    public Student() throws InvalidUserDataException
    {
        this(DEFAULT_ID, DEFAULT_PASSWORD, DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_EMAIL_ADDRESS, new Date(), new Date(), DEFAULT_ENABLED_STATUS, DEFAULT_TYPE, "UNDC", "Undeclared", 1, new Vector());
    }

    /**
     * Override the toString Method
     */
    @Override
    public String toString()
    {
        String output;

        output = getTypeForDisplay() + " info for:";
        output += "\n\t" + getFirstName() + getLastName() + " (" + getId()
                + ")";
        output += "\n\tCurrently in " + getYear();

        if (getYear() == 1) {
            output += "st";
        } else if (getYear() == 2) {
            output += "nd";
        } else if (getYear() == 3) {
            output += "rd";
        } else {
            output += "th";
        }

        output += " year of \"" + getProgramDescription() + "\" ("
                + getProgramCode() + ")";
        output += "\n\tEnrolled: " + DF.format(getEnrolDate());

        output = output.replaceAll("User", "Student");

        return output;

    }

    /**
     * Method that connects the DB
     * @param c     The connection String
     */
    public static void initialize(Connection c)
    {
        StudentDA.initialize(c);
    }

    /**
     * Method to terminate the connection to the DB
     */
    public static void terminate()
    {
        StudentDA.terminate();
    }

    /**
     * Method to retrieve a student from the DB
     * @param id        The id being searched for in the DB
     * @return Student  A record from the DB
     * @throws NotFoundException  throws an exception if the user cannot be found, or other implicit data errors
     */
    public static Student retrieve(long id) throws NotFoundException, SQLException, InvalidUserDataException, InvalidIdException, InvalidNameException, InvalidPasswordException {
        return StudentDA.retrieve(id);
    }

    /**
     * Creates a new Student Object
     * @return aStudent   Object containing the relevant data
     * @throws InvalidUserDataException  throws an exception if the user data entry is invalid
     */
    public boolean create() throws InvalidUserDataException, DuplicateException, InvalidIdException, InvalidNameException, InvalidPasswordException, SQLException, NoSuchAlgorithmException {
        return StudentDA.create(this);
    }

    /**
     * Updates an existing record
     * @return          number of rows affected
     * @throws NotFoundException    throws an exception if the user cannot be found
     */
    public  int update() throws NotFoundException, InvalidUserDataException, InvalidIdException, InvalidNameException, InvalidPasswordException, SQLException {
        return StudentDA.update(this);
    }

    /**
     * Deletes an existing record
     * @return          number of rows affected
     * @throws NotFoundException   throws an exception if the user cannot be found
     */
    public int delete() throws NotFoundException, InvalidUserDataException, InvalidIdException, InvalidNameException, InvalidPasswordException, SQLException {
        return  StudentDA.delete(this);
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
