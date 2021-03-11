import java.util.Arrays;

/**
 * Array based storage for Employees
 */
public class ArrayStorage {
    Employee[] storage = new Employee[10000];
    static int counter = 0;

//    void clear() {
//        for (int i = 0; i < storage.length; i++) {
//            if (storage[i] != null) {
//                storage[i] = null;
//            }
//        }
//    }


    /**
     * variant 2 with java.utils
     */
    void clear() {
        Arrays.fill(storage, null);
        System.out.println("List is clear");
    }


    void save(Employee employee) {
        if (employee == null) {
            System.out.println("Employee is absent. Add employee to save");
            return;
        }
        if (storage.length == size()) {
            System.out.println("No free slots");
        } else {
            storage[size()] = employee;
            this.counter++;
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
        for (int i = 0; i < size() - 1; i++)
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[size() - 1];
                storage[size() - 1] = null;
                counter--;
            }
    }


    /**
     * @return array, contains only Employees in storage (without null)
     */
//    Employee[] getAll() {
//        Employee[] allEmployee = new Employee[size()];
//        if (size() != 0) {
//            for (int i = 0; i < size(); i++) {
//                allEmployee[i] = storage[i];
//            }
//        } else {
//            System.out.println("List is empty");
//        }
//        return allEmployee;
//    }

    /**
     * variant 2 with java.utils
     */
    Employee[] getAll() {
        Employee[] allEmployee = new Employee[size()];
        System.arraycopy(storage, 0, allEmployee, 0, size());
        return allEmployee;
    }


//    int size() {
//        int countEmp = 0;
//        for (int i = 0; i < storage.length; i++) {
//            if (storage[i] != null) {
//                countEmp++;
//            } else {
//                break;
//            }
//        }
//    }
//}

    /**
     * variant 2 with counter
     */
    int size() {
        return counter;
    }
}