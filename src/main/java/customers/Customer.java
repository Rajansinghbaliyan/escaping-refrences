package customers;

import java.util.Objects;

public class Customer implements Comparable<Customer>, ReadOnlyCustomer {
    private int empNo;
    private String name;
    private String department;

    public Customer(int empNo, String name, String department) {
        this.empNo = empNo;
        this.name = name;
        this.department = department == null ? "Others" : department;
    }

    public Customer(Customer c) {
        if (c == null)
            return;
        this.empNo = c.getEmpNo();
        this.name = c.getName();
        this.department =  c.getDepartment();
    }

    public int getEmpNo() {
        return empNo;
    }

    public Customer setEmpNo(int empNo) {
        this.empNo = empNo;
        return this;
    }

    public String getName() {
        return name;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    public String getDepartment() {
        return department;
    }

    public Customer setDepartment(String department) {
        this.department = department;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return empNo == customer.empNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(empNo);
    }

    @Override
    public String toString() {
        return "customer.Customer{" +
                "empNo=" + empNo +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    @Override
    public int compareTo(Customer customer) {
        return Integer.compare(this.empNo, customer.getEmpNo());
    }
}
