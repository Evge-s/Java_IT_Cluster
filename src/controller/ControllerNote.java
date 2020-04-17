package controller;
import model.Note;
import repository.NoteRepository;
import view.View;

import java.util.Date;
import java.util.List;

public class ControllerNote {
    private List<Note> notes = NoteRepository.getInstance().getNotes();
    private View view = new View();
    private String[] commandList = {
            "create",
            "edit",
            "show",
            "delete",
            "exit"
    };

    public String[] getCommandList(){
        return commandList;
    }

    public void doCommand(String command){
        switch (command){
            case "create":
                CreateNote();
                break;
            case "show":
                if(!EmptyCheck()) {
                    Show();
                }
                break;
            case "edit":
                if(!EmptyCheck()) {
                    Edit();
                }
                break;
            case "delete":
                if(!EmptyCheck()) {
                    Delete();
                }
                break;
        }
    }

    public boolean EmptyCheck(){
        if(notes.isEmpty()) {
            view.viewOutputLine("Note List is empty!");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean CheckCommand(String command){
        for (String commandStr: commandList){
            if(commandStr.equals(command)){
                return true;
            }
        }
        return false;
    }

    public void CreateNote(){
        Note note = new Note();
        NoteSetData(note);
        notes.add(note);
        view.viewOutputLine("note " + note.getLabel() + " created");
    }

    public void Edit(){
        view.viewOutputLine("Witch one? Enter note label:");
        String str = view.userInput();
        for (Note note: notes){
            if(note.getLabel().equals(str)){
                NoteSetData(note);
                view.viewOutputLine("note " + note.getLabel() + " edited");
                break;
            }
        }
    }

    public void Delete(){
        view.viewOutputLine("Witch one? Enter note label:");
        String str = view.userInput();
        for (Note note: notes){
            if(note.getLabel().equals(str)){
                view.viewOutputLine("note " + note.getLabel() + " removed");
                notes.remove(note);
                break;
            }
        }
    }

    public void NoteSetData(Note note){
        view.viewOutputLine("Input note text:");
        note.setText(view.userInput());

        view.viewOutputLine("Input Label:");
        note.setLabel(view.userInput());

        view.viewOutputLine("Input Is Note complete? (done or to do)");
        note.setChecked("done".equals(view.userInput()));
        Date date = new Date();
        note.setDate(date.toString());
    }

    public void Show(){
        String[] notesList = new String[notes.size()];
        int i = 0;

        for (Note note : notes){
            notesList[i] = note.toString();
            i++;
        }
        view.viewOutputList(notesList);
    }
}
