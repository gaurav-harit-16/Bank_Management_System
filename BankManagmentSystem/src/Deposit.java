import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.Objects;

public class Deposit extends JFrame implements ActionListener {
    String pinNumber;
    JTextField amount;
    JButton deposit,back;
    public Deposit(String pinNumber){
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

        JLabel text =new JLabel("Enter the amount you want to deposit");
        text.setBounds(170,270,700,30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);

        amount=new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD,22));
        amount.setBounds(170,320,300,30);
        image.add(amount);

        deposit=new JButton("Deposit");
        deposit.setBounds(355,461,150,26);
        deposit.addActionListener(this);
        image.add(deposit);

        back=new JButton("Back");
        back.setBounds(355,494,150,26);
        back.addActionListener(this);
        image.add(back);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==deposit){
            String number=amount.getText();
            Date date=new Date();
            if (Objects.equals(number, "")){
                JOptionPane.showMessageDialog(this,"Please enter amount to deposit", "error",JOptionPane.INFORMATION_MESSAGE);
            }else {

                try {
                    String query = "insert into bank values('"+pinNumber+"','"+date+"','Deposit','"+number+"')";
                    ConnectionTosql con = new ConnectionTosql();
                    con.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(this,"RS "+number+" Deposited Successfully");
                    setVisible(false);
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
        new Deposit("");
    }
}
