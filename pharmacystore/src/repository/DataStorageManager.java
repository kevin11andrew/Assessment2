package repository;

import exceptions.*;
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
            Admin employee1=null;
            for (Employee employee2:employees){
                if(employee2 instanceof Admin && employee2.getEmployeeId()==admin.getEmployeeId()) {
                    employee1 = (Admin)employee2;
                    break;
                }
            }
            if (employee1==null) {
                throw new EmployeeNotFoundException(admin.getName() + " Not found!");
            }

            Medicine medicine1=null;
            for(Medicine medicine2:medicines){
                if(medicine2.getId()==medicine.getId()) {
                    medicine1 = medicine2;
                    break;
                }
            }
            if(medicine1!=null){
                throw  new MedicineAlreadyExistsException(medicine.getName()+" Already Exists!");
            }

            medicines.add(medicine);
            System.out.println(medicine.getName()+" added!");
        } catch (EmployeeNotFoundException | MedicineAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
    }

        @Override
    public void updateProduct(Admin admin, Medicine medicine) {
            try {
                Admin employee1=null;
                for (Employee employee2:employees){
                    if(employee2 instanceof Admin && employee2.getEmployeeId()==admin.getEmployeeId()) {
                        employee1 =(Admin) employee2;
                        break;
                    }
                }
                if (employee1==null) {
                    throw new EmployeeNotFoundException(admin.getName() + " Not found!");
                }


                Medicine medicine1=null;
                for(Medicine medicine2:medicines){
                    if(medicine2.getId()==medicine.getId()) {
                        medicine1 = medicine2;
                        break;
                    }
                }
                if(medicine1==null){
                    throw  new MedicineNotFoundException(medicine.getName()+" does not exist!");
                }

                int size=medicines.size();
                for(int i=0;i<size;i++){
                    if (medicines.get(i).getId()==medicine.getId()){
                        medicines.remove(medicines.get(i));
                        break;
                    }
                }
                medicines.remove(medicine1);
                medicines.add(medicine);
                System.out.println(medicine.getName()+" updated!");
            } catch (EmployeeNotFoundException | MedicineNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }

    @Override
    public void sellProduct(Employee employee,Customer customer, Medicine medicine) {
        try {
            Admin employee1=null;
            for (Employee employee2:employees){
                if(employee2.getEmployeeId()==employee.getEmployeeId()) {
                    employee1 =(Admin) employee2;
                    break;
                }
            }
            if (employee1==null) {
                throw new EmployeeNotFoundException(employee.getName() + " Not found!");
            }


            Medicine medicine1=null;
            for(Medicine medicine2:medicines){
                if(medicine2.getId()==medicine.getId()) {
                    medicine1 = medicine2;
                    break;
                }
            }
            if(medicine1==null){
                throw  new MedicineNotFoundException(medicine.getName()+" does not exist!");
            }
            Customer customer1=null;
            for (Customer customer2: customers){
                if(customer2.getId()==customer.getId()){
                    customer1=customer2;
                    break;
                }
            }
            if(customer1==null){
                throw new CustomerNotFoundException(customer.getName()+" Not found!");
            }

            int size=medicines.size();
            int n=medicine1.getStockAvailable()-medicine.getStockAvailable();
            if(n<0){
                throw new  StockNotAvailableException("Stock for "+medicine.getName()+" not Available!");
            }
            medicine1.setStockAvailable(n);

            System.out.println(medicine.getName()+" updated");
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
