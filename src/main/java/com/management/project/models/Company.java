package main.java.com.management.project.models;

/**
 * Created by Aleksey on 28.02.2017.
 */

/**
 * class Company
 */
public class Company {

    /**
     * @param ID. Is the first field of projects class. Contain id of Company.
     */
    private long id;

    /**
     * @param company. Is the second string field of projects class. Contain name of Company.
     */
    private String company;

    /**
     * public constructor Company with all fields.
     * @param id
     * @param company
     */
    public Company(int id, String company) {
        this.id = id;
        this.company = company;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @override method toString (implementation of object Company).
     */
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", company='" + company + '\'' +
                '}';
    }

    /**
     * equals and hashCode methods with check null
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company1 = (Company) o;

        if (id != company1.id) return false;
        return company.equals(company1.company);

    }

    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + company.hashCode();
        return result;
    }
}
