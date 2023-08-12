import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cgpa
{
    public static void main(String args[])
    {
        calculate obj=new calculate();
    }
}

class calculate extends JFrame implements ActionListener
{
    JTextField[] gradefields;
    JTextField[] creditfields;
    JLabel result;
    JButton b;

    public calculate()
    {
        setTitle("cgpa Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0,2,10,10));
        int n=5;//number of courses

        gradefields=new JTextField[n];
        creditfields=new JTextField[n];

        for (int i=0; i<n; i++) 
        {
            JLabel gradelabel = new JLabel("Course " + (i + 1) + " Grade: ");
            gradefields[i] = new JTextField();
            JLabel creditlabel = new JLabel("Course " + (i + 1) + " Credits: ");
            creditfields[i] = new JTextField();

            add(gradelabel);
            add(gradefields[i]);
            add(creditlabel);
            add(creditfields[i]);
        }
        b=new JButton("calculate cgpa");
        b.addActionListener(this);
        add(b);
        result = new JLabel("Your CGPA will be displayed here");
        add(result);

        setVisible(true);
        setSize(400,600);
    

    }
     public void actionPerformed(ActionEvent e) {
        int totalcredits = 0;
        double totalgrade = 0.0;

        for (int i = 0; i < gradefields.length; i++) {
            String gradeText = gradefields[i].getText();
            String creditText = creditfields[i].getText();

            if (!gradeText.isEmpty() && !creditText.isEmpty()) {
                double gradePoint = convertGradeToGradePoint(gradeText);
                int credits = Integer.parseInt(creditText);

                totalgrade += gradePoint * credits;
                totalcredits += credits;
            }
        }

        if (totalcredits > 0)
        {
            double cgpa = totalgrade / totalcredits;
            result.setText("Your CGPA: " + String.format("%.2f", cgpa));
        }
        else
        {
            result.setText("Please enter valid grades and credits.");
        }
    }

    private double convertGradeToGradePoint(String grade) 
    {
        
        switch (grade.toUpperCase()) {
            case "O":
                return 10.0;
            case "A":
                return 8.0;
            case "B":
                return 6.0;
            case "C":
                return 5.0;
            default:
                return 0.0;
        }
    }

}







