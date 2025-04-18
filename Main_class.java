package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame {

    Main_class(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon((i2));
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,1120,500);
        add(img);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(340,120,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,25));
        img.add(heading);

        JButton add = new JButton("Add Employee");
        add.setBounds(355,200,130,40);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Add_employee();
            }
        });
        img.add(add);

        JButton view = new JButton("View Employee");
        view.setBounds(565,200,130,40);
        view.setForeground(Color.WHITE);
        view.setBackground(Color.BLACK);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ViewEmployee();
            }
        });
        img.add(view);

        JButton rem = new JButton("Remove Employee");
        rem.setBounds(450,280,150,40);
        rem.setForeground(Color.WHITE);
        rem.setBackground(Color.BLACK);
        rem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new RemoveEmployee();
            }
        });
        img.add(rem);


        setSize(1000,500);
        setLocation(100,100);
        setLayout(null);
        setVisible(true);
    }

        public static void main(String args[]){
            new Main_class();
        }
}
