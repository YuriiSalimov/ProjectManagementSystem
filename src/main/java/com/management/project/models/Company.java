package com.management.project.models;

/**
 * The class implements a set of standarts methods for working
 * with entity of the Company.
 *
 * @author Aleksey
 */
public class Company {

    /**
     * The unique identifier for each company.
     */
    private long id;

    /**
     * The name of this company.
     */
    private String name;

    /**
     * Constructor
     *
     * @param id   a unique identifier for the new company.
     * @param name a name to the new company.
     */
    public Company(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Getters and setters methods by all fields of Company.
     */
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        } else {
            this.name = "";
        }
    }

    /**
     * Returns a string representation of the company.
     *
     * @return A string representation of the company.
     */
    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", company='" + name + '\'' +
                '}';
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param object The reference object with which to compare.
     * @return Returns true if this company is the same as the object
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

        Company company1 = (Company) object;

        if (id != company1.id){
            return false;
        }
        return name.equals(company1.name);
    }

    /**
     * Returns a hash code value for the company.
     *
     * @return A hash code value for this company.
     */
    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        return result;
    }

}
