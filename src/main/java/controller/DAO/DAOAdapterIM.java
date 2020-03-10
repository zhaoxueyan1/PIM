package controller.DAO;

import model.PIM.PIMCollection;
import model.PIM.PIMEntity;

import java.util.Date;

public class DAOAdapterIM implements IDAOAdapter{

    @Override
    public PIMCollection getNotes(String owner) throws Throwable {
        return PIMCollectionIM.getInstance().getNotes(owner);
    }

    @Override
    public PIMCollection getTodos(String owner) throws Throwable {
        return PIMCollectionIM.getInstance().getTodos(owner);
    }

    @Override
    public PIMCollection getAppointments(String owner) throws Throwable {
        return PIMCollectionIM.getInstance().getAppointments(owner);
    }

    @Override
    public PIMCollection getContacts(String owner) throws Throwable {
        return PIMCollectionIM.getInstance().getContacts(owner);
    }

    @Override
    public PIMCollection getItemsForDate(Date d) throws Throwable {
        return PIMCollectionIM.getInstance().getItemsForDate(d);
    }

    @Override
    public PIMCollection getItemsForDate(Date d, String owner) throws Throwable {
        return PIMCollectionIM.getInstance().getItemsForDate(d,owner);
    }

    @Override
    public PIMCollection getAll() throws Throwable {
        return PIMCollectionIM.getInstance().getAll();
    }

    @Override
    public PIMCollection getAllByOwner(String owner) throws Throwable {
        return PIMCollectionIM.getInstance().getAllByOwner(owner);
    }

    @Override
    public PIMCollection getAllByTable(String tableName) throws Throwable {
        return PIMCollectionIM.getInstance().getAllByTable(tableName);
    }

    @Override
    public boolean add(PIMEntity e) throws Throwable {
        return PIMCollectionIM.getInstance().add(e);
    }

    @Override
    public boolean delete(PIMEntity e) throws Throwable {
        return PIMCollectionIM.getInstance().delete(e);
    }
}
