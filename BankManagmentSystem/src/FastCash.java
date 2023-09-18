import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton back, hundred, fiveHundred, thousand, twoThousand, fiveThousand, tenThousand;
    String pinNumber;
    public FastCash(String pinNumber){
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

        JLabel text =new JLabel("Select the amount to withdraw");
        text.setBounds(210,270,700,30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);

        hundred =new JButton("Rs. 100");
        hundred.setBounds(165,395,150,26);
        hundred.addActionListener(this);
        image.add(hundred);

        fiveHundred =new JButton("Rs. 500");
        fiveHundred.setBounds(355,395,150,26);
        fiveHundred.addActionListener(this);
        image.add(fiveHundred);

        thousand =new JButton("Rs. 1000");
        thousand.setBounds(165,428,150,26);
        thousand.addActionListener(this);
        image.add(thousand);

        twoThousand =new JButton("Rs. 2000");
        twoThousand.setBounds(355,428,150,26);
        twoThousand.addActionListener(this);
        image.add(twoThousand);

        fiveThousand =new JButton("Rs. 5000");
        fiveThousand.setBounds(165,461,150,26);
        fiveThousand.addActionListener(this);
        image.add(fiveThousand);

        tenThousand =new JButton("Rs. 10000");
        tenThousand.setBounds(355,461,150,26);
        tenThousand.addActionListener(this);
        image.add(tenThousand);

        back =new JButton("Exit");
        back.setBounds(355,494,150,26);
        back.addActionListener(this);
        image.add(back);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(4);
            try {
                ConnectionTosql con=new ConnectionTosql();
                ResultSet set=con.s.executeQuery("select * from bank where pin='"+pinNumber+"'");
                int balance =0;
                while (set.next()) {
                    if (set.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(set.getString("amount"));
                    }else {
                        balance-=Integer.parseInt(set.getString("amount"));
                    }
                }
                if (ae.getSource()==back && balance<=Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(this,"Insufficient funds");
                }
                Date date= new Date();
                String query = "insert into bank values('"+pinNumber+"','"+date+"','Withdrawal','"+amount+"')";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(this,"Rs "+amount+" withdrawl successful");
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        new FastCash("");
    }
}
