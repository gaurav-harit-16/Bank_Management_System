import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class PinChange extends JFrame implements ActionListener {
    String pinNumber;
    JPasswordField oldPinText,newPinText,rePinText;
    JButton change,back;
    public PinChange(String pinNumber) {
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

        JLabel text =new JLabel("Change Your PIN");
        text.setBounds(250,270,700,30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);

        JLabel currentPin =new JLabel("Current Pin");
        currentPin.setBounds(195,310,700,30);
        currentPin.setForeground(Color.WHITE);
        currentPin.setFont(new Font("System", Font.BOLD,16));
        image.add(currentPin);

        oldPinText =new JPasswordField();
        oldPinText.setBounds(355,310,150,26);
        oldPinText.setFont(new Font("System", Font.BOLD,14));
        oldPinText.addActionListener(this);
        image.add(oldPinText);

        JLabel newPin =new JLabel("New Pin");
        newPin.setBounds(195,350,700,30);
        newPin.setForeground(Color.WHITE);
        newPin.setFont(new Font("System", Font.BOLD,16));
        image.add(newPin);

        newPinText=new JPasswordField();
        newPinText.setBounds(355,350,150,26);
        newPin.setFont(new Font("System", Font.BOLD,14));
        newPinText.addActionListener(this);
        image.add(newPinText);

        JLabel rePin =new JLabel("Re-Enter Pin");
        rePin.setBounds(195,390,700,30);
        rePin.setForeground(Color.WHITE);
        rePin.setFont(new Font("System", Font.BOLD,16));
        image.add(rePin);

        rePinText=new JPasswordField();
        rePinText.setBounds(355,390,150,26);
        rePin.setFont(new Font("System", Font.BOLD,14));
        rePinText.addActionListener(this);
        image.add(rePinText);

        change=new JButton("Change");
        change.setBounds(355,461,150,26);
        change.addActionListener(this);
        image.add(change);

        back=new JButton("Back");
        back.setBounds(355,494,150,26);
        back.addActionListener(this);
        image.add(back);
    }
    public void actionPerformed(ActionEvent ae){
        String newPin=newPinText.getText();
        String rePin=rePinText.getText();
        String oldPin=oldPinText.getText();

        if (ae.getSource()==change){
            if (!oldPin.equals(pinNumber)){
                JOptionPane.showMessageDialog(this,"Old Pin is Incorrect");
                return;
            } else if (!newPin.equals(rePin)) {
                JOptionPane.showMessageDialog(this,"New Pin and RePin Not Matched");
                return;
            } else if (Objects.equals(newPin, "")){
                JOptionPane.showMessageDialog(this,"Please enter New Pin", "error",JOptionPane.INFORMATION_MESSAGE);
                return;
            }else if (Objects.equals(oldPin, "")){
                JOptionPane.showMessageDialog(this,"Please enter Current Pin", "error",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            try {

                ConnectionTosql con=new ConnectionTosql();
                String query1="update bank set pin='"+newPin+"' where pin='"+pinNumber+"'";
                String query2="update login set pin='"+newPin+"' where pin='"+pinNumber+"'";
                String query3="update signupthree set pin='"+newPin+"' where pin='"+pinNumber+"'";
                con.s.executeUpdate(query1);
                con.s.executeUpdate(query2);
                con.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(this,"Your PIN changed successfully", "PIN Changed",JOptionPane.INFORMATION_MESSAGE);
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);

            }catch (Exception e){
                System.out.println(e);
            }
        }else {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new PinChange("");
    }
}
