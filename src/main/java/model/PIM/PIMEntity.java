package model.PIM;

import javax.swing.text.html.parser.Entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class PIMEntity implements Serializable {
    protected String Priority; // every kind of item has a priority
    protected String owner;
    protected String id;
    protected String tableName;
    // default constructor sets priority to "normal"
    PIMEntity() {
        Priority = "normal";
    }

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public String getTableName(){
        return this.tableName;
    }
    // priority can be established via this constructor.
    PIMEntity(String priority,String owner) {
        Priority = priority;
        this.owner = owner;
    }

    public String toDeleteStringById(){
        return "delete from "+tableName+" where id="+id;
    }
    // accessor method for getting the priority string
    public String getPriority() {
        return Priority;
    }

    // method that changes the priority string
    public void setPriority(String p) {
        Priority = p;
    }

    // Each PIMEntity needs to be able to set all state information
    // (fields) from a single text string.
    abstract public void fromString(String[] s);

    // This is actually already defined by the super class
    // Object, but redefined here as abstract to make sure
    // that derived classes actually implement it
    abstract public String toString();
    abstract public String toDeleteString();
    abstract public ArrayList<String> toDescription();

}


