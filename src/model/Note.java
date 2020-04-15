package model;

import java.util.Objects;

public class Note {
    private String text;
    private String date;
    private String label;
    private boolean checked;

    public Note() {
    }

    public Note(String text, String date, String label, boolean checked) {
        this.text = text;
        this.date = date;
        this.label = label;
        this.checked = checked;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getText() {
        return text;
    }

    public String getDate() {
        return date;
    }

    public boolean isChecked() {
        return checked;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note1 = (Note) o;
        return checked == note1.checked &&
                text.equals(note1.text) &&
                date.equals(note1.date) &&
                label.equals(note1.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, date, checked, label);
    }

    @Override
    public String toString() {
        return label + "\t\t" + text + "\t\t" + " Date: " + date + " checked: " + checked;
    }
}
