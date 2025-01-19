import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIApplication {
        public static void main(String[] args) {

            JFrame frame = new JFrame();
            frame.setVisible(true);
            frame.setSize(800, 600);
            frame.setLayout(new GridLayout(4, 2));
            JPanel buttonPanel = new JPanel(new FlowLayout());
            JPanel textPanel = new JPanel(new FlowLayout());

            JButton eurToUSD = new JButton("EUR To USD");
            JLabel label1 = new JLabel("EUR To USD");
            JTextField eurText = new JTextField(10);
            JButton usdToEUR = new JButton("USD To EUR");
            JLabel label2 = new JLabel("USD To EUR");
            JTextField usdText = new JTextField(5);
            JTextArea output = new JTextArea();
            output.setEditable(false);

            //Using user input and classes for conversion from EUR to USD
            eurToUSD.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    String eurInput = eurText.getText();
               if(eurInput.matches("\\d*\\.?\\d+")){
                   double eur = Double.parseDouble(eurInput);
                   EurUsd eurUsd = new EurUsd(eur);
                   double convertedEUR = eurUsd.ConvertEUR();
                   output.setText("Converted EUR to " + convertedEUR + "USD");
               }
               else { System.out.println("Input a number.");}
                }
            });

            //Using user input and classes for conversion from USD to EUR
            usdToEUR.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String usdInput = usdText.getText();
                    if(usdInput.matches("\\d*\\.?\\d+")){
                        double usd = Double.parseDouble(usdInput);
                        UsdEur usdEur = new UsdEur(usd);
                        double convertedUSD = usdEur.ConvertUSD();
                        output.setText("Converted USD to " + convertedUSD + "EUR");
                    }
                    else { System.out.println("Input a number.");}
                }
            });

            frame.setVisible(true);
            buttonPanel.add(eurToUSD);
            buttonPanel.add(usdToEUR);
            textPanel.add(label1);
            textPanel.add(eurText);
            textPanel.add(label2);
            textPanel.add(usdText);
            textPanel.add(output);
            frame.add(buttonPanel);
            frame.add(textPanel);
        }
}

//conversion rates from 14th January for EUR to USD
class EurUsd {
    double eur;

    public EurUsd(double eur) {
        this.eur = eur;
    }
    public double ConvertEUR() {
        return eur * 1.03;
    }
}

//conversion rates from 14th January for USD to EUR
class UsdEur {
    double usd;

    public UsdEur(double usd) {
        this.usd = usd;
    }
    public double ConvertUSD() {
        return usd * 0.98;
    }
}
