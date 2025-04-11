import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NumberGame {
    private int randomNumber;
    private JTextField guessField;
    private JButton guessButton,playAgainButton;
    private JLabel msg;
    public NumberGame(){
        JFrame f = new JFrame();
        f.setTitle("Number Guessing Number");
        f.setSize(300,180);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        f.setLayout(null);

        JLabel instructionLabel = new JLabel("Guess a Number (1-100)");
        instructionLabel.setBounds(20,10,200,25);
        f.add(instructionLabel);

        guessField = new JTextField();
        guessField.setBounds(20,35,100,25);
        f.add(guessField);

        guessButton =new JButton("Guess");
        guessButton.setBounds(130, 35, 100, 25);
        f.add(guessButton);

       

        msg = new JLabel(" ");
        msg.setBounds(20,70,250,25);
        f.add(msg);
        
        playAgainButton = new JButton("Play Again");
        playAgainButton.setBounds(90, 100, 120, 30);
        playAgainButton.setVisible(false);
        f.add(playAgainButton);

        generateRandomNumber();
        
        guessButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                checkGuess();
            }

           
           
        });
        
        playAgainButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                resetGame();
            }});
        
            
        f.setVisible(true);

    }
    private void generateRandomNumber() {
        // TODO Auto-generated method stub
        Random r = new Random();
        randomNumber = r.nextInt(100)+1;
    }
    private void checkGuess() {
        // TODO Auto-generated method stub
        if (guessField.getText().trim().isEmpty()) {
            msg.setText("Enter a Number ");
            return;
        }
        try {
            int uguess = Integer.parseInt(guessField.getText());
            if (uguess < randomNumber) {
                msg.setText("Too Low ! Try Again ");
            }else if (uguess > randomNumber) {
                msg.setText("Too High ! Try Again");
            }else{
                msg.setText("Correct");
                guessButton.setEnabled(false);
                playAgainButton.setEnabled(true);
                playAgainButton.setVisible(true);
            }
        } catch (NumberFormatException ex) {
            // TODO: handle exception
            msg.setText("Please Enter Valid Number");
        }
    }
    private void resetGame() {
        // TODO Auto-generated method stub
        generateRandomNumber();
        guessField.setText(" ");
        msg.setText("");
        guessButton.setEnabled(true);
        playAgainButton.setEnabled(false);
    }
    

    public static void main(String[] args) {
        new NumberGame();
    }
} 
