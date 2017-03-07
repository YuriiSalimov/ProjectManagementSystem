package com.management.project.models;

/**
 * The class implements a set of standard methods for working
 * with entity of the Developer.
 *
 * @author Вадим
 */
public class Skill implements Model {

    /**
     * The unique identifier for each skill.
     */
    private long id;

    /**
     * a name of skill.
     */
    private String name;

    /**
     * Default constructor
     */
    public Skill() {
    }

    /**
     * Constructor.
     *
     * @param id   The unique identifier for each skill.
     * @param name a name of skill.
     */
    public Skill(long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Returns a string representation of a skill.
     *
     * @return A string representation of a skill.
     */
    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param object The reference object with which to compare.
     * @return Returns true if this object is the same as the obj
     * argument, otherwise returns false.
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Skill skill = (Skill) object;
        return name.equals(skill.name);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }

    /**
     * Getters and setters methods by all fields of developer.
     */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = (name != null) ? name : "";
    }
}
