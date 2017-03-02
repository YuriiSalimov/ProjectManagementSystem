package com.management.project.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Вадим on 02.03.2017.
 */
public class Developer {

    private long id;
    private String name;
    private Company company;
    private Project project;
    private int salary;
    private Set<Skill> skills = new HashSet<Skill>();

    public Developer() {
    }

    public Developer(String name) {
        this.name = name;
    }

    public Developer(long id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Developer(long id, String name, Company company, Project project, int salary) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.project = project;
        this.salary = salary;
    }

    public Developer(long id, String name, Company company, Project project, int salary, Set<Skill> skills) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.project = project;
        this.salary = salary;
        this.skills = skills;
    }

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

    public void setSkills(Collection<Skill> skills) {
        if (skills != null) {
            this.skills = new HashSet<Skill>(skills);
        } else {
            skills = new HashSet<Skill>();
        }
    }

    public boolean addSkill(Skill skill) {
        return (skill != null) && this.skills.add(skill);
    }

    public boolean removeSkill(Skill skill) {
        return (skill != null) && this.skills.remove(skill);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Developer developer = (Developer) o;

        if (id != developer.id) {
            return false;
        }
        if (salary != developer.salary){
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

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (project != null ? project.hashCode() : 0);
        result = 31 * result + salary;
        return result;
    }

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
