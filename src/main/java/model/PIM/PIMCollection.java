package model.PIM;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class PIMCollection extends ArrayList<PIMEntity> {
    public Collection<PIMEntity> getNotes() {
        Collection<PIMEntity> res = new ArrayList<PIMEntity>();
        for (PIMEntity e : this) {
            if (e instanceof PIMNote) {
                res.add(e);
            }
        }
        return res;
    }

    public Collection<PIMEntity> getTodos() {
        Collection<PIMEntity> res = new ArrayList<PIMEntity>();
        for (PIMEntity e : this) {
            if (e instanceof PIMTodo) {
                res.add(e);
            }
        }
        return res;
    }

    public Collection<PIMEntity> getAppointments() {
        Collection<PIMEntity> res = new ArrayList<PIMEntity>();
        for (PIMEntity e : this) {
            if (e instanceof PIMAppointment) {
                res.add(e);
            }
        }
        return res;
    }


    public Collection<PIMEntity> getContacts() {
        Collection<PIMEntity> res = new ArrayList<PIMEntity>();
        for (PIMEntity e : this) {
            if (e instanceof PIMContact) {
                res.add(e);
            }
        }
        return res;
    }

    public Collection<PIMEntity> getItemsForDate(Date d) throws ParseException {
        Collection<PIMEntity> res = new ArrayList<PIMEntity>();
        for (PIMEntity e : this) {
            if (e instanceof PIMAppointment || e instanceof PIMTodo) {
                if (d.equals(((DateOperation) e).getDate()))
                    res.add(e);
            }
        }
        return res;
    }

}


