import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.BorderLayout.*;

public class Main {
        public static void main(String[] args) {

            JFrame frame = new JFrame();
            frame.setLayout(new BorderLayout());

            JPanel buttonPanel = new JPanel(new FlowLayout());
            JPanel inputPanel = new JPanel(new GridLayout(2, 3));
            JPanel outputPanel = new JPanel(new BorderLayout());

            JButton eurToUSD = new JButton("EUR To USD");
            JLabel label1 = new JLabel("EUR:");
            JTextField eurText = new JTextField(3);
            JButton usdToEUR = new JButton("USD To EUR");
            JLabel label2 = new JLabel("USD:");
            JTextField usdText = new JTextField(3);

            JTextArea output = new JTextArea(2,3);
            output.setEditable(false);
            //using user input and classes for conversion from EUR to USD
            eurToUSD.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    String eurInput = eurText.getText();
                    //checking for validity of input
               if(eurInput.matches("\\d*\\.?\\d+")){
                   //conversion using ConvertEUR() method
                   double eur = Double.parseDouble(eurInput);
                   EurUsd eurUsd = new EurUsd(eur);
                   double convertedEUR = eurUsd.ConvertEUR();
                   output.setText("Converted EUR to " + convertedEUR + "USD");
               }
               else { output.setText("Input a valid number.");}
                }
            });

            //using user input and classes for conversion from USD to EUR
            usdToEUR.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String usdInput = usdText.getText();
                    //checking for validity of input
                    if(usdInput.matches("\\d*\\.?\\d+")){
                        //conversion using ConvertUSD() method
                        double usd = Double.parseDouble(usdInput);
                        UsdEur usdEur = new UsdEur(usd);
                        double convertedUSD = usdEur.ConvertUSD();
                        output.setText("Converted USD to " + convertedUSD + "EUR");
                    }
                    else { output.setText("Input a valid number.");}
                }
            });
            buttonPanel.add(eurToUSD);
            buttonPanel.add(usdToEUR);
            inputPanel.add(label1);
            inputPanel.add(eurText);
            inputPanel.add(label2);
            inputPanel.add(usdText);
            outputPanel.add(output, BorderLayout.CENTER);
            frame.add(buttonPanel, NORTH);
            frame.add(inputPanel, CENTER);
            frame.add(outputPanel, SOUTH);

            frame.pack();
            frame.setVisible(true);
        }
}

//class operates with inputted value of EUR and uses a fixed exchange rate to turn into USD
class EurUsd {
    double eur;

    public EurUsd(double eur) {
        this.eur = eur;
    }
    public double ConvertEUR() {
        return eur * 1.03;
    }
}

//class operates with inputted value of USD and uses a fixed exchange rate to turn into EUR
class UsdEur {
    double usd;

    public UsdEur(double usd) {
        this.usd = usd;
    }
    public double ConvertUSD() {
        return usd * 0.98;
    }
}
