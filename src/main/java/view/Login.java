package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Enter{
    private JFrame jFrame;
    Enter(){
    }
    void init(){
        jFrame = new JFrame("Enter");
        JPanel panel = new JPanel(new GridLayout());
        final JTextField owner = new JTextField("请输入用户名");
        JButton button = new JButton("登录");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Calender ct = new Calender(owner.getText());
                ct.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ct.setVisible(true);
                jFrame.dispose();
            }
        });
        panel.add(owner);
        panel.add(button);
        jFrame.getContentPane().add(panel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setSize(700, 100);
        int screen_width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screen_height = Toolkit.getDefaultToolkit().getScreenSize().height;
        jFrame.setLocation((screen_width - jFrame.getWidth()) / 2, (screen_height - jFrame.getHeight()) / 2);
    }

}

public class Login {
    public static void main(String[] args) {
        Enter e = new Enter();
        e.init();
    }

}
