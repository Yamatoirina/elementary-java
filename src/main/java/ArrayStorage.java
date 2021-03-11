package main.java;

/**
 * Array based storage for Employees
 */
public class ArrayStorage {
    Employee[] storage = new Employee[10000];


    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                storage[i] = null;
            }
        }
        System.out.println("List is clear");
    }


    void save(Employee employee) {
        if (storage.length == size()) {
            System.out.println("No free slots");
        } else {
            storage[size()] = employee;
        }
    }


    Employee get(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        System.out.println("No such employee " + uuid);
        return null;
    }


    void delete(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[size() - 1];
                storage[size() - 1] = null;
            }
        }
    }



    /**
     * @return array, contains only Employees in storage (without null)
     */
    Employee[] getAll() {
        Employee[] allEmployee = new Employee[size()];
        if (size() != 0) {
            for (int i = 0; i < size(); i++) {
                allEmployee[i] = storage[i];
            }
        } else {
            System.out.println("List is empty");
        }
        return allEmployee;
    }


    int size() {
        int countEmp = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                countEmp++;
            } else {
                break;
            }
        }
        return countEmp;
    }
}
