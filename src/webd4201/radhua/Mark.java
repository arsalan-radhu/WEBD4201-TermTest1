package webd4201.radhua;

/**
 * This class represents the Mark class
 * @author Arsalan Arif Radhu
 * @version 1.0
 * @since 1.0
 */

import java.text.DecimalFormat;

public class Mark {

    //Class Attributes
    /**
     * Stores the minimum GPA
     */
    static final float MINIMUM_GPA = 0.0f;
    /**
     * Stores the maximum GPA
     */
    static final float MAXIMUM_GPA = 5.0f;
    /**
     * Stores the GPA
     */
    static final DecimalFormat GPA = new DecimalFormat("#0.00#");

    //Instance Attributes
    /**
     * Instance Attribute for course code
     */
    private String courseCode;
    /**
     * Instance Attribute for course Name
     */
    private String courseName;
    /**
     * Instance Attribute for result
     */
    private int result;
    /**
     * Instance Attribute for gpa Weighting
     */
    private float gpaWeighting;


    /**
     * accessor for course code
     * @return the courseCode
     */
    public String getCourseCode()
    {
        return courseCode;
    }

    /**
     * accessor for course Name
     * @return the courseName
     */
    public String getCourseName()
    {
        return courseName;
    }

    /**
     * accessor for result
     * @return the result
     */
    public int getResult()
    {
        return result;
    }

    /**
     * accessor for gpa weighting
     * @return the gpaWeighting
     */
    public float getGpaWeighting()
    {
        return gpaWeighting;
    }

    /**
     * mutator for course code
     * @param courseCode - the CourseCode to set
     */
    public void setCourseCode(String courseCode)
    {
        this.courseCode = courseCode;
    }


    /**
     * mutator for course Name
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }

    /**
     * mutator for result
     * @param result the result to set
     */
    public void setResult(int result)
    {
        this.result = result;
    }

    /**
     * mutator for gpa weighting
     * @param gpaWeighting - the gpaWeighting to set
     */
    public void setGpaWeighting(float gpaWeighting)
    {
        this.gpaWeighting = gpaWeighting;
    }


    /**
     * Parameterized Constructor
     * @param courseCode
     * @param courseName
     * @param result
     * @param gpaWeighting
     */
    public Mark(String courseCode, String courseName, int result, float gpaWeighting) {
        setCourseCode(courseCode);
        setCourseName(courseName);
        setResult(result);
        setGpaWeighting(gpaWeighting);
    }

    /**
     * Override the toString method for displaying the attributes well formatted
     */
    @Override
    public String toString() {
        String output = getCourseCode();
        output += "\t" + String.format( "%-35s", getCourseName());
        output += "\t" + getResult();
        output += "\t" + GPA.format(getGpaWeighting());

        return output;
    }
}
