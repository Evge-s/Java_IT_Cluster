package view;
import java.util.Scanner;

public class View {
    private Scanner scanner = new Scanner(System.in);

    public String userInput(){
        System.out.print("Input -> ");
        return scanner.nextLine();
    }

    public void viewOutputLine(String line){
        System.out.println(line);
    }

    public void viewOutputList(String[] list){
        for(String line: list)
            System.out.println("-> " + line);
    }
}
