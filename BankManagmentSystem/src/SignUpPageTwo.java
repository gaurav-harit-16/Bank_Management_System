import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class SignUpPageTwo extends JFrame implements ActionListener {
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox occupationalValues,incomeValues,educationValues,categoryValues,religionValues;
    JTextField panTextField, aadharTextField;
    String formNumber;
    SignUpPageTwo (String formNumber){
        this.formNumber = formNumber;
        setLayout(null);
        setSize(850,800);
        setLocation(350,10);
        getContentPane().setBackground(Color.WHITE);

        setTitle("New Account Form : Page 2");

        JLabel additionalDetails=new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);

        JLabel religion=new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD,20));
        religion.setBounds(100,140,100,30);
        add(religion);

        String[] values = {"Hindu","Muslim","Sikh","Christian","Other"};
        religionValues=new JComboBox(values);
        religionValues.setBounds(300,140,400,30);
        religionValues.setBackground(Color.WHITE);
        add(religionValues);

        JLabel category=new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD,20));
        category.setBounds(100,190,200,30);
        add(category);

        String[] catValues = {"General","OBC","SC","ST","Other"};
        categoryValues= new JComboBox(catValues);
        categoryValues.setBounds(300,190,400,30);
        categoryValues.setBackground(Color.WHITE);
        add(categoryValues);

        JLabel income=new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD,20));
        income.setBounds(100,240,200,30);
        add(income);

        String[] incomeVal={"NA","<1,50,000",">1,50,000 & <3,50,000",">3,50,000 & <6,00,000",">6,00,000"};
        incomeValues=new JComboBox(incomeVal);
        incomeValues.setBounds(300,240,400,30);
        incomeValues.setBackground(Color.WHITE);
        add(incomeValues);

        JLabel educational=new JLabel("Educational");
        educational.setFont(new Font("Raleway", Font.BOLD,20));
        educational.setBounds(100,290,200,30);
        add(educational);

        JLabel qualification=new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD,20));
        qualification.setBounds(100,315,200,30);
        add(qualification);

        String[] eduValues={"NON-Gratuate","Under-Gratuate","Post-Gratuate","Doctrate","Other"};
        educationValues = new JComboBox(eduValues);
        educationValues.setBounds(300,300,400,30);
        educationValues.setBackground(Color.WHITE);
        add(educationValues);

        JLabel maritialStatus=new JLabel("Occupation:");
        maritialStatus.setFont(new Font("Raleway", Font.BOLD,20));
        maritialStatus.setBounds(100,360,200,30);
        add(maritialStatus);

        String[] occuValues={"Salaried","Self-Employed","Businessman","Retired","Other"};
        occupationalValues = new JComboBox(occuValues);
        occupationalValues.setBounds(300,360,400,30);
        occupationalValues.setBackground(Color.WHITE);
        add(occupationalValues);

        JLabel pan=new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway", Font.BOLD,20));
        pan.setBounds(100,410,200,30);
        add(pan);

        panTextField=new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,20));
        panTextField.setBounds(300,410,400,30);
        add(panTextField);

        JLabel aadhar=new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD,20));
        aadhar.setBounds(100,460,200,30);
        add(aadhar);

        aadharTextField=new JTextField();
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,20));
        aadharTextField.setBounds(300,460,400,30);
        add(aadharTextField);

        JLabel senior=new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway", Font.BOLD,20));
        senior.setBounds(100,510,200,30);
        add(senior);

        syes =new JRadioButton("Yes");
        syes.setBounds(300,510,70,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno =new JRadioButton("No");
        sno.setBounds(450,510,70,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup seniorYesNo=new ButtonGroup();
        seniorYesNo.add(syes);
        seniorYesNo.add(sno);

        JLabel existingMember=new JLabel("Existing Account:");
        existingMember.setFont(new Font("Raleway", Font.BOLD,20));
        existingMember.setBounds(100,560,200,30);
        add(existingMember);

        eyes =new JRadioButton("Yes");
        eyes.setBounds(300,560,70,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno =new JRadioButton("No");
        eno.setBounds(450,560,70,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup exixtingYesNo=new ButtonGroup();
        exixtingYesNo.add(eyes);
        exixtingYesNo.add(eno);

        next = new JButton("Login");
        next.setBounds(600,610,100,30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);


        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String religion =(String) religionValues.getSelectedItem();
        String category=(String) categoryValues.getSelectedItem();
        String income=(String) incomeValues.getSelectedItem();
        String education=(String) educationValues.getSelectedItem();
        String occupation=(String) occupationalValues.getSelectedItem();
        String pan=panTextField.getText();
        String aadhar=aadharTextField.getText();
        String seniorCitizen=null;
        if (syes.isSelected())
            seniorCitizen="Yes";
        else if (sno.isSelected())
            seniorCitizen="No";
        String existingCoustomer=null;
        if (eyes.isSelected())
            existingCoustomer="Yes";
        else if (eno.isSelected())
            existingCoustomer="No";
        try {
                ConnectionTosql conn =new ConnectionTosql();
                String query = "insert into signUptwo values('"+formNumber+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+seniorCitizen+"','"+existingCoustomer+"','"+pan+"','"+aadhar+"')";
                conn.s.executeUpdate(query);
                setVisible(false);
                new SignupThree(formNumber).setVisible(true);

        }catch (Exception e) {
            System.out.println(e);
        }

    }
    public static void main(String[] args){
        new SignUpPageTwo("");
    }
}

