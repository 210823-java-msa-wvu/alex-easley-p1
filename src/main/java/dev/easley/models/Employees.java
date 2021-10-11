package dev.easley.models;

public class Employees {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String address;
    private String employeeType;
    private String department;
    private Integer reportsTo;
    private Integer availAssist;

    public Employees() {

    }

    public Employees(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Employees(String username, String password, Integer id, String employeeType) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.employeeType = employeeType;

    }

    public Employees(Integer id, String firstName, String lastName, String username, String password, String employeeType, Integer availAssist) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.employeeType = employeeType;
        this.availAssist = availAssist;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Integer reportsTo) {
        this.reportsTo = reportsTo;
    }

    public Integer getAvailAssist() {
        return availAssist;
    }

    public void setAvailAssist(Integer availAssist) {
        this.availAssist = availAssist;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", employeeType='" + employeeType + '\'' +
                ", department='" + department + '\'' +
                ", reportsTo=" + reportsTo +
                ", availAssist=" + availAssist +
                '}';
    }
}
