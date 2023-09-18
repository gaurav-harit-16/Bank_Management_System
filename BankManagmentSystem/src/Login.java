import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener{
    JButton login, clear, signUp;
    JTextField cardNumberTextField;
    JPasswordField pinTextField;
    Login(){
        setLayout(null);
        setSize(800,500);
        setTitle("BMS - Bank Management System");
        setVisible(true);
        setLocation(350,150);
        ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image image = icon.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);

        //converting image to imageicon because jlabel does not accept image
        ImageIcon icon1= new ImageIcon(image);

        JLabel label = new JLabel(icon1);
        label.setBounds(70,10,100,100);
        getContentPane().setBackground(Color.WHITE);
        add(label);

        JLabel text= new JLabel("Welcome to Bank");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel cardNo= new JLabel("Card No :");
        cardNo.setFont(new Font("Raleway",Font.BOLD,28));
        cardNo.setBounds(120,150,150,30);
        add(cardNo);

        cardNumberTextField= new JTextField();
        cardNumberTextField.setBounds(270,150,200,30);
        add(cardNumberTextField);

        JLabel pin= new JLabel("PIN :");
        pin.setFont(new Font("Ralewat",Font.BOLD,28));
        pin.setBounds(120,220,200,30);
        add(pin);

        pinTextField= new JPasswordField();
        pinTextField.setBounds(270,220,200,30);
        add(pinTextField);

        login = new JButton("Login");
        login.setBounds(270,300,90,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("Clear");
        clear.setBounds(380,300,90,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signUp = new JButton("Sign Up");
        signUp.setBounds(270,350,200,30);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        add(signUp);


    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == login){
            ConnectionTosql connect = new ConnectionTosql();
            String cardNumber=cardNumberTextField.getText();
            String pinNumber=pinTextField.getText();
            String query = "select * from login where cardNumber='"+cardNumber+"' and pin='"+pinNumber+"'";
            try {
                ResultSet rs = connect.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(this,"Card or Pin incorrect","Warning",JOptionPane.WARNING_MESSAGE);
                }
            }catch (Exception e){
                System.out.println(e);
            }
        } else if (ae.getSource() == clear) {
            cardNumberTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource() == signUp) {
            setVisible(false);
            new SignUpPage();
        }

    }
    public static void main(String[] args){
        new Login();
    }
}
