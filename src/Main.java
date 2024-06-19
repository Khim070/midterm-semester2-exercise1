import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        try{
            JFrame frame = new JFrame("Lock Class");
            JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnClear,btnEnter;
            JLabel password;
            JPasswordField txtpassword;
            JPanel gridPanel = new JPanel();
            JPanel controlPanel = new JPanel();
            gridPanel.setLayout(new GridLayout(3,3));

            btnClear = new JButton("Clear");
            btnEnter = new JButton("Enter");
            password = new JLabel("Enter Password");
            txtpassword = new JPasswordField(15);

            controlPanel.add(btnClear);
            controlPanel.add(txtpassword);
            controlPanel.add(btnEnter);
            controlPanel.add(password);

            for (int i = 1; i <= 9; i++) {
                JButton button = new JButton(String.valueOf(i));
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        txtpassword.setText(txtpassword.getText() + button.getText());
                    }
                });
                gridPanel.add(button);
            }

            btnClear.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    txtpassword.setText("");
                }
            });

            btnEnter.addActionListener(new ActionListener() {
                String savedPassword = "";
                @Override
                public void actionPerformed(ActionEvent e) {
                    String enteredPassword = txtpassword.getText();

                    if (savedPassword.equals("")) {
                        savedPassword = enteredPassword;
                        password.setText("Password Set");
                    } else {
                        if (enteredPassword.equals(savedPassword)) {
                            password.setText("Correct Password");
                        } else {
                            password.setText("Incorrect Password");
                        }
                    }
                    txtpassword.setText("");
                }
            });

            frame.setLayout(new BorderLayout());
            frame.add(gridPanel,BorderLayout.NORTH);
            frame.add(controlPanel,BorderLayout.CENTER);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600,400);
            frame.setVisible(true);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}