package repository;

import exceptions.CustomerNotFoundException;
import exceptions.EmployeeNotFoundException;
import exceptions.MedicineNotFoundException;
import exceptions.StockNotAvailableException;
import models.Admin;
import models.Customer;
import models.Employee;
import models.Medicine;

import java.util.ArrayList;
import java.util.List;

public class DataStorageManager implements DataStoreAccess{
    static ArrayList<Medicine> medicines = new ArrayList<>();
    static ArrayList<Employee> employees = new ArrayList<>();
    static ArrayList<Customer> customers = new ArrayList<>();

    static {
        medicines.add(new Medicine("Crocin",1,50, "non-emergency",10));
        employees.add(new Admin("Kevin",5,"Male",1,65000.0,"Pune"));
        customers.add(new Customer(1,"Andrew",24, "Male"));
    }

    @Override
    public void createNewProduct(Admin admin, Medicine medicine) {
        try {
            if (!employees.contains(admin)) {
                throw new EmployeeNotFoundException(admin.getName() + " Not found!");
            }
            if(!medicines.contains(medicine)){
                throw  new MedicineNotFoundException(medicine.getName()+" Not found!");
            }
            medicines.add(medicine);
            System.out.println(medicine.getName()+" added!");
        } catch (EmployeeNotFoundException | MedicineNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

        @Override
    public void updateProduct(Admin admin, Medicine medicine) {
            try {
                if (!employees.contains(admin)) {
                    throw new EmployeeNotFoundException(admin.getName() + " Not found!");
                }
                if(!medicines.contains(medicine)){
                    throw  new MedicineNotFoundException(medicine.getName()+" Not found!");
                }
                int size=medicines.size();
                for(int i=0;i<size;i++){
                    if (medicines.get(i).getId()==medicine.getId()){
                        medicines.remove(medicines.get(i));
                        break;
                    }
                }
                medicines.add(medicine);
                System.out.println(medicine.getName()+" updated!");
            } catch (EmployeeNotFoundException | MedicineNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }

    @Override
    public void sellProduct(Employee employee,Customer customer, Medicine medicine) {
        try {
            if (!employees.contains(employee)) {
                throw new EmployeeNotFoundException(employee.getName() + " Not found!");
            }
            if(!medicines.contains(medicine)){
                throw  new MedicineNotFoundException(medicine.getName()+" Not found!");
            }
            if(!customers.contains(customer)){
                throw new CustomerNotFoundException(customer.getName()+" Not found!");
            }
            int size=medicines.size();
            for(int i=0;i<size;i++){
                if (medicines.get(i).getId()==medicine.getId()){
                    int n=medicines.get(i).getStockAvailable()-medicine.getStockAvailable();
                    if(n<0){
                        throw new  StockNotAvailableException("Stock for "+medicine.getName()+" not Available!");
                    }
                    medicines.get(i).setStockAvailable(n);
                    break;
                }
            }
            System.out.println(medicine.getName()+" added!");
        } catch (EmployeeNotFoundException | MedicineNotFoundException | CustomerNotFoundException | StockNotAvailableException e ) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public List<Medicine> viewByType(String type) {
        ArrayList<Medicine> medicines1=new ArrayList<>();
        for (Medicine medicine: medicines){
            if(medicine.getType().equals(type)){
                medicines1.add(medicine);
            }
        }
        return medicines1;
    }
}
