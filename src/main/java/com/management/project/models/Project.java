package com.management.project.models;

/**
 * The class implements a set of standarts methods for working
 * with entity of the Project.
 * @author Aleksey
 */
public class Project {

    /**
     *  The unique identifier for each project.
     */
    private long id;

    /**
     * The name of this project.
     */
    private String name;

    /**
     * The cost of this project.
     */
    private String costs;

    /**
     * The company executor of this project.
     */
    private Company company;

    /**
     * The customer of this project.
     */
    private Customer customer;

    /**
     * Constructor
     *
     * @param id        a unique identifier for the new project.
     * @param name      a name to the new company.
     * @param costs     a cost of the new project.
     * @param company   a company executor of the new project.
     * @param customer  a customer of the new project.
     */
    public Project(int id, String name, String costs) {
        this.id = id;
        this.name = name;
        this.costs = costs;
        this.company = company;
        this.customer = customer;
    }

    /**
     * Getters and setters methods by all fields of Project
     **/
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
        this.name = name;
    }

    public String getCosts() {
        return costs;
    }

    public void setCosts(String costs) {
        this.costs = costs;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Returns a string representation of the project.
     *
     * @return A string representation of the project.
     */
    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", costs='" + costs + '\'' +
                ", company=" + company +
                ", customer=" + customer +
                '}';
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param object The reference object with which to compare.
     * @return Returns true if this project is the same as the object
     * argument, otherwise returns false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (id != project.id) return false;
        if (!name.equals(project.name)) return false;
        if (!costs.equals(project.costs)) return false;
        if (company != null ? !company.equals(project.company) : project.company != null) return false;
        return customer != null ? customer.equals(project.customer) : project.customer == null;
    }

    /**
     * Returns a hash code value for the project.
     *
     * @return A hash code value for this project.
     */
    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + costs.hashCode();
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        return result;
    }
}
