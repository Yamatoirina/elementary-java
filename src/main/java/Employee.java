
/**
 * Initial employee class
 */
public class Employee {

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    // Unique identifier
    private String uuid;

    @Override
    public String toString() {
        return uuid;
    }

    public Employee clone()
    {
        Employee employee = new Employee();
        employee.uuid = this.uuid;
        return employee;
    }
}
