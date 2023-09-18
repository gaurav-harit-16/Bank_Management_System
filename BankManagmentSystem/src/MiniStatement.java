import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.awt.event.WindowEvent;

public class MiniStatement extends JFrame {
    String pinNumber;
    public MiniStatement(String pinNumber){
        this.pinNumber =pinNumber;
        setLayout(null);
        setVisible(true);
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setTitle("Mini Statement");


        JLabel bank=new JLabel("India Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance=new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        JLabel transaction=new JLabel("Your last 10 transactions");
        transaction.setBounds(80,140,180,20);
        transaction.setFont(new Font("Raleway",Font.BOLD,14));
        add(transaction);

        try {
            ConnectionTosql con = new ConnectionTosql();
            ResultSet set=con.s.executeQuery("select * from login where pin='" + pinNumber + "'");
            while (set.next()) {
               String cardNo = set.getString("cardNumber").substring(0,4)+"XXXXXXXX"+set.getString("cardNumber").substring(12);
               card.setText("Card Number: " + cardNo);
            }

        }catch (Exception e){
            System.out.println(e);
        }
        StringBuilder all=new StringBuilder();
        try {
            ConnectionTosql con = new ConnectionTosql();
            ResultSet sett=con.s.executeQuery("select * from bank where pin='" + pinNumber + "'");
            int bal=0;
            while (sett.next()) {
//                String mins=(mini.getText() + "<html>" + sett.getString("date") + "&nbsp;&nbsp;&nbsp;" + set.getString("type") + "&nbsp;&nbsp;&nbsp;" + set.getString("amount") + "<br><br></html>");
                String date = sett.getString("date");
                String typ=sett.getString("type");
                String amt=sett.getString("amount");
                all.append(date+" "+typ+" "+amt+"\n");
                if (sett.getString("type").equals("Deposit")){
                    bal+=Integer.parseInt(sett.getString("amount"));
                }else {
                    bal-=Integer.parseInt(sett.getString("amount"));
                }
            }

            balance.setText("Your current account balance is Rs "+bal);
        }catch (Exception e){
            System.out.println(e);
        }
        StringBuilder last10=new StringBuilder();
        String[] last=String.valueOf(all).split("\n");
        if (last.length>10) {
            for (int i = last.length -10; i < last.length; i++) {
                last10.append(last[i] + "\n");
            }
        }else{
            last10=all;
        }

        JTextArea textArea = new JTextArea(String.valueOf(last10));
        textArea.setFont(new Font("Raleway", Font.BOLD,14));
        textArea.setEditable(false); // To make the text uneditable
//        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setBounds(20,180,350,270);
        add(textArea);

    }


    public static void main(String[] args) {
        new MiniStatement("");
    }
}
