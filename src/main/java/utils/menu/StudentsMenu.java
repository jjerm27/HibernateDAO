package utils.menu;

import services.GroupService;
import services.UserService;

import java.util.Scanner;

public class StudentsMenu implements Menu {

    private UserService userService = new UserService();
    private GroupService groupService = new GroupService();
    private Scanner scan = new Scanner(System.in);
    private String name;
    private int age, idUser, idGroup, result;

    @Override
    public void showMenu() {
        do {
            System.out.println("\nChoose your action:");
            System.out.println("\n1 - Add student");
            System.out.println("\n2 - Change group for student");
            System.out.println("\n3 - Change student info");
            System.out.println("\n4 - Delete student");
            System.out.println("\n5 - Show all students");
            System.out.println("\n0 - Exit");

            result = choice();
        } while (result != 0);
    }

    @Override
    public int choice() {
        int btn;
        System.out.println("Make your choice");
        btn = scan.nextInt();
        chooseAction(btn);
        return btn;
    }

    @Override
    public void chooseAction(int btn) {
        switch (btn) {
            case 1:
                scan = new Scanner(System.in);
                System.out.println("Enter student name");
                name = scan.nextLine();
                System.out.println("Enter student age");
                age = scan.nextInt();
                userService.addUser(name, age);
                break;
            case 2:
                scan = new Scanner(System.in);
                userService.showAll();
                System.out.println("Enter student ID");
                idUser = scan.nextInt();

                System.out.println("Enter group ID");
                groupService.showAll();
                idGroup = scan.nextInt();

                userService.changeGroupForStudent(idUser,idGroup);
                break;
            case 3:
                scan = new Scanner(System.in);
                userService.showAll();
                System.out.println("Enter students name");
                name = scan.nextLine();
                System.out.println("Enter students age");
                age = scan.nextInt();
                System.out.println("Enter student ID");
                idUser = scan.nextInt();
                userService.changeUserInfo(idUser, name, age);
                System.out.println("User changed");
                break;
            case 4:
                scan = new Scanner(System.in);
                userService.showAll();
                System.out.println("Enter student ID");
                idUser = scan.nextInt();
                userService.deleteUser(idUser);
                break;
            case 5:
                userService.showAll();
                break;
            case 0:
                System.out.println("Bye!");
                Runtime.getRuntime().exit(0);
                break;
            default:
                System.out.println("Choose the action");
                break;
        }
    }
}
