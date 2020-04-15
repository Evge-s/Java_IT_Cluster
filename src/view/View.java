package view;

import controller.ControllerNote;

import java.util.Scanner;

public class View {
    ControllerNote controllerNote = new ControllerNote();
    String command = "";
    private String text;
    private String date;
    private String label;
    private boolean check;

    public void startView(){
        while (true){
            System.out.println("All available commands:\n -> create\n -> show\n -> edit\n -> del\n -> exit");
            Scanner input = new Scanner(System.in).useDelimiter("\\n");
            System.out.print("\nInput command: ");
            command = input.nextLine().toLowerCase().trim();

            switch (command){
                case "create":
                    System.out.println("Enter note text:");
                    text = input.nextLine().trim();
                    System.out.println("Enter date");
                    date = input.nextLine().trim();
                    System.out.println("Enter label");
                    label = input.nextLine().trim();
                    System.out.println("Is checked? true/false");
                    check = input.nextBoolean();
                    controllerNote.CreateNote(text, date, label, check);
                    System.out.println("Note " + label + " created");
                    break;
                case "show":
                    if(controllerNote.Show()) {
                        System.out.println("\n");
                        break;
                    }
                    else{
                        System.out.println("Notes its empty!\n");
                    }
                    break;
                case "edit":
                    System.out.println("Enter note label: ");
                    label = input.nextLine().trim();
                    System.out.println("Enter note text");
                    text = input.nextLine().trim();
                    System.out.println("Enter date");
                    date = input.nextLine().trim();
                    System.out.println("Is checked? true/false");
                    check = input.nextBoolean();
                    controllerNote.EditNote(text, date, label, check);
                    break;
                case "del":
                    System.out.println("Enter note label: ");
                    label = input.nextLine().trim();
                    if(controllerNote.DeleteNote(label)) {
                        System.out.printf("note deleted");
                    }
                    else{
                        System.out.println("Incorrect label, note not found. Try again");
                    }
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("Incorrect command, try again");
            }
        }
    }
}
