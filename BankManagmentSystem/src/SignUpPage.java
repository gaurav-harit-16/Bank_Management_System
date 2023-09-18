import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class SignUpPage extends JFrame implements ActionListener {
    JButton next;
    JDateChooser date;
    long random;
    JRadioButton male,female,married,unMarried;
    JTextField nameTextField,fatherNameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pinCodeTextField;
    SignUpPage (){
        setLayout(null);
        Random ran = new Random();
        //Now the below code will give us 4 digit random number
        random = Math.abs((ran.nextLong() % 9000)+ 1000);

        setSize(850,800);
        setLocation(350,10);
        getContentPane().setBackground(Color.WHITE);

        JLabel formNo=new JLabel("Application Form, Number : "+ random);
        formNo.setFont(new Font("Raleway", Font.BOLD,38));
        formNo.setBounds(140,20,600,40);
        add(formNo);

        JLabel personalDetails=new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD,22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);

        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        nameTextField=new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,20));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);

        JLabel fatherName=new JLabel("Father's Name:");
        fatherName.setFont(new Font("Raleway", Font.BOLD,20));
        fatherName.setBounds(100,190,200,30);
        add(fatherName);

        fatherNameTextField=new JTextField();
        fatherNameTextField.setFont(new Font("Raleway",Font.BOLD,20));
        fatherNameTextField.setBounds(300,190,400,30);
        add(fatherNameTextField);

        JLabel dateOfBirth=new JLabel("Date of Birth:");
        dateOfBirth.setFont(new Font("Raleway", Font.BOLD,20));
        dateOfBirth.setBounds(100,240,200,30);
        add(dateOfBirth);

        date=new JDateChooser();
        date.setBounds(300,240,400,30);
        date.setForeground(new Color(105,105,105));
        add(date);

        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);

        male=new JRadioButton("MALE");
        male.setBounds(300,290,70,30);
        male.setBackground(Color.WHITE);
        add(male);

        female=new JRadioButton("FEMALE");
        female.setBounds(450,290,80,30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email=new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);

        emailTextField=new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,20));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);

        JLabel maritialStatus=new JLabel("Maritial Status:");
        maritialStatus.setFont(new Font("Raleway", Font.BOLD,20));
        maritialStatus.setBounds(100,390,200,30);
        add(maritialStatus);

        married=new JRadioButton("Married");
        married.setBounds(300,390,70,30);
        married.setBackground(Color.WHITE);
        add(married);

        unMarried=new JRadioButton("UNMARRIED");
        unMarried.setBounds(450,390,100,30);
        unMarried.setBackground(Color.WHITE);
        add(unMarried);

        ButtonGroup maritialGroup=new ButtonGroup();
        maritialGroup.add(married);
        maritialGroup.add(unMarried);

        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);

        addressTextField=new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,20));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);

        JLabel city=new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);

        cityTextField=new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,20));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);

        JLabel state=new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

        stateTextField=new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,20));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);

        JLabel pinCode=new JLabel("Pin Code:");
        pinCode.setFont(new Font("Raleway", Font.BOLD,20));
        pinCode.setBounds(100,590,200,30);
        add(pinCode);

        pinCodeTextField=new JTextField();
        pinCodeTextField.setFont(new Font("Raleway",Font.BOLD,20));
        pinCodeTextField.setBounds(300,590,400,30);
        add(pinCodeTextField);

        next = new JButton("Login");
        next.setBounds(600,640,100,30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);


        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String formNumber=""+random;
        String name= nameTextField.getText();
        String fatherName= fatherNameTextField.getText();
        String dob=((JTextField)date.getDateEditor().getUiComponent()).getText();
        String city=cityTextField.getText();
        String state=stateTextField.getText();
        String pinCode= pinCodeTextField.getText();
        String email=emailTextField.getText();
        String address=addressTextField.getText();
        String gender=null;
        if (male.isSelected())
            gender="Male";
        else if (female.isSelected())
            gender="Female";
        String maritialStatus=null;
        if (married.isSelected())
            maritialStatus="Married";
        else if (unMarried.isSelected())
            maritialStatus="UnMarried";
        try {
            if (name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is required" );
            }
            else {
                ConnectionTosql conn =new ConnectionTosql();
                String query = "insert into signUp values('"+formNumber+"','"+name+"','"+fatherName+"','"+dob+"','"+city+"','"+state+"','"+pinCode+"','"+email+"','"+address+"','"+gender+"','"+maritialStatus+"')";
                conn.s.executeUpdate(query);

                setVisible(false);
                new SignUpPageTwo(formNumber);
            }
        }catch (Exception e) {
            System.out.println(e);
        }

    }
    public static void main(String[] args){
        new SignUpPage();
    }
}

