package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Add_employee extends JFrame implements ActionListener {

    JTextField tname , tfname, taddress, tphone, taadhar, temail, tsalary;

    JLabel tempid ;

    JComboBox Boxeducation;

    Random ran = new Random();

    JButton add,back;

    int Number = ran.nextInt(1000);


    JDateChooser tdob;


    Add_employee(){

        getContentPane().setBackground(new Color(163,255,188));

        JLabel heading = new JLabel("Add Employee Details...");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        JLabel name = new JLabel("Name  :");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);

        tname = new JTextField();
        tname.setBounds(200,150,150,30);
        tname.setBackground(new Color(177,252,197));
        add(tname);

        JLabel fname = new JLabel("Father's name :");
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600,150,150,30);
        tfname.setBackground(new Color(177,252,197));
        add(tfname);

        JLabel dob = new JLabel("Date Of Birth :");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(dob);

        tdob =new JDateChooser();
        tdob.setBounds(200,200,150,30);
        tdob.setBackground(new Color(177,252,197));
        add(tdob);

        JLabel sal = new JLabel("Salary :");
        sal.setBounds(400,200,150,30);
        sal.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(sal);

        tsalary = new JTextField();
        tsalary.setBounds(600,200,150,30);
        tsalary.setBackground(new Color(177,252,197));
        add(tsalary);

        JLabel address = new JLabel("Address  :");
        address.setBounds(50,250,150,30);
        address.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200,250,150,30);
        taddress.setBackground(new Color(177,252,197));
        add(taddress);

        JLabel phone = new JLabel("Phone No. :");
        phone.setBounds(400,250,150,30);
        phone.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600,250,150,30);
        tphone.setBackground(new Color(177,252,197));
        add(tphone);

        JLabel aadhar = new JLabel("Aadhar No.  :");
        aadhar.setBounds(50,300,150,30);
        aadhar.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(aadhar);

        taadhar = new JTextField();
        taadhar.setBounds(200,300,150,30);
        taadhar.setBackground(new Color(177,252,197));
        add(taadhar);

        JLabel email = new JLabel("E-mail id :");
        email.setBounds(400,300,150,30);
        email.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(email);

        temail  = new JTextField();
        temail .setBounds(600,300,150,30);
        temail .setBackground(new Color(177,252,197));
        add(temail );

       JLabel edu = new JLabel("Education");
        edu.setBounds(50,350,150,30);
        edu.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(edu);

        String items[] = {"BBA","B.Tech","BCA", "BA", "BSC", "B.COM", "MBA", "MCA", "MA", "MTech", "MSC", "PHD"};
        Boxeducation = new JComboBox(items);
        Boxeducation.setBackground(new Color(177,252,197));
        Boxeducation.setBounds(200,350,150,30);
        add(Boxeducation);

        JLabel empId = new JLabel("Employee Id :");
        empId.setBounds(400,350,150,30);
        empId.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(empId);

        tempid  = new JLabel(""+Number);
        tempid.setBounds(600,350,200,30);
        tempid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        tempid.setForeground(Color.red);
        add(tempid );

        add = new JButton("ADD");
        add.setBounds(230,450,130,40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(450,450,130,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);


        setSize(900,600);
        setLocation(150,50);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add){
            String name = tname.getText();
            String fname = tfname.getText();
            String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String sal = tsalary.getText();
            String address = taddress.getText();
            String aadhar = taadhar.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String edu = (String) Boxeducation.getSelectedItem();
            String empId = tempid.getText();

            try{

                Conn con = new Conn();
                String q = " insert into emp values('" +name+ "', '" +fname+ "' , '" +dob+ "' ,'" +sal+ "','" +address+ "','" +phone+ "','" +email+ "','" +edu+ "','" +empId+ "','" +aadhar+ "')" ;
                con.statement.executeUpdate(q);

                JOptionPane.showMessageDialog(null,"Details added successfully...");
                setVisible(false);
                new Main_class();

            }catch (Exception E){
                E.printStackTrace();
                JOptionPane.showMessageDialog(null,"Some Error Occours...");
            }
        }
        else{
            new Main_class();
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Add_employee();
    }
}
