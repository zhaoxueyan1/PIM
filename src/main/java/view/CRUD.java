package view;

import controller.DAO.IDAOAdapter;
import controller.DAO.PIMCollectionIM;
import controller.rpc.socketrpc.client.RpcClientProxy;
import model.PIM.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

import javax.swing.*;

public class CRUD {
    private String owner;
    private JFrame parentFrm;
    private JFrame chFrm;
    private JPanel panel_main;
    private int year;
    private int month;
    private int day;
    private String state = "all";
    RpcClientProxy client = new RpcClientProxy<>(IDAOAdapter.class,"localhost","6666");
    IDAOAdapter RPCService = (IDAOAdapter) client.getClientIntance ();

    public CRUD() {
    }

    public CRUD(String owner,String state, JFrame parentFrm, int year, int month, int day) {
        this.owner = owner;
        this.state = state;
        this.month = month;
        this.year = year;
        this.day = day;
        this.parentFrm = parentFrm;
    }

    public void init() {
        chFrm = new JFrame();
        this.chFrm.addWindowListener(new WindowAdapter() {
                                         @Override
                                         public void windowClosing(WindowEvent e) {
                                             super.windowClosing(e);
                                             CRUD.this.parentFrm.setVisible(true);
                                         }
                                     }
        );
        chFrm.setSize(700, 300);
        int screen_width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screen_height = Toolkit.getDefaultToolkit().getScreenSize().height;
        chFrm.setLocation((screen_width - chFrm.getWidth()) / 2, (screen_height - chFrm.getHeight()) / 2);
        panel_main = new JPanel();
        panel_main.setLayout(new GridLayout(10, 1));
        chFrm.getContentPane().add(panel_main);
        chFrm.setVisible(true);
        if (state.equals("all")) {
            getAll();
        } else {
            getByDate();
        }
        addPanel();
    }

    public void getByDate() {
        try {
            PIMCollection e = RPCService.getItemsForDate(DateOperation.sdf.parse(year + "-" + month + "-" + day),owner);
            for (PIMEntity tt : e) {
                showEntity(tt);
            }
        } catch (Exception e) {
            System.out.println("Error ,plz check the input.");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public void getAll() {
        try {
            PIMCollection e = RPCService.getAllByOwner(this.owner);
            for (PIMEntity tt : e) {
                showEntity(tt);
            }
        } catch (Exception e) {
            System.out.println("Error ,plz check the input.");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public void showEntity(final PIMEntity tt) {
        final JPanel entityPanel = new JPanel(new GridLayout(1, 8));
        JButton tableName = new JButton("Class :" + tt.getTableName());
        JButton id = new JButton("Id :" + tt.getId());
        entityPanel.add(tableName);
        entityPanel.add(id);
        for (String ss : tt.toDescription()) {
            JButton t = new JButton(ss);
            entityPanel.add(t);
        }
        JButton delete = new JButton("删除");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    RPCService.delete(tt);
                } catch (Exception e) {
                    System.out.println("Check your input,plz");
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        });
        entityPanel.add(delete);
        panel_main.add(entityPanel);
    }


    public void addPanel() {
        final JPanel addPanel = new JPanel();
        final JComboBox<String> itemBox = new JComboBox<String>();
        itemBox.addItem("Appointment");
        itemBox.addItem("Contact");
        itemBox.addItem("Note");
        itemBox.addItem("Todo");
        addPanel.add(itemBox);
        itemBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                addPanel.removeAll();
                addPanel.add(itemBox);
                switch (itemBox.getSelectedIndex()) {
                    case 0: {
                        //System.out.println((String) Objects.requireNonNull(itemBox.getSelectedItem()));
                        final JTextField date = new JTextField("date       ");
                        final JTextField description = new JTextField("description");
                        final JTextField Priority = new JTextField("Priority   ");
                        final JTextField owner = new JTextField("owner      ");
                        addPanel.add(date);
                        addPanel.add(description);
                        addPanel.add(Priority);
                        addPanel.add(owner);
                        JButton addButton = new JButton("添加");
                        addPanel.add(addButton);
                        addButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent actionEvent) {
                                PIMEntity e = new PIMAppointment();
                                e.fromString(new String[]{date.getText(), description.getText(), Priority.getText(), owner.getText()});
                                try {

                                    PIMCollectionIM.getInstance().add(e);
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                    System.out.println("Check your input plz.");
                                }
                            }
                        });
                        break;
                    }
                    case 1: {
                        final JTextField first_name = new JTextField("first_name   ");
                        final JTextField last_name = new JTextField("last_name    ");
                        final JTextField email_address = new JTextField("email_address");
                        final JTextField Priority = new JTextField("Priority     ");
                        final JTextField owner = new JTextField("owner        ");
                        addPanel.add(first_name);
                        addPanel.add(last_name);
                        addPanel.add(email_address);
                        addPanel.add(Priority);
                        addPanel.add(owner);
                        final PIMEntity e = new PIMContact();
                        JButton addButton = new JButton("添加");
                        addPanel.add(addButton);
                        addButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent actionEvent) {
                                e.fromString(new String[]{first_name.getText(), last_name.getText(), email_address.getText(), Priority.getText(), owner.getText()});
                                try {
                                    PIMCollectionIM.getInstance().add(e);
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                    System.out.println("Check your input plz.");
                                }
                            }
                        });
                        break;
                    }
                    case 2: {
                        final JTextField text = new JTextField("text       ");
                        //final JTextField description  = new JTextField("description");
                        final JTextField Priority = new JTextField("Priority   ");
                        final JTextField owner = new JTextField("owner      ");
                        addPanel.add(text);
                        //addPanel.add(description);
                        addPanel.add(Priority);
                        addPanel.add(owner);
                        final PIMEntity e = new PIMNote();
                        JButton addButton = new JButton("添加");
                        addPanel.add(addButton);
                        addButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent actionEvent) {
                                e.fromString(new String[]{text.getText(), Priority.getText(), owner.getText()});
                                try {
                                    RPCService.add(e);
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                    System.out.println("Check your input plz.");
                                } catch (Throwable throwable) {
                                    throwable.printStackTrace();
                                }
                            }
                        });
                        break;
                    }
                    case 3: {
                        final JTextField date = new JTextField("date       ");
                        final JTextField item = new JTextField("item       ");
                        final JTextField Priority = new JTextField("Priority   ");
                        final JTextField owner = new JTextField("owner      ");
                        addPanel.add(date);
                        addPanel.add(item);
                        addPanel.add(Priority);
                        addPanel.add(owner);
                        final PIMEntity e = new PIMTodo();
                        JButton addButton = new JButton("添加");
                        addPanel.add(addButton);
                        addButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent actionEvent) {
                                e.fromString(new String[]{date.getText(), item.getText(), Priority.getText(), owner.getText()});
                                try {
                                    RPCService.add(e);
                                } catch (Throwable ex) {
                                    ex.printStackTrace();
                                    System.out.println("Check your input plz.");
                                }
                            }
                        });
                        break;
                    }
                    default:
                        break;
                }
                addPanel.repaint();
                addPanel.revalidate();
                panel_main.add(addPanel);
                panel_main.repaint();
                chFrm.repaint();
            }
        });
        itemBox.setSelectedIndex(1);
        panel_main.add(addPanel);
        panel_main.repaint();
    }

    public void open() {
        init();
    }
}
