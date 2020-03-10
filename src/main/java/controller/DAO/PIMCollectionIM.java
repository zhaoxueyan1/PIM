package controller.DAO;

import controller.PoolManager;
import model.PIM.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class PIMCollectionIM implements PIMCollectionDAO<Exception> {
    private static PIMCollectionIM e =  null;

    public static PIMCollectionIM getInstance() {
       if(e==null)
       {
           e=new PIMCollectionIM();
           System.out.println("Init DAO ok");
       }
       return e ;
    }
    @Override
    public PIMCollection getAllByTable(String tableName) throws Exception {
        PIMCollection logs = new PIMCollection();
        Connection conn = PoolManager.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("select * from "+tableName);
        int c = rs.getMetaData().getColumnCount();
        String[] as = new String[10];
        while(rs.next()){
            for (int i=2;i<=c;i++) {
                as[i-2] = (rs.getString(i));
            }
            PIMEntity e =null;
            switch (tableName){
                case "Appointment": e= new PIMAppointment();break;
                case "Contact": e= new PIMContact();break;
                case "Note": e= new PIMNote();break;
                case "Todo": e= new PIMTodo();break;
            }
            assert e != null;
            e.setId(rs.getString(1));
            e.fromString(as);
            logs.add(e);
        }
        rs.close();
        PoolManager.freeConnection(conn);
        return logs;
    }

    @Override
    public PIMCollection getNotes(String owner) throws Exception {
        PIMCollection logs = new PIMCollection();
        Connection conn = PoolManager.getConnection();
        Statement statement = conn.createStatement();
        //System.out.println("select * from Note WHERE owner='"+owner+"'");
        ResultSet rs = statement.executeQuery("select * from Note WHERE owner='"+owner+"'");
        int c = rs.getMetaData().getColumnCount();
        String[] as = new String[10];
        while(rs.next()){
            for (int i=2;i<=c;i++) {
                as[i-2] = (rs.getString(i));
            }
            PIMEntity e =null;
            e= new PIMNote();
            e.setId(rs.getString(1));
//            e.setId(rs.getString(1));
            e.fromString(as);
            logs.add(e);
        }
        rs.close();
        PoolManager.freeConnection(conn);
        return logs;
    }


    @Override
    public PIMCollection getTodos(String owner) throws Exception {
        PIMCollection logs = new PIMCollection();
        Connection conn = PoolManager.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("select * from Todo WHERE owner='"+owner+"'");
        int c = rs.getMetaData().getColumnCount();
        String[] as = new String[10];
        while(rs.next()){
            for (int i=2;i<=c;i++) {
                as[i-2] = (rs.getString(i));
            }
            PIMEntity e =null;
            e= new PIMTodo();
            e.setId(rs.getString(1));
            e.fromString(as);
            logs.add(e);
        }
        rs.close();
        PoolManager.freeConnection(conn);
        return logs;
    }

    @Override
    public PIMCollection getAppointments(String owner) throws Exception {
        PIMCollection logs = new PIMCollection();
        Connection conn = PoolManager.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("select * from Appointment WHERE owner='"+owner+"'");
        int c = rs.getMetaData().getColumnCount();
        String[] as = new String[10];
        while(rs.next()){
            for (int i=2;i<=c;i++) {
                as[i-2] = (rs.getString(i));
            }
            PIMEntity e =null;
            e= new PIMAppointment();
            e.setId(rs.getString(1));
            e.fromString(as);
            logs.add(e);
        }
        rs.close();
        PoolManager.freeConnection(conn);
        return logs;
    }

    @Override
    public PIMCollection getContacts(String owner) throws Exception {
        PIMCollection logs = new PIMCollection();
        Connection conn = PoolManager.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("select * from Contact WHERE owner='"+owner+"'");
        int c = rs.getMetaData().getColumnCount();
        String[] as = new String[10];
        while(rs.next()){
            for (int i=2;i<=c;i++) {
                as[i-2] = (rs.getString(i));
            }
            PIMEntity e =null;
            e= new PIMContact();
            e.setId(rs.getString(1));
            e.fromString(as);
            logs.add(e);
        }
        rs.close();
        PoolManager.freeConnection(conn);
        return logs;
    }

    @Override
    public PIMCollection getItemsForDate(Date d) throws Exception {
        //System.out.println(DateOperation.sdf.format(d));
        PIMCollection logs = new PIMCollection();
        String[] as = new String[10];
        int c;
        Connection conn = PoolManager.getConnection();
        Statement statement = conn.createStatement();

        ResultSet rs = statement.executeQuery("select * from Appointment where DATE_FORMAT(date,'%Y-%m-%d')='"+DateOperation.sdf.format(d)+"'");
        c = rs.getMetaData().getColumnCount();
        while(rs.next()){
            for (int i=2;i<=c;i++) {
                as[i-2] = (rs.getString(i));
            }
            PIMEntity e =null;
            e= new PIMAppointment();
            e.setId(rs.getString(1));
            e.fromString(as);
            //System.out.println(as);
            logs.add(e);
        }

        rs = statement.executeQuery("select * from Todo where DATE_FORMAT(date,'%Y-%m-%d') = '"+DateOperation.sdf.format(d)+"'");
        c = rs.getMetaData().getColumnCount();
        while(rs.next()){
            for (int i=2;i<=c;i++) {
                as[i-2] = (rs.getString(i));
            }
            PIMEntity e =null;
            e= new PIMTodo();
            e.setId(rs.getString(1));
            e.fromString(as);
            logs.add(e);
        }

        rs.close();
        PoolManager.freeConnection(conn);
        return logs;
    }

    @Override
    public PIMCollection getItemsForDate(Date d, String owner) throws Exception {
        PIMCollection logs = new PIMCollection();
        String[] as = new String[10];
        int c;
        Connection conn = PoolManager.getConnection();
        Statement statement = conn.createStatement();

        System.out.println("select * from Appointment where date='"+d+"' and owner ='"+owner+"'");
        ResultSet rs = statement.executeQuery("select * from Appointment where date='"+DateOperation.sdf.format(d)+"' and owner ='"+owner+"'");
        c = rs.getMetaData().getColumnCount();
        while(rs.next()){
            for (int i=2;i<=c;i++) {
                as[i-2] = (rs.getString(i));
            }
            PIMEntity e =null;
            e= new PIMAppointment();
            e.setId(rs.getString(1));
            e.fromString(as);
            logs.add(e);
        }

        rs = statement.executeQuery("select * from Todo WHERE date='"+DateOperation.sdf.format(d)+"' and owner ='"+owner+"'");
        c = rs.getMetaData().getColumnCount();
        while(rs.next()){
            for (int i=2;i<=c;i++) {
                as[i-2] = (rs.getString(i));
            }
            PIMEntity e =null;
            e= new PIMAppointment();
            e.setId(rs.getString(1));
            e.fromString(as);
            logs.add(e);
        }

        rs.close();
        PoolManager.freeConnection(conn);
        return logs;
    }

    @Override
    public PIMCollection getAll() throws Exception {
        PIMCollection e = getAllByTable("Appointment");
        e.addAll(getAllByTable("Contact"));
        e.addAll(getAllByTable("Note"));
        e.addAll(getAllByTable("Todo"));
        return e;
    }

    @Override
    public PIMCollection getAllByOwner(String owner) throws Exception {
        PIMCollection e = getNotes(owner);
        e.addAll(getContacts(owner));
        e.addAll(getAppointments(owner));
        e.addAll(getTodos(owner));
        return e;
    }

    @Override
    public boolean add(PIMEntity e) throws Exception {
        System.out.println(e.toString());
        Connection conn = PoolManager.getConnection();
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(e.toString());
            statement.close();

            System.out.println("插入成功");
            return true;
        }
        catch (Exception t){
            System.out.println("Error, plz check your input!");
        }
        PoolManager.freeConnection(conn);
        return false;
    }

    @Override
    public boolean delete(PIMEntity e) throws Exception {
        Connection conn = PoolManager.getConnection();
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(e.toDeleteStringById());
            statement.close();
            System.out.println("删除成功");
            return true;
        }
        catch (Exception t){
            System.out.println("Error, plz check your input!");
        }
        PoolManager.freeConnection(conn);
        return false;
    }
}
