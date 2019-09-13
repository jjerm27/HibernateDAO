package utils.menu;

import services.GroupService;

import java.util.Scanner;


public class GroupsMenu implements Menu  {

    private GroupService groupService = new GroupService();
    public Scanner scan;
    private int idGroup, idUser, result;



    @Override
    public void showMenu(){

        do {
            System.out.println("\nChoose your action:");
            System.out.println("\n1 - Add group");
            System.out.println("\n2 - Update group number");
            System.out.println("\n3 - Delete group");
            System.out.println("\n4 - Show all group");
            System.out.println("\n0 - Exit");

            result = choice();
        }while (result!=0);

    }

    @Override
    public int choice() {
        scan = new Scanner(System.in);
        int btn;
        System.out.println("Make your choice");
        btn = scan.nextInt();

        chooseAction(btn);
        return btn;
    }

    @Override
    public void chooseAction(int btn) {

        switch (btn){
            case 1:
                System.out.println("Enter group number");
                scan = new Scanner(System.in);
                String groupName = scan.nextLine();
                groupService.addGroup(groupName);
                break;
            case 2:
                scan = new Scanner(System.in);
                groupService.showAll();
                System.out.println("Enter new name of group");
                String n = scan.nextLine();
                System.out.println("Enter group ID");
                idGroup = scan.nextInt();
                groupService.updateGroupNumber(idGroup,n);
                break;
            case 3:
                groupService.showAll();
                scan = new Scanner(System.in);
                System.out.println("Enter group ID");
                idGroup = scan.nextInt();
                groupService.deleteGroup(idGroup);
                break;
            case 4:
                groupService.showAll();
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
