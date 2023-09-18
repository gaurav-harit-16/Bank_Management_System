import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Objects;

public class Withdrawal extends JFrame implements ActionListener {
    String pinNumber;
    JTextField amount;
    JButton withdrawal,back;
    public Withdrawal(String pinNumber){
        this.pinNumber = pinNumber;
        setSize(900,900);
        setLocation(300,0);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text =new JLabel("Enter the amount you want to withdraw");
        text.setBounds(170,270,700,30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);

        amount=new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD,22));
        amount.setBounds(170,320,300,30);
        image.add(amount);

        withdrawal=new JButton("Withdraw");
        withdrawal.setBounds(355,461,150,26);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        back=new JButton("Back");
        back.setBounds(355,494,150,26);
        back.addActionListener(this);
        image.add(back);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==withdrawal){
            String number=amount.getText();
            Date date=new Date();
            if (Objects.equals(number, "")){
                JOptionPane.showMessageDialog(this,"Please enter amount to withdrawal", "error",JOptionPane.INFORMATION_MESSAGE);
            }else {

                try {
                    ConnectionTosql con = new ConnectionTosql();
                    ResultSet set=con.s.executeQuery("select * from bank where pin='"+pinNumber+"'");
                    int balance =0;
                    while (set.next()) {
                        if (set.getString("type").equals("Deposit")){
                            balance+=Integer.parseInt(set.getString("amount"));
                        }else {
                            balance-=Integer.parseInt(set.getString("amount"));
                        }
                    }
                    if (ae.getSource()==withdrawal && balance<=Integer.parseInt(number)){
                        JOptionPane.showMessageDialog(this,"Insufficient funds");
                    }
                    String query = "insert into bank values('"+pinNumber+"','"+date+"','Withdrawal','"+number+"')";

                    con.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(this,"RS "+number+" withdraw Successfully");
                    setVisible(true);
                    new Transactions(pinNumber).setVisible(true);
                }catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else if (ae.getSource()==back) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Withdrawal("");
    }
}
