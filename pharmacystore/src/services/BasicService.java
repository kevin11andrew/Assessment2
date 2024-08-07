package services;

import models.Admin;
import models.Customer;
import models.Employee;
import models.Medicine;
import repository.DataStorageManager;
import repository.DataStoreAccess;

import java.util.List;

public class BasicService implements Service {
    DataStoreAccess dataStoreAccess;
    public BasicService(DataStoreAccess dataStoreAccess){
        this.dataStoreAccess=dataStoreAccess;
    }

    @Override
    public void createNewProduct(Admin admin, Medicine medicine) {
        dataStoreAccess.createNewProduct(admin,medicine);
    }

    @Override
    public void updateProduct(Admin admin, Medicine medicine) {
        dataStoreAccess.updateProduct(admin,medicine);
    }

    @Override
    public void sellProduct(Employee employee, Customer customer, Medicine medicine) {
        dataStoreAccess.sellProduct(employee,customer,medicine);
    }

    @Override
    public List<Medicine> viewByType(String type) {
        return dataStoreAccess.viewByType(type);
    }
}
