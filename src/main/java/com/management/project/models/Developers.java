package com.management.project;

/**
 * Created by Aleksey on 27.02.2017.
 */

    /* Class Developers*/
public class Developers {


    /**
     * @param ID. Is the first int field of developers class.
     */
    private int ID;

    /**
     * @param firstName. Is the second string field of developers class.
     */
    private String firstName;

    /**
     * @param lastName. Is the third string field of developers class.
     */
    private String lastName;

    /**
     * @param salary. Is the fourth int field of developers class.
     */
    private int salary;

    /**
     * @param city. Is the fifth string field of developers class.
     */
    private String city;


    /**
     * public constructor Developers with all fields.
     * @param ID
     * @param firstName
     * @param lastName
     * @param salary
     * @param city
     */
    public Developers(int ID, String firstName, String lastName, int salary, String city) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.city = city;
    }


    /**
     * Getters and setters methods by all fields of Developers
     **/

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @override method toString (implementation of object Developers)
     * */
    public String toString() {
        return "Developers{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", city='" + city + '\'' +
                '}';
    }

    /**
     * equals and hashCode methods with check null
     * */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Developers)) return false;

        Developers that = (Developers) o;

        if (getID() != that.getID()) return false;
        if (getSalary() != that.getSalary()) return false;
        if (!getFirstName().equals(that.getFirstName())) return false;
        if (!getLastName().equals(that.getLastName())) return false;
        return getCity().equals(that.getCity());

    }

    public int hashCode() {
        int result = getID();
        result = 31 * result + getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + getSalary();
        result = 31 * result + getCity().hashCode();
        return result;
    }
}
