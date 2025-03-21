import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Button {
    public static void main(String[] args){
        JFrame frame = new JFrame("Button Example");
        frame.setSize(400,450);
        JLabel label = new JLabel("Name");
        label.setBounds(20, 20, 80, 25);

        JTextField f1 = new JTextField();
        f1.setBounds(100, 20, 150, 25);
        JLabel label1 = new JLabel("Email");
        label1.setBounds(20, 60, 80, 25);

        JTextField f2 = new JTextField();
        f2.setBounds(100, 60, 150, 25);

        JLabel label2 = new JLabel("Password");
        label2.setBounds(20, 100, 80, 25);

        JPasswordField f3 =  new JPasswordField();
        f3.setBounds(100, 100, 150, 25);
        
        
        JLabel a1 = new JLabel("Gender");
        a1.setBounds(20, 130, 150, 20);
       
        JRadioButton r1 = new JRadioButton("Male");
        r1.setBounds(20, 150, 100, 20);

        JRadioButton r2 = new JRadioButton("Female");
        r2.setBounds(120, 150, 100, 20);
        
        
        JLabel a = new JLabel("Hobbies");
        a.setBounds(20, 179, 150, 25);

        JCheckBox c1= new JCheckBox("Reading");
        c1.setBounds(20,205,80,25);
        JCheckBox c2= new JCheckBox("Watching movies");
        c2.setBounds(20,228,200,25);

        JCheckBox c3= new JCheckBox("Drawing ");
        c3.setBounds(20,250,80,25);

        JCheckBox c4= new JCheckBox("Cooking");
        c4.setBounds(20,270,80,25);


        JButton button1 = new JButton("Submit");
        button1.setBounds(50, 350, 100, 30);
        JButton button2 = new JButton("Clear");
        button2.setBounds(160, 350, 100, 30);

        
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String name = f1.getText();
                String email =f2.getText();
                String password = new String(f3.getPassword());
                String option = c1.getActionCommand();
                String option1 = c2.getActionCommand();
                String option2 = c3.getActionCommand();
                String option3 = c4.getActionCommand();
                String radio =r1.getActionCommand();
                String radio1 =r2.getActionCommand();


                if (name.isEmpty()||email.isEmpty()||password.isEmpty()||option.isEmpty()||option1.isEmpty()||option2.isEmpty()||option3.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);

                }else{
                    JOptionPane.showMessageDialog(frame, "Registration Succesfull");

                }
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                f1.setText("");
                f2.setText("");
                f3.setText("");
                c1.setSelected(false);
                c2.setSelected(false);
                c3.setSelected(false);
                c4.setSelected(false);
                r1.setSelected(false);
                r2.setSelected(false);

                JOptionPane.showMessageDialog(frame, "Clear Everything");

            }
            
        });

        frame.add(label);
        frame.add(f1);

        frame.add(label1);
        frame.add(f2);

        frame.add(label2);
        frame.add(f3);

        frame.add(a1);
        
        frame.add(r1);
        frame.add(r2);

        frame.add(a);

        frame.add(c1);
        frame.add(c2);
        frame.add(c3);
        frame.add(c4);

        frame.add(button1);
        frame.add(button2);
       frame.setLayout(null);
        frame.setVisible(true);

    }
}
