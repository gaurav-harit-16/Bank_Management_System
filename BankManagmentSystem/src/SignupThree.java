import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {
    JRadioButton savingAccount, fixedDepositAccount, currentAccount, recurringDepositeAccount;
    JCheckBox atm, internetBanking, mobileBanking, email_smsAlert, chequeBook, e_statement,decleration;
    JButton submit,cancel;
    String formno;
    public SignupThree(String formno){
        this.formno = formno;
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel l1 = new JLabel("Page 3 - Account details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280,40,400,40);
        add(l1);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100,120,200,40);
        add(type);

        savingAccount = new JRadioButton("Saving Account");
        savingAccount.setFont(new Font("Raleway", Font.BOLD,16));
        savingAccount.setBounds(100,180,250,20);
        savingAccount.setBackground(Color.WHITE);
        add(savingAccount);

        fixedDepositAccount = new JRadioButton("Fixed Deposit Account");
        fixedDepositAccount.setFont(new Font("Raleway", Font.BOLD,16));
        fixedDepositAccount.setBounds(350,180,250,20);
        fixedDepositAccount.setBackground(Color.WHITE);
        add(fixedDepositAccount);

        currentAccount = new JRadioButton("Current Account");
        currentAccount.setFont(new Font("Raleway", Font.BOLD,16));
        currentAccount.setBounds(100,220,250,20);
        currentAccount.setBackground(Color.WHITE);
        add(currentAccount);

        recurringDepositeAccount = new JRadioButton("Recurring Deposite Account");
        recurringDepositeAccount.setFont(new Font("Raleway", Font.BOLD,16));
        recurringDepositeAccount.setBounds(350,220,250,20);
        recurringDepositeAccount.setBackground(Color.WHITE);
        add(recurringDepositeAccount);

        ButtonGroup groupAccount=new ButtonGroup();
        groupAccount.add(savingAccount);
        groupAccount.add(currentAccount);
        groupAccount.add(fixedDepositAccount);
        groupAccount.add(recurringDepositeAccount);

        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100,300,200,30);
        add(card);

        JLabel carddetail = new JLabel("This is your 16 digit Card Number");
        carddetail.setFont(new Font("Raleway", Font.BOLD, 12));
        carddetail.setBounds(100,330,200,20);
        add(carddetail);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330,300,300,30);
        add(number);


        JLabel pin = new JLabel("Pin");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100,370,200,30);
        add(pin);

        JLabel pindetail = new JLabel("Your 4 digit Password");
        pindetail.setFont(new Font("Raleway", Font.BOLD, 12));
        pindetail.setBounds(100,400,200,20);
        add(pindetail);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pnumber.setBounds(330,370,200,30);
        add(pnumber);

        JLabel service = new JLabel("Services Required");
        service.setFont(new Font("Raleway", Font.BOLD, 22));
        service.setBounds(100,450,200,30);
        add(service);

        atm = new JCheckBox("ATM Card");
        atm.setFont(new Font("Raleway", Font.BOLD,16));
        atm.setBackground(Color.WHITE);
        atm.setBounds(100,500,200,30);
        add(atm);

        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setFont(new Font("Raleway", Font.BOLD,16));
        internetBanking.setBackground(Color.WHITE);
        internetBanking.setBounds(350,500,200,30);
        add(internetBanking);

        mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setFont(new Font("Raleway", Font.BOLD,16));
        mobileBanking.setBackground(Color.WHITE);
        mobileBanking.setBounds(100,550,200,30);
        add(mobileBanking);

        email_smsAlert = new JCheckBox("Email & SMS Alert");
        email_smsAlert.setFont(new Font("Raleway", Font.BOLD,16));
        email_smsAlert.setBackground(Color.WHITE);
        email_smsAlert.setBounds(350,550,200,30);
        add(email_smsAlert);

        chequeBook = new JCheckBox("Cheque Book");
        chequeBook.setFont(new Font("Raleway", Font.BOLD,16));
        chequeBook.setBackground(Color.WHITE);
        chequeBook.setBounds(100,600,200,30);
        add(chequeBook);

        e_statement = new JCheckBox("E - Statement");
        e_statement.setFont(new Font("Raleway", Font.BOLD,16));
        e_statement.setBackground(Color.WHITE);
        e_statement.setBounds(350,600,200,30);
        add(e_statement);

        decleration = new JCheckBox("I hereby declare that the above entered information are correct to the best of my knowledge");
        decleration.setFont(new Font("Raleway", Font.BOLD,12));
        decleration.setBackground(Color.WHITE);
        decleration.setBounds(100,650,400,20);
        add(decleration);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD,16));
        submit.setBounds(420,720,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD,16));
        cancel.setBounds(250,720,100,30);
        cancel.addActionListener(this);
        add(cancel);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==submit){
            String accountType=null;
            if(savingAccount.isSelected())
                accountType="Saving Account";
            else if(currentAccount.isSelected())
                accountType="Current Account";
            else if(fixedDepositAccount.isSelected())
                accountType="Fixed Deposit Account";
            else if(recurringDepositeAccount.isSelected())
                accountType="Recurring Deposite Account";

            Random random = new Random();
            String cardNumber=""+Math.abs((random.nextLong()%90000000L)+1272160000000000L);
            String pinNumber=""+Math.abs((random.nextLong()%9000L)+1000L);
            String facility="";
            if (atm.isSelected())
                facility=facility+" ATM Card";
            else if (chequeBook.isSelected())
                facility=facility+" Cheque Book";
            else if (e_statement.isSelected())
                facility=facility+" E Statement";
            else if (internetBanking.isSelected())
                facility=facility+" Internet Banking";
            else if (mobileBanking.isSelected())
                facility=facility+" Mobile Banking";
            else if (email_smsAlert.isSelected())
                facility=facility+" Email & SMS Alert";
            /*
            JOptionPane.ERROR_MESSAGE: Displays an error icon. Indicates a critical error or issue.
            JOptionPane.INFORMATION_MESSAGE: Displays an information icon. Provides general information to the user.
            JOptionPane.WARNING_MESSAGE: Displays a warning icon. Indicates a warning or non-critical issue.
            JOptionPane.QUESTION_MESSAGE: Displays a question icon. Asks the user a question, often with options for "Yes," "No," or "Cancel."
            JOptionPane.PLAIN_MESSAGE: Displays no icon. Used for messages that don't require a specific icon.
             */
            if (!decleration.isSelected()) {
                JOptionPane.showMessageDialog(this, "Please check the declaration.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            try {
                if (accountType==null){
                    JOptionPane.showMessageDialog(this,"Account Type is required","Error", JOptionPane.ERROR_MESSAGE);
                }else if (!decleration.isSelected()) {
                    JOptionPane.showMessageDialog(this, "Please check the declaration.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    ConnectionTosql con = new ConnectionTosql();
                    String query1 = "insert into signupthree values('" + formno + "','" + accountType + "','" + cardNumber + "','" + pinNumber + "','" + facility + "')";
                    String query2 = "insert into login values('" + formno + "','" + cardNumber + "','" + pinNumber + "')";

                    con.s.executeUpdate(query1);
                    con.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Your Card Number - " + cardNumber + "\nPin - " + pinNumber, "Information", JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                    new Deposit(pinNumber).setVisible(true);
                }
            }catch (Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource()==cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new SignupThree("");
    }
}
