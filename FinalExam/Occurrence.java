package FinalExam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Occurrence extends JFrame implements ActionListener {

    public static final int WIDTH = 750;

    public static final int HEIGHT = 200;

    public static final int NUMBER_OF_CHAR = 30;

    private JTextField sentence;
    private JLabel result;

    public static void main(String[] args) {

        Occurrence gui = new Occurrence();

        gui.setVisible(true);

    }

    public Occurrence( ) {

        super("Text Field Demo");

        setSize(WIDTH, HEIGHT);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        JPanel inputPanel = new JPanel();

        inputPanel.setLayout(new BorderLayout());

        inputPanel.setBackground(Color.WHITE);

        sentence = new JTextField("Enter your text here", NUMBER_OF_CHAR);

        inputPanel.add(sentence, BorderLayout.CENTER);

        result = new JLabel(" ");

        inputPanel.add(result, BorderLayout.SOUTH);

        JLabel titleLabel = new JLabel("This program counts the number of occurrences of 'a' character in a sentence" +
                "Input sentence should not contain any digits");

        inputPanel.add(titleLabel, BorderLayout.NORTH);

        add(inputPanel);

        JPanel buttonPanel = new JPanel( );

        buttonPanel.setLayout (new FlowLayout());

        JButton actionButton = new JButton("Compute");

        actionButton.addActionListener(this);

        buttonPanel.add(actionButton);

        JButton clearButton = new JButton("Reset");

        clearButton.addActionListener(this);

        buttonPanel.add(clearButton);

        add(buttonPanel);

    }

    public void occurenceOf_a_character(String inputString) throws DigitNotALlowedException{
        for (char c : sentence.getText().toCharArray()){
            if (Character.isDigit(c)){
                throw new DigitNotALlowedException("Input cannot contain digits!");
            }
        }
        int count=0;
        for (char c: inputString.toCharArray()){
            if (c=='a' || c=='A'){
                count++;
            }
        }
        result.setText(String.valueOf(count));
    }

    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        if (action.equals("Compute")){
            String text = sentence.getText();
            try {
                occurenceOf_a_character(text);
            } catch (DigitNotALlowedException digitNotALlowedException) {
                digitNotALlowedException.printStackTrace();
            }
        }
        else {
            sentence.setText("Enter your text here");
            result.setText(" ");
        }
    }




}
