import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {
    JButton exit,deposit,withdrawal,fastCash,miniStatement,pinChange,balanceEnquiry;
    String pinNumber;
    public Transactions(String pinNumber){
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

        JLabel text =new JLabel("Please select your transaction");
        text.setBounds(210,270,700,30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);

        deposit=new JButton("Deposit");
        deposit.setBounds(165,395,150,26);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawal=new JButton("Cash Withdrawl");
        withdrawal.setBounds(355,395,150,26);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastCash=new JButton("Fast Cash");
        fastCash.setBounds(165,428,150,26);
        fastCash.addActionListener(this);
        image.add(fastCash);

        miniStatement=new JButton("Mini Statement");
        miniStatement.setBounds(355,428,150,26);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinChange=new JButton("Pin Change");
        pinChange.setBounds(165,461,150,26);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balanceEnquiry=new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(355,461,150,26);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        exit=new JButton("Exit");
        exit.setBounds(355,494,150,26);
        exit.addActionListener(this);
        image.add(exit);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==exit){
            System.exit(0);
        } else if (ae.getSource()==deposit) {
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        } else if (ae.getSource()==withdrawal) {
            setVisible(false);
            new Withdrawal(pinNumber).setVisible(true);
        } else if (ae.getSource()==fastCash) {
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        } else if (ae.getSource()==pinChange) {
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        } else if (ae.getSource()==balanceEnquiry) {
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        } else if (ae.getSource()==miniStatement) {
            new MiniStatement(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Transactions("");
    }
}
