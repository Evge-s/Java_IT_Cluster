package controller;
import model.Note;

import java.util.ArrayList;
import java.util.List;

public class ControllerNote {
    private List<Note> notes = new ArrayList<>();

    public void CreateNote(String text, String date, String label, boolean check) {
        Note note = new Note(text, date, label, check);
        notes.add(note);
    }

    public boolean EditNote(String text, String date, String label, boolean check) {
        for(Note note: notes){
            if(note.getLabel() == label) {
                note.setText(text);
                note.setDate(date);
                note.setLabel(label);
                note.setChecked(check);
                return true;
            }
        }
        return false;
    }

    public boolean DeleteNote(String label) {
        for (Note note : notes) {
            if (note.getLabel().equals(label)) {
                notes.remove(note);
                return true;
            }
        }
        return false;
    }

    public boolean Show(){
        if(!notes.isEmpty()) {
            for (Note note : notes) {
                System.out.println(note.toString());
            }
            return true;
        }
        else {
            return false;
        }
    }

}
