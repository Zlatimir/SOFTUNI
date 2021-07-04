import entities.Address;
import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Engine implements Runnable {

    private final EntityManager entityManager;
    private BufferedReader bufferedReader;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {

        System.out.println("Enter exercise number:");
        int exNum = 0;
        try {
            exNum = Integer.parseInt(bufferedReader.readLine());
            switch (exNum) {
                case 2 -> exTwoChangeCasing();

                case 3 -> exThreeContainsEmployee();

                case 4 -> exFourEmployeesWithSalaryOver50000();

                case 5 -> exFiveEmployeesFromDepartment();

                case 6 -> exSixAddingNewAddressAndUpdatingEmployee();

                case 7 -> exSevenAddressesWithEmployeeCount();

                case 8 -> exEightGetEmployeeWithProject();

                default -> System.out.println("Wrong number - try again!");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exEightGetEmployeeWithProject() throws IOException {
        System.out.println("Enter employee ID:");
        Integer id = Integer.parseInt(bufferedReader.readLine());
        Employee employee = entityManager.find(Employee.class, id);
        System.out.printf("%s %s - %s%n", employee.getFirstName(), employee.getLastName(),
                employee.getJobTitle());

        Set<Project> projects = employee.getProjects();
        System.out.println(projects.stream().map(Project::getName).sorted()
        .collect(Collectors.toList()).toString().replace("[", "")
        .replace("]", "").replace(", ", System.lineSeparator()));
    }

    private void exSevenAddressesWithEmployeeCount() {
        entityManager.createQuery
                ("select a from Address a " +
                        " order by a.employees.size desc ", Address.class).setMaxResults(10)
                .getResultList().forEach(a -> System.out.printf("%s, %s - %d employees%n"
                , a.getText(), a.getTown().getName(),a.getEmployees().size()));
    }

    private void exSixAddingNewAddressAndUpdatingEmployee() throws IOException {
        System.out.println("Enter employee last name:");
        String lastName = bufferedReader.readLine();

        try {
            Employee employee = entityManager.createQuery("select e from " +
                    "Employee e where e.lastName = :last", Employee.class).
                    setParameter("last", lastName).getSingleResult();

            Address address = new Address();
            address.setText("Vitoshka 15");
            entityManager.getTransaction().begin();
            entityManager.persist(address);
            entityManager.getTransaction().commit();

            entityManager.getTransaction().begin();
            employee.setAddress(address);
            entityManager.getTransaction().commit();

        } catch (NoResultException e) {
            System.out.println("No such employee exists in database!!!");
        }
    }

    private void exFiveEmployeesFromDepartment() {
        List<Employee> resultList = entityManager.createQuery
                ("select e from Employee e where e.department.name = 'Research and Development'" +
                        "order by e.salary, e.id", Employee.class)
                .getResultList();
        resultList.forEach(e -> System.out.printf("%s %s from %s - $%.2f%n",
                e.getFirstName(), e.getLastName(), e.getDepartment().getName(), e.getSalary()));
    }

    private void exFourEmployeesWithSalaryOver50000() {
        List resultList = entityManager.createQuery
                ("select e.firstName from Employee e where e.salary > 50000")
                .getResultList();
        resultList.forEach(e -> System.out.println(e));
    }

    private void exThreeContainsEmployee() throws IOException {
        System.out.println("Enter first and last name of employee:");

        String[] input = bufferedReader.readLine().split("\\s+");
        String firstName = input[0];
        String lastName = input[1];
        Query query = entityManager.createQuery
                ("select e.id from Employee e where e.firstName = :first and e.lastName = :last");
        query.setParameter("first", firstName);
        query.setParameter("last", lastName);
        List resultList = query.getResultList();
        int result = resultList.size();
        if (result == 0) {
            System.out.println("No such employee!");
        } else {
            System.out.println(firstName + " " + lastName + " persists in soft_uni database!");
        }

    }


    private void exTwoChangeCasing() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery
                ("update Town t set t.name = upper(t.name) where length(t.name) <= 5");
        int affectedRows = query.executeUpdate();
        entityManager.getTransaction().commit();
        System.out.println("Rows affected: " + affectedRows);
    }
}
