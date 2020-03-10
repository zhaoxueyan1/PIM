package model.PIM;

import java.util.ArrayList;

public class PIMNote extends PIMEntity {
    //String priority;
    private String text;

    public PIMNote(String text, String pri,String owner) {
        super(pri,owner);
        this.text = text;
        this.tableName = "Note";
    }

    public PIMNote() {
        this.tableName = "Note";
    }

    @Override
    public void fromString(String[] s) {
        this.text = s[0];
        this.Priority = s[1];
        this.owner = s[2];
    }

    @Override
    public String toString() {
        String res = "insert into Note values(null,";
        res += "\""+this.text    +"\""+ ",";
        res += "\""+this.Priority +"\""+"," ;
        res += "\""+this.owner   +"\"" ;
        res += ")";
        return res;
    }

    @Override
    public String toDeleteString() {
        String res = String.format("delete from Appointment where text='%s' and "
                        + "'Priority='%s' and owner = '%s'",
                this.text,
                this.Priority,
                this.owner);
        return res;
    }

    @Override
    public ArrayList<String> toDescription() {
        ArrayList<String> e = new ArrayList<String>();
        e.add(this.text    );
        e.add(this.Priority);
        e.add(this.owner   );
        return e;
    }
}


