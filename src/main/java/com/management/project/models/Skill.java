package com.management.project.models;

/**
 * Created by Вадим on 02.03.2017.
 */
public class Skill {

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
     *
     * @param id The unique identifier for each skill.
     * @param name a name of skill.
     */
    public Skill(long id, String name) {
        this.id = id;
        this.name = name;
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
        this.name = name;
    }


    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o The reference object with which to compare.
     * @return Returns true if this object is the same as the obj
     * argument, otherwise returns false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Skill skill = (Skill) o;

        if (id != skill.id) {
            return false;
        }
        return name.equals(skill.name);

    }

    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        return result;
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


}
