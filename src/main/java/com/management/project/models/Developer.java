package com.management.project.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * The class implements a set of standarts methods for working
 * with entity of the Developer.
 *
 * @author Вадим
 */
public class Developer {

    /**
     * The unique identifier for each developer.
     */
    private long id;

    /**
     * The name of this developer.
     */
    private String name;

    /**
     * The company, which employs this developer.
     */
    private Company company;

    /**
     * The project, that works the developer
     */
    private Project project;

    /**
     * The salary of this developer
     */
    private int salary;

    /**
     * Skills that have developer
     */
    private Set<Skill> skills = new HashSet<Skill>();

    /**
     * Default constructor.
     */

    public Developer() {
    }

    /**
     * Constructor.
     *
     * @param name a name of the new developer.
     */
    public Developer(String name) {
        this.name = name;
    }


    /**
     * Constructor.
     *
     * @param id     The unique identifier for each developer.
     * @param name   a name of the new developer.
     * @param salary The salary of this developer
     */
    public Developer(long id, String name, int salary) {
        this(name);
        this.id = id;
        this.salary = salary;
    }

    /**
     * Constructor.
     *
     * @param id      The unique identifier for each developer.
     * @param name    a name of the new developer.
     * @param company The company, which employs this developer.
     * @param project The project, that works the developer
     * @param salary  The salary of this developer
     */
    public Developer(long id, String name, Company company, Project project, int salary) {
        this(id,name,salary);
        this.company = company;
        this.project = project;
    }

    /**
     * Constructor.
     *
     * @param id      The unique identifier for each developer.
     * @param name    a name of the new developer.
     * @param company The company, which employs this developer.
     * @param project The project, that works the developer
     * @param salary  The salary of this developer
     * @param skills  Skills that have developer
     */
    public Developer(long id, String name, Company company, Project project, int salary, Set<Skill> skills) {
        this(id,name,company,project,salary);
        this.skills = skills;
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
        if (name != null) {
            this.name = name;
        } else {
            this.name = "";
        }
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
        this.salary = salary > 0 ? salary : 0;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(HashSet<Skill> skills) {
        if (skills != null) {
            this.skills = new HashSet<Skill>(skills);
        } else {
            this.skills = new HashSet<Skill>();
        }
    }

    /**
     * @param skill a skill that you need to add the developer
     * @return true if new skill was add  to developer successfully
     * or false if the addition failed
     */
    public boolean addSkill(Skill skill) {
        return (skill != null) && this.skills.add(skill);
    }

    /**
     * @param skill a skill that must be removed from developer
     * @return true if new skill was remove from developer successfully
     * or false if the removal failed
     */
    public boolean removeSkill(Skill skill) {
        return (skill != null) && this.skills.remove(skill);
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
        Developer developer = (Developer) o;
        if (salary != developer.salary) {
            return false;
        }
        if (!name.equals(developer.name)) {
            return false;
        }
        if (company != null ? !company.equals(developer.company) : developer.company != null) {
            return false;
        }
        return project != null ? project.equals(developer.project) : developer.project == null;

    }

    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (project != null ? project.hashCode() : 0);
        result = 31 * result + salary;
        return result;
    }

    /**
     * Returns a string representation of the developer.
     *
     * @return A string representation of the developer.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Developer{")
                .append(", id=").append(this.id)
                .append(", name=").append(this.name)
                .append(", salary=").append(this.salary)
                .append(", company=").append(this.company)
                .append(", project=").append(this.project)
                .append(", skills:");
        for (Skill skill : this.skills) {
            sb.append(skill.getName()).append(", ");
        }
        sb.append('}');
        return sb.toString();
    }
}
