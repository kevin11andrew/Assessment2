import models.Admin;
import models.Customer;
import models.Employee;
import models.Medicine;
import repository.DataStorageManager;
import repository.DataStoreAccess;
import services.BasicService;
import services.Service;
/*
* 3 models: Customer, Employee, Medicine. Admin is an extension of employee
* Objects are passed to the different functions to modify the data
* Data is stored in arraylists
* */
public class Application {
    public static void main(String[] args) {
        /*Initialisation*/
        DataStoreAccess dataStorageManager=new DataStorageManager();
        Service basicService=new BasicService(dataStorageManager);

        Medicine medicine=new Medicine("Crocin2",1,50, "non-emergency",10);
        Employee employee=new Admin("Kevin",5,"Male",1,65000.0,"Pune");
        Customer customer=new Customer(1,"Andrew",24, "Male");

        /*Usage*/
        basicService.createNewProduct((Admin) employee,medicine);

        basicService.updateProduct((Admin) employee,medicine);
        basicService.sellProduct(employee,customer,medicine);
        System.out.println(basicService.viewByType("non-emergency"));


    }
}