package fa.training.services;

import fa.training.entities.Department;
import fa.training.entities.Employee;
import fa.training.entities.HourlyEmployee;
import fa.training.entities.SalariedEmployee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    SalariedEmployee salariedEmployee = new SalariedEmployee();
    HourlyEmployee hourlyEmployee = new HourlyEmployee();
    List<SalariedEmployee> salariedEmployeeList;
    List<HourlyEmployee> hourlyEmployeeList;
    List<Employee> employeeList = new ArrayList<>();
    List<Department> departmentList = new ArrayList<>();


    public EmployeeService() {
        salariedEmployeeList = new ArrayList<>();
        salariedEmployeeList.add(new SalariedEmployee("se01", "thanh", "nguyen", LocalDate.parse("2010-10-01"), "095653452", "abc@gmail.com", 2.0, 3.0, 4.0));
        salariedEmployeeList.add(new SalariedEmployee("se02", "thanh", "nguyen", LocalDate.parse("2010-10-01"), "095653452", "abc@gmail.com", 2.0, 3.0, 4.0));
        salariedEmployeeList.add(new SalariedEmployee("se03", "thanh", "nguyen", LocalDate.parse("2010-10-01"), "095653452", "abc@gmail.com", 2.0, 3.0, 4.0));

        hourlyEmployeeList = new ArrayList<>();
        hourlyEmployeeList.add(new HourlyEmployee("se04", "lan", "ha", LocalDate.parse("2007-05-02"), "089786547", "ghj@gmail.com", 7.0, 3.0));
        hourlyEmployeeList.add(new HourlyEmployee("se05", "lan", "ha", LocalDate.parse("2007-05-02"), "089786547", "ghj@gmail.com", 7.0, 3.0));
        hourlyEmployeeList.add(new HourlyEmployee("se06", "lan", "ha", LocalDate.parse("2007-05-02"), "089786547", "ghj@gmail.com", 7.0, 3.0));

        employeeList.add(new SalariedEmployee("se01", "thanh", "nguyen", LocalDate.parse("2010-10-01"), "095653452", "abc@gmail.com", 2.0, 3.0, 4.0));
        employeeList.add(new SalariedEmployee("se02", "thanh", "nguyen", LocalDate.parse("2010-10-01"), "095653452", "abc@gmail.com", 2.0, 3.0, 4.0));
        employeeList.add(new SalariedEmployee("se03", "thanh", "nguyen", LocalDate.parse("2010-10-01"), "095653452", "abc@gmail.com", 2.0, 3.0, 4.0));
        employeeList.add(new HourlyEmployee("se04", "lan", "ha", LocalDate.parse("2007-05-02"), "089786547", "ghj@gmail.com", 7.0, 3.0));
        employeeList.add(new HourlyEmployee("se05", "lan", "ha", LocalDate.parse("2007-05-02"), "089786547", "ghj@gmail.com", 7.0, 3.0));
        employeeList.add(new HourlyEmployee("se06", "lan", "ha", LocalDate.parse("2007-05-02"), "089786547", "ghj@gmail.com", 7.0, 3.0));

    }

    public void listEmployee() {
        for (Employee e : employeeList) {
            System.out.println(e.toString());
        }
    }

    public void addSalariedEmployee(SalariedEmployee salariedEmployee) {
        if (!findSalary(salariedEmployee.getSsn())) {
            salariedEmployeeList.add(salariedEmployee);
        } else {
            System.out.println("Record already exists in the employee list");
        }
    }

    public void addHourlyEmployee(HourlyEmployee hourlyEmployee) {
        if (!findHour(hourlyEmployee.getSsn())) {
            hourlyEmployeeList.add(hourlyEmployee);
        } else {
            System.out.println("Record already exists in the employee list");
        }
    }

    public boolean findSalary(String ssn) {
        for (SalariedEmployee s : salariedEmployeeList
        ) {
            if (s.getSsn().equals(ssn)) {
                return true;
            }
        }
        return false;
    }

    public boolean findHour(String ssn) {
        for (HourlyEmployee h : hourlyEmployeeList
        ) {
            if (h.getSsn().equals(ssn)) {
                return true;
            }
        }
        return false;
    }

    public void listSalariedEmployee() {
        for (SalariedEmployee s : salariedEmployeeList
        ) {
            System.out.println(s.toString());
        }
    }

    public void listHourlyEmployee() {
        for (HourlyEmployee s : hourlyEmployeeList
        ) {
            System.out.println(s.toString());
        }
    }

    public void addDepartment() {
        for (Employee e : employeeList
        ) {
            departmentList.add(new Department("fu", employeeList));

        }
    }

    public void searchDepartment(String text) {
        addDepartment();
        for (Department d : departmentList
        ) {
            if (text.equals(d.getDepartmentName())) {
                System.out.println(d.toString());
            }
        }
    }

    public void searchName(String name) {
        for (Employee e: employeeList
             ) {
            if (name.equals(e.getLastName())) {
                System.out.println(e.toString());
            }
        }
    }


}
