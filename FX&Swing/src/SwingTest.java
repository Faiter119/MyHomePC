import javafx.scene.text.Text;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

import static java.time.temporal.ChronoUnit.MILLIS;
import static java.time.temporal.ChronoUnit.SECONDS;

public class SwingTest {

    public static void main(String[]args){

        LocalTime start = LocalTime.now();

        JFrame frame  = new JFrame();
        JPanel panel = new JPanel(new BorderLayout());

        JPanel textPanel = new JPanel();
        JTextArea text = new JTextArea("Time Will Be Displayed Here");
        text.setEditable(false);
        textPanel.add(text);

        JPanel buttonPanel = new JPanel();
        JButton button = new JButton("Mark time!");

        button.addActionListener(e-> {

            long between = MILLIS.between(start,LocalTime.now());

            System.out.println(between/1000 +" Seconds");
            text.setText(Long.toString(between)+" milliseconds");
        }
        );
        buttonPanel.add(button);

        panel.add(textPanel,BorderLayout.SOUTH);
        panel.add(buttonPanel,BorderLayout.CENTER);
        frame.add(panel);

        frame.setSize(300,300);
        frame.setVisible(true);
    }
}
