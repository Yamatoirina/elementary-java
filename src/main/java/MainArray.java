import java.util.Scanner;

public class MainArray {

    private static final ArrayStorage ARRAY_STORAGE1 = new ArrayStorage();


    public static void main(String[] args) {

        manipulationWithEmployees();
    }


    private static void manipulationWithEmployees() {
        System.out.print("Enter command in next format- (list | save uuid | delete uuid | get uuid | size | clear | exit): ");
        Scanner scanner = new Scanner(System.in);
        String command[] = scanner.nextLine().split(" ");
        Employee employee = new Employee();

        while (!command[0].equals("exit")) {
            if (command[0].equals("list") || command[0].equals("save") || command[0].equals("delete") || command[0].equals("get") ||
                    command[0].equals("size") || command[0].equals("clear")) {

                if (command.length > 1) {
                    employee.setUuid(command[1]);
                }
                switchingOperations(command, employee);
            } else {
                System.out.println("Enter correct command");
            }
            System.out.print("Enter command in next format- (list | save uuid | delete uuid | get uuid | size | clear | exit): ");
            command = scanner.nextLine().split(" ");
        }
        System.out.println("Thanks. Bye.");
    }


    private static void switchingOperations(String[] command, Employee employee) {

        switch (command[0]) {
            case "list":
                printAll();
                break;
            case "save":
                ARRAY_STORAGE1.save(employee);
                printAll();
                break;
            case "delete":
                ARRAY_STORAGE1.delete(command[1]);
                printAll();
                break;
            case "get":
                System.out.println("Get employee: " + ARRAY_STORAGE1.get(command[1]));
                break;
            case "size":
                System.out.println("Storage size: " + ARRAY_STORAGE1.size());
                break;
            case "clear":
                ARRAY_STORAGE1.clear();
                printAll();
                break;
            case "exit":
                System.out.println("Thanks. Bye.");
                break;
        }
    }


    static void printAll() {
        if ((ARRAY_STORAGE1.size() == 0)) {
            System.out.println("List is empty now");
        } else {
            for (Employee employee : ARRAY_STORAGE1.getAll()) {
                System.out.println(employee);
            }
        }

    }

}
