import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DivisionApp {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Integer Division");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);


        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));


        JLabel labelNum1 = new JLabel("Num1: ");
        JTextField textNum1 = new JTextField();

        JLabel labelNum2 = new JLabel("Num2: ");
        JTextField textNum2 = new JTextField();

        JButton divideButton = new JButton("Divide");
        JLabel resultLabel = new JLabel("Result: ");
        JTextField resultField = new JTextField();
        resultField.setEditable(false);


        panel.add(labelNum1);
        panel.add(textNum1);
        panel.add(labelNum2);
        panel.add(textNum2);
        panel.add(divideButton);
        panel.add(resultLabel);
        panel.add(resultField);


        frame.add(panel);


        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    String num1Text = textNum1.getText();
                    String num2Text = textNum2.getText();


                    if (num1Text.isEmpty() || num2Text.isEmpty()) {
                        throw new NumberFormatException("Both numbers must be provided.");
                    }


                    int num1 = Integer.parseInt(num1Text);
                    int num2 = Integer.parseInt(num2Text);


                    if (num2 == 0) {
                        throw new ArithmeticException("Cannot divide by zero.");
                    }
                    int result = num1 / num2;


                    resultField.setText(String.valueOf(result));
                } catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(frame, "Invalid input! Please enter integers.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } catch (ArithmeticException ex) {

                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        frame.setVisible(true);
    }
}
