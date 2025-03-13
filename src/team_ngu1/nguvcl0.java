package team_ngu1;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class nguvcl0 extends JFrame {
    private JTextField num1Field, num2Field, resultField;
    private JButton multiplyButton, divideButton;

    public nguvcl0() {
        setTitle("Calculator");
        setSize(300, 200);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel num1Label = new JLabel("Number 1:");
        num1Label.setBounds(20, 20, 80, 25);
        add(num1Label);
        
        num1Field = new JTextField();
        num1Field.setBounds(100, 20, 150, 25);
        add(num1Field);
        
        JLabel num2Label = new JLabel("Number 2:");
        num2Label.setBounds(20, 50, 80, 25);
        add(num2Label);
        
        num2Field = new JTextField();
        num2Field.setBounds(100, 50, 150, 25);
        add(num2Field);
        
        multiplyButton = new JButton("*");
        multiplyButton.setBounds(50, 90, 50, 30);
        add(multiplyButton);
        
        divideButton = new JButton("/");
        divideButton.setBounds(120, 90, 50, 30);
        add(divideButton);
        
        resultField = new JTextField();
        resultField.setBounds(100, 130, 150, 25);
        resultField.setEditable(false);
        add(resultField);
        
        multiplyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performCalculation('*');
            }
        });
        
        divideButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performCalculation('/');
            }
        });
    }
    
    private void performCalculation(char operation) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result;
            if (operation == '*') {
                result = num1 * num2;
            } else {
                if (num2 == 0) {
                    JOptionPane.showMessageDialog(this, "Cannot divide by zero", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                result = num1 / num2;
            }
            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new nguvcl0().setVisible(true));
    }
}