package com.management.project.models;

/**
 * The class implements a set of standarts methods for working
 * with entity of the Customer.
 *
 * @author Aleksey
 */
public class Customer {
    /**
     * The unique identifier for each customer.
     */
    private long id;

    /**
     * The name of this customer.
     */
    private String name;

    /**
     * Constructor
     *
     * @param id   a unique identifier for the new customer.
     * @param name a name to the new customer.
     */
    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Getters and setters methods by all fields of Customer.
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
     * Returns a string representation of the customer.
     *
     * @return A string representation of the customer.
     */
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customer='" + name + '\'' +
                '}';
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param object The reference object with which to compare.
     * @return Returns true if this customer is the same as the object
     * argument, otherwise returns false.
     */
    @Override
    public boolean equals(Object object) {
        if (this == object){
            return true;
        }
        if (object == null || getClass() != object.getClass()){
            return false;
        }

        Customer customer1 = (Customer) object;

        if (id != customer1.id){
            return false;
        }
        return name.equals(customer1.name);
    }

    /**
     * Returns a hash code value for the customer.
     *
     * @return A hash code value for this customer.
     */
    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        return result;
    }
}
