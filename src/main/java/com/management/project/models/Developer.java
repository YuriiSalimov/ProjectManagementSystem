package com.management.project.models;

import java.util.Collection;

/*
package com.management.project.models;

import java.util.Collection;


public class Developer {

    private Long id;
    private String name;
    private Company company;
    private Project project;
    private int salary;
    private Collection<Skill> skills;

    public Developer(Long id, String name, Company company, Project project, int salary, Collection<Skill> skills) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.project = project;
        this.salary = salary;
        this.skills = skills;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Collection<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Collection<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Developer developer = (Developer) o;

        if (salary != developer.salary) return false;
        if (!id.equals(developer.id)) return false;
        if (!name.equals(developer.name)) return false;
        if (company != null ? !company.equals(developer.company) : developer.company != null) return false;
        if (project != null ? !project.equals(developer.project) : developer.project != null) return false;
        return skills != null ? skills.equals(developer.skills) : developer.skills == null;

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (project != null ? project.hashCode() : 0);
        result = 31 * result + salary;
        result = 31 * result + (skills != null ? skills.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company=" + company +
                ", project=" + project +
                ", salary=" + salary +
                ", skills=" + skills +
                '}';
    }
}


 */

    /* Class Developer*/
public class Developer {


    /**
     * @param ID. Is the first field of developers class.
     */
    private long ID;

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
     * public constructor Developer with all fields.
     * @param ID
     * @param firstName
     * @param lastName
     * @param salary
     * @param city
     */
    public Developer(int ID, String firstName, String lastName, int salary, String city) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.city = city;
    }


    /**
     * Getters and setters methods by all fields of Developer
     **/

    public long getID() {
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
     * @override method toString (implementation of object Developer)
     * */
    public String toString() {
        return "Developer{" +
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
        if (o == null || getClass() != o.getClass()) return false;

        Developer developer = (Developer) o;

        if (ID != developer.ID) return false;
        if (salary != developer.salary) return false;
        if (!firstName.equals(developer.firstName)) return false;
        if (!lastName.equals(developer.lastName)) return false;
        return city.equals(developer.city);

    }

    public int hashCode() {
        int result = (int) (ID ^ (ID >>> 32));
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + salary;
        result = 31 * result + city.hashCode();
        return result;
    }
}
