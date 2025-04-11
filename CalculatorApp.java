import java.awt.ActiveEvent;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorApp implements ActionListener {
private JTextField text;
private JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9;
private JButton add,sub,mul,div,equal,dot,clear;
double n1=0, n2=0,result=0;
String operator=" ";
public CalculatorApp(){
    JFrame f = new JFrame("Calculator");
    f.setTitle("Calculator");
    f.setSize(200, 300);
    f.setLayout(new BorderLayout());
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );


    text = new JTextField();
    text.setFont(new Font("Arial", Font.BOLD,24));
    text.setHorizontalAlignment(JTextField.RIGHT);
    f.add(text,BorderLayout.NORTH);

    b0 = new JButton("0");
    b1 = new JButton("1");      
    b2 = new JButton("2");
    b3 = new JButton("3");
    b4 = new JButton("4");
    b5 = new JButton("5");
    b6 = new JButton("6");
    b7 = new JButton("7");
    b8 = new JButton("8");
    b9 = new JButton("9");
    add = new JButton("+");
    sub = new JButton("-");
    mul = new JButton("*");
    div = new JButton("/");
    equal = new JButton("=");
    dot = new JButton(".");
    clear = new JButton("clear");

    JPanel p = new JPanel();
    p.add(b7);  p.add(b8); p.add(b9); p.add(div);
    p.add(b4);  p.add(b5); p.add(b6); p.add(mul);
    p.add(b1);  p.add(b2); p.add(b3); p.add(sub);
    p.add(dot); p.add(b0); p.add(equal); p.add(add);
    p.add(clear);
    f.add(p,BorderLayout.CENTER);
    b0.addActionListener(this);
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    b4.addActionListener(this);
    b5.addActionListener(this);
    b6.addActionListener(this);
    b7.addActionListener(this);
    b8.addActionListener(this);
    b9.addActionListener(this);
    add.addActionListener(this);
    mul.addActionListener(this);
    div.addActionListener(this);
    sub.addActionListener(this);
    equal.addActionListener(this);
    dot.addActionListener(this);
    clear.addActionListener(this);
    

    f.add(p,BorderLayout.CENTER);

    
    f.setVisible(true);
    }
    
    public static void main(String[] args) {
        new CalculatorApp();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Object src = e.getSource();
        if (src==b0) text.setText(text.getText()+"0");
        if (src==b1) text.setText(text.getText()+"1");
        if (src==b2) text.setText(text.getText()+"2");
        if (src==b3) text.setText(text.getText()+"3");
        if (src==b4) text.setText(text.getText()+"4");
        if (src==b5) text.setText(text.getText()+"5");
        if (src==b6) text.setText(text.getText()+"6");
        if (src==b7) text.setText(text.getText()+"7");
        if (src==b8) text.setText(text.getText()+"8");
        if (src==b9) text.setText(text.getText()+"9");

        if (src==dot) {
            if (!text.getText().contains(".")) {
                text.setText(text.getText()+".");
            }
        }
        if (src==add || src==sub || src==mul || src == div) {
            if (!text.getText().isEmpty()) {

            try {
                n1 = Double.parseDouble(text.getText());
                operator = ((JButton)src).getText();
                text.setText(" ");
            } catch (NumberFormatException ex) {
                // TODO: handle exception
                text.setText("Error");
            }
        }
        }
        if (src==equal) 
        {
            if (!text.getText().isEmpty() ) {

            try {
                n2=Double.parseDouble(text.getText());
                switch (operator) {
                    case "+":
                        result =n1+n2;
                        break;
                    case "-":
                        result =n1-n2;
                        break;
                    case "*":
                        result =n1*n2;
                        break;
                    case "/":
                    if (n2==0) {
                       text.setText("cannot divde by 0 ");                            
                       return;
                    }
                        result =n1/n2;
                        break;
                    default: result=0;
                        
                }
                text.setText(String.valueOf(result));
                operator="";
            } catch (Exception ex) {
                // TODO: handle exception
                text.setText("Error");
            }
        }
        }
        if (src==clear) {
            text.setText("");
            n1=n2=result=0;
            operator="";
        }
    }
}
