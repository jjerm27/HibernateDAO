package utils.menu;

import java.util.Scanner;

public class AllMenu implements Menu {

    Scanner scan = new Scanner(System.in);
    int result;

    @Override
    public void showMenu() {
        do {
            System.out.println("\nChoose your action:");
            System.out.println("\n1 - Actions with groups");
            System.out.println("\n2 - Actions with students");
            System.out.println("\n0 - Exit");

            result = choice();
        } while (result != 0);
    }

    @Override
    public int choice() {
        System.out.println("Make your choice");
        int btn = scan.nextInt();
        chooseAction(btn);
        return btn;
    }

    @Override
    public void chooseAction(int btn) {
        switch (btn) {
            case 1:
                new GroupsMenu().showMenu();
                break;
            case 2:
                new StudentsMenu().showMenu();
                break;
            case 0:
                System.out.println("Bye!");
                System.exit(0);
                break;
            default:
                System.out.println("Choose the action");
                break;
        }

    }
}
