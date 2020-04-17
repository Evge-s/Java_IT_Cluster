import controller.ControllerNote;
import view.View;

public class Main {
    public static void main(String[] args){
         String command = "";
         View view = new View();
         ControllerNote controllerNote = new ControllerNote();

        view.viewOutputLine("\t\t\t\t\tNOTE++\nAll commands:");
        view.viewOutputList(controllerNote.getCommandList());

        while (true) {
            command = view.userInput().toLowerCase().trim();
            switch (command){
                case "exit":
                    System.exit(0);
                case "help":
                    view.viewOutputLine("All commands:");
                    view.viewOutputList(controllerNote.getCommandList());
                    break;
                default:
                    if(controllerNote.CheckCommand(command)){
                        controllerNote.doCommand(command);
                    }
                    else if(!controllerNote.CheckCommand(command)){
                        view.viewOutputLine("Incorrect command!");
                    }
            }
        }
    }
}

