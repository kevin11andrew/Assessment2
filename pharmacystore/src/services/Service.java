package services;

import models.Admin;
import models.Customer;
import models.Employee;
import models.Medicine;

import java.util.List;

public interface Service {
    void createNewProduct(Admin admin, Medicine medicine);
    void updateProduct(Admin admin, Medicine medicine);
    void sellProduct(Employee employee, Customer customer, Medicine medicine);
    List<Medicine> viewByType(String type);
//    void generateReport(Employee employee); What should the report contain???
}
