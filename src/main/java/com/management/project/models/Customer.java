package main.java.com.management.project.models;

/**
 * Created by Aleksey on 28.02.2017.
 */

/**
 * class Customer
 */
public class Customer {
    /**
     *  @param id. Is the first field of customer class. Contain id of Customer.
     */
    private long id;

    /**
     * @param customer.Is the second string field of customer class. Contain name of Customer.
     */
    private String customer;

    /**
     * public constructor Customer with all fields.
     * @param id
     * @param customer
     */
    public Customer(int id, String customer) {
        this.id = id;
        this.customer = customer;
    }

    /**
     *Getters and setters methods by all fields of Customer.
     */
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    /**
     * @override method toString (implementation of object Customer).
     */
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customer='" + customer + '\'' +
                '}';
    }


    /**
     * equals and hashCode methods with check null
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer1 = (Customer) o;

        if (id != customer1.id) return false;
        return customer.equals(customer1.customer);

    }

    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + customer.hashCode();
        return result;
    }
}
