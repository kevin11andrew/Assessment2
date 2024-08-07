package repository;

import models.Admin;
import models.Customer;
import models.Employee;
import models.Medicine;

import java.util.List;

public interface DataStoreAccess {
    void createNewProduct(Admin admin, Medicine medicine);
    void updateProduct(Admin admin, Medicine medicine);
    void sellProduct(Employee employee, Customer customer, Medicine medicine);
    List<Medicine> viewByType(String type);
}
