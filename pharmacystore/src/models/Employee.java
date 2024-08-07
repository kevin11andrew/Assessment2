package models;

public class Employee {
    private String name;
    private int age;
    private String gender;
    private int employeeId;
    private double salary;
    private String workLocation;

    public Employee(){

    }
    public Employee(String name, int age, String gender, int employeeId, double salary, String workLocation){
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.employeeId=employeeId;
        this.salary=salary;
        this.workLocation=workLocation;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

//    sell product
//    generate report

}
