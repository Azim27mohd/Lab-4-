package ca.sait.crs.models;

import ca.sait.crs.contracts.Course;

// TODO: Make this class immutable.

/**
 * Represents an optional (zero credit) course.
 * @author Nick Hamnett <nick.hamnett@sait.ca>
 * @since June 1, 2023
 */
public final class OptionalCourse implements Course {
    /**
     * Course code
     */
    private String code;

    /**
     * Name of course
     */
    private String name;

    /**
     * Initializes instance
     * @param code Course code
     * @param name Course name
     */
    public OptionalCourse(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * Gets course code
     * @return Course code
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Gets course name
     * @return Course name
     */
    public String getName() {
        return this.name;
    }

    public String toString() {
        return String.format("%s (%s)", this.getName(), this.getCode());
    }
}
