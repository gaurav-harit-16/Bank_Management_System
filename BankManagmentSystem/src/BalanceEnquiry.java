import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton back;
    String pinNumber;
    public BalanceEnquiry(String pinNumber) {
        this.pinNumber = pinNumber;
        setSize(900, 900);
        setLocation(300, 0);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        back = new JButton("Back");
        back.setBounds(355, 494, 150, 26);
        back.addActionListener(this);
        image.add(back);

        int balance = 0;
        try {
            ConnectionTosql con = new ConnectionTosql();
            ResultSet set = con.s.executeQuery("select * from bank where pin='" + pinNumber + "'");
            while (set.next()) {
                if (set.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(set.getString("amount"));
                } else {
                    balance -= Integer.parseInt(set.getString("amount"));
                }
            }
        }catch (Exception e) {
            System.out.println(e);
        }
        JLabel text = new JLabel("Your account balance is Rs: "+balance);
        text.setBounds(170, 270, 700, 30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
    }
}
