package webd4201.radhua;

/**
 * This class represents the Faculty class
 * @author Arsalan Arif Radhu
 * @version 1.0
 * @since 1.0
 */

import java.util.Date;

public class Faculty extends User {
    //Class Attributes
    /**
     * Default school code
     */
    static final String DEFAULT_SCHOOL_CODE = "SET";
    /**
     * Default school description
     */
    static final String DEFAULT_SCHOOL_DESCRIPTION = "School of Engineering & Technology";
    /**
     * Default office
     */
    static final String DEFAULT_OFFICE = "H-140";
    /**
     * Default phone extension
     */
    static final int DEFAULT_PHONE_EXTENSION = 1234;


    //Instance Attributes
    /**
     * Instance attribute for school code
     */
    private String schoolCode;
    /**
     * Instance attribute for school description
     */
    private String schoolDescription;
    /**
     * Instance attribute for office
     */
    private String office;
    /**
     * Instance attribute for extension
     */
    private int extension;

    /**
     * Accessor for school Code
     * @return the schoolCode
     */
    public String getSchoolCode()
    {
        return schoolCode;
    }

    /**
     * mutator for school Code
     *
     * @param schoolCode the schoolCode to set
     */
    public void setSchoolCode(String schoolCode)
    {
        this.schoolCode = schoolCode;
    }

    /**
     * Accessor for school Description
     *
     * @return the schoolDescription
     */
    public String getSchoolDescription()
    {
        return schoolDescription;
    }

    /**
     * mutator for school description
     *
     * @param schoolDescription the schoolDescription to set
     */
    public void setSchoolDescription(String schoolDescription)
    {
        this.schoolDescription = schoolDescription;
    }

    /**
     * accessor for office
     *
     * @return the office
     */
    public String getOffice()
    {
        return office;
    }

    /**
     * mutator for office
     *
     * @param office the office to set
     */
    public void setOffice(String office)
    {
        this.office = office;
    }

    /**
     * accessor for extension
     *
     * @return the extension
     */
    public int getExtension()
    {
        return extension;
    }

    /**
     * mutator for extension
     *
     * @param extension the extension to set
     */
    public void setExtension(int extension)
    {
        this.extension = extension;
    }

    /**
     * Parameterized Constructor for faculty
     * @param id
     * @param password
     * @param firstName
     * @param lastName
     * @param emailAddress
     * @param lastAccess
     * @param enrolDate
     * @param enabled
     * @param type
     * @param schoolCode
     * @param schoolDescription
     * @param office
     * @param extension
     * @throws InvalidUserDataException
     */
    public Faculty(long id, String password, String firstName, String lastName, String emailAddress, Date lastAccess,
                   Date enrolDate, boolean enabled, char type, String schoolCode, String schoolDescription, String office,
                   int extension) throws  InvalidUserDataException
    {
        super(id, password, firstName, lastName, emailAddress, lastAccess, enrolDate, enabled, type);
        setSchoolCode(schoolCode);
        setSchoolDescription(schoolDescription);
        setOffice(office);
        setExtension(extension);
    }

    /**
     * Default Constructor for faculty
     */
    public Faculty() throws InvalidUserDataException {
        super();
        setSchoolCode(DEFAULT_SCHOOL_CODE);
        setSchoolDescription(DEFAULT_SCHOOL_DESCRIPTION);
        setOffice(DEFAULT_OFFICE);
        setExtension(DEFAULT_PHONE_EXTENSION);
    }

    /**
     * Implement the abstract method from the College Interface
     * @return string "Faculty"
     */
    @Override
    public String getTypeForDisplay() {
        //return Faculty as a string
        return "Faculty";
    }

    /**
     * Overrides the toString() method to display the faculty info
     */
    @Override
    public String toString() {

        String firstPart = super.toString();
        firstPart = firstPart.replaceAll("User", getTypeForDisplay());

        return firstPart + "\n" + schoolDescription + " (" + schoolCode + " )"
                + "\nOffice: " + office
                + "\n" + PHONE_NUMBER + " x" + extension;
    }
}
