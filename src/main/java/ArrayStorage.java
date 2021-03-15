import java.util.Arrays;

/**
 * Array based storage for Employees
 */
public class ArrayStorage {
    private Employee[] storage = new Employee[10000];
    private int counter = 0;


    void clear() {
        Arrays.fill(storage, null);
        System.out.println("List is clear");
        counter = 0;
    }



    void save(Employee employee) {
        if (employee == null) {
            System.out.println("Employee is absent. Add employee to save");
            return;
        }
        if (storage.length == size()) {
            System.out.println("No free slots");
        } else {
            storage[size()] = employee.clone();
            this.counter++;
        }
    }



    Employee get(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && storage[i].getUuid().equals(uuid)) {
                return storage[i];
            }
        }
        System.out.println("No such employee " + uuid);
        return null;
    }



    void delete(String uuid) {
        for (int i = 0; i < size(); i++)
            if (storage[i].getUuid().equals(uuid)) {
                storage[i] = storage[size() - 1];
                storage[size() - 1] = null;
                counter--;
            }
    }

    /**
     * @return array, contains only Employees in storage (without null)
     */
    Employee[] getAll() {
        return Arrays.copyOfRange(storage, 0, counter);
    }

    int size() {
        return counter;
    }
}
