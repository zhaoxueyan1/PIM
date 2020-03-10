package model.PIM;

import java.util.ArrayList;

public class PIMContact extends PIMEntity {
    //String priority;
    String first_name, last_name, email_address;

    public PIMContact() {
        this.tableName = "Contact";
    }

    public PIMContact(String first_name, String last_name, String email_address, String pri,String owner) {
        super(pri,owner);
        this.first_name = first_name;
        this.last_name = last_name;
        this.email_address = email_address;
        this.tableName = "Contact";
    }

    @Override
    public void fromString(String[] s) {
        this.first_name = s[0];
        this.last_name = s[1];
        this.email_address = s[2];
        this.Priority = s[3];
        this.owner = s[4];
    }

    @Override
    public String toDeleteString() {
        String res = String.format("delete from Contact where first_name='%s' and last_name='%s' and "
                        + "'email_address='%s' and Priority='%s' and owner = '%s'",
                this.first_name,
                this.last_name,
                this.email_address,
                this.Priority,
                this.owner);
        return res;
    }

    @Override
    public String toString() {
        String res = "insert into Contact values(null,";
        res += "\""+this.first_name   +"\""   + ",";
        res += "\""+this.last_name    +"\""   + ",";
        res += "\""+this.email_address+"\""   + ",";
        res += "\""+this.Priority     +"\""   + ",";
        res += "\""+this.owner        +"\""   ;
        res += ")";
        return res;
    }

    @Override
    public ArrayList<String> toDescription() {
        ArrayList<String> e = new ArrayList<String>();
        e.add(this.first_name   );
        e.add(this.last_name    );
        e.add(this.email_address);
        e.add(this.Priority     );
        e.add(this.owner        );
        return e;
    }
}


