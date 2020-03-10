package model.PIM;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class PIMTodo extends PIMEntity implements DateOperation {
    //String priority;
    String date;
    String item;

    public PIMTodo(String date, String item, String pri,String owner) {
        super(pri,owner);
        this.date = date;
        this.item = item;
        this.tableName = "Todo";
    }

    public PIMTodo() {
        this.tableName = "Todo";
    }

    @Override
    public void fromString(String[] s) {
        this.date = s[0];
        this.item = s[1];
        this.Priority = s[2];
        this.owner = s[3];
    }

    @Override
    public String toString() {
        String res = "insert into Todo values(null,";
        res += "\""+this.date     +"\"" + ",";
        res += "\""+this.item     +"\"" + ",";
        res += "\""+this.Priority +"\"" + ",";
        res += "\""+this.owner    +"\"" ;
        res += ")";
        return res;
    }

    @Override
    public ArrayList<String> toDescription() {
        ArrayList<String> e = new ArrayList<String>();
        e.add(this.date     );
        e.add(this.item     );
        e.add(this.Priority );
        e.add(this.owner    );
        return e;
    }

    @Override
    public String toDeleteString() {
        String res = String.format("delete from Todo where date='%s' and item='%s' and "
                        + "'Priority='%s' and owner = '%s'",
                this.date,
                this.item,
                this.Priority,
                this.owner);
        return res;
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


