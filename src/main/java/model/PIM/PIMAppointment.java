package model.PIM;

import javax.swing.text.html.parser.Entity;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class PIMAppointment extends PIMEntity implements DateOperation {
    //String priority;
    String date;
    String description;


    public PIMAppointment(String date, String description, String pri, String owner) {
        super(pri, owner);
        this.date = date;
        this.description = description;
        this.tableName = "Appointment";
    }

    public PIMAppointment() {
        this.tableName = "Appointment";
    }

    @Override
    public void fromString(String[] s) {
        this.date = s[0];
        this.description = s[1];
        this.Priority = s[2];
        this.owner = s[3];
    }

    @Override
    public String toString() {
        String res = "insert into Appointment values(null,";
        res += "\"" + this.date + "\"" + ",";
        res += "\"" + this.description + "\"" + ",";
        res += "\"" + this.Priority + "\"" + ",";
        res += "\"" + this.owner + "\"";
        res += ")";
        return res;
    }

    @Override
    public String toDeleteString() {
        String res = String.format("delete from Appointment where date='%s' and description='%s' and "
                        + "'Priority='%s' and owner = '%s'",
                this.date,
                this.description,
                this.Priority,
                this.owner);
        return res;
    }

    @Override
    public ArrayList<String> toDescription() {
        ArrayList<String> e = new ArrayList<String>();
        e.add(this.date);
        e.add(this.description);
        e.add(this.Priority);
        e.add(this.owner);
        return e;
    }

    @Override
    public void SetDate(Date s) {

    }

    @Override
    public void SetDate() {

    }

    @Override
    public Date getDate() throws ParseException {
        return DateOperation.sdf.parse(this.date);
    }
}


