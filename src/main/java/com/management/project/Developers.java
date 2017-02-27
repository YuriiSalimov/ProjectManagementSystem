package main.java.com.management.project;

/**
 * Created by Aleksey on 27.02.2017.
 */

/* Class Developers*/
public class Developers {
    private int ID;
    private String firstName;
    private String lastName;
    private int salary;
    private String city;

    public Developers(int ID, String firstName, String lastName, int salary, String city) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.city = city;
    }

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

    public String toString() {
        return "Developers{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", city='" + city + '\'' +
                '}';
    }

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
