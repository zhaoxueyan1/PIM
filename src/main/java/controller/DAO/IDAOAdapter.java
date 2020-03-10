package controller.DAO;

import model.PIM.PIMCollection;
import model.PIM.PIMEntity;

import java.util.Date;

public interface IDAOAdapter<CustomizedException extends Throwable> {
    public PIMCollection getNotes(String owner) throws CustomizedException;
    //public PIMCollection getTodos() throws CustomizedException;
    public PIMCollection getTodos(String owner) throws CustomizedException;
    // public PIMCollection getAppointments() throws CustomizedException;
    public PIMCollection getAppointments(String owner) throws CustomizedException;
    //public PIMCollection getContacts() throws CustomizedException;
    public PIMCollection getContacts(String owner) throws CustomizedException;
    public PIMCollection getItemsForDate(Date d) throws CustomizedException;
    public PIMCollection getItemsForDate(Date d, String owner) throws CustomizedException;
    public PIMCollection getAll() throws CustomizedException;
    public PIMCollection getAllByOwner(String owner) throws CustomizedException;
    public PIMCollection getAllByTable(String tableName) throws CustomizedException;
    public boolean add(PIMEntity e) throws CustomizedException;
    public boolean delete(PIMEntity e) throws CustomizedException;
}
