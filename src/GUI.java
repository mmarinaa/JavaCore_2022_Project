import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;


public class GUI extends JFrame {
    private JButton button1 = new JButton("Add film");

    private JTextField Search = new JTextField("search",5);
    private JTextField inputN = new JTextField("",5);
    private JTextField inputY = new JTextField("",5);
    private JTextField inputR = new JTextField("",5);
    private JLabel label1 = new JLabel("Input name");
    private JLabel label2 = new JLabel("Input year");
    private JLabel label3 = new JLabel("Input Rating");
    private JButton buttonSA = new JButton("Show All");
    private JButton buttonsearch = new JButton("Search");
    private JButton buttonsort = new JButton("Sort");
    private JRadioButton radioSN = new JRadioButton("Search by Name");
    private JRadioButton radioSY = new JRadioButton("Search by Year");
    private JRadioButton radioSR = new JRadioButton("Search by Rating");

    private JRadioButton radioSAN = new JRadioButton("Sort by Name");
    private JRadioButton radioSAY = new JRadioButton("Sort by Year");
    private JRadioButton radioSAR = new JRadioButton("Sort by Rating");
    //private JCheckBox check = new JCheckBox("check", false);
    public List<Film> films = new ArrayList<Film>();
    public GUI(){
        super("Films Catalogue");
        this.setBounds(200, 200, 300, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(20, 1, 2,2));
        container.add(label1);
        container.add(inputN);
        container.add(label2);
        container.add(inputY);
        container.add(label3);
        container.add(inputR);
        container.add(button1);                             //add film

       container.add(buttonSA);                                 //show all
        buttonSA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = "src/films.txt";

                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new FileReader(fileName));
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                FilmDetails filmDetails = new FilmDetails();

                try {
                    List<Film> films = filmDetails.getFilmFromFile(reader);

                    // For Testing Purposes lets get the Passengers
                    String list = "";
                    for (int i = 0; i < films.size();i++) {
                        list+=i+1+": "+"Title: "+films.get(i).getName()+"\n     year: "+films.get(i).getYear()+"\n    " +
                                " rating: "+films.get(i).getRating();
                        list+="\n";
                    }
                    JOptionPane.showMessageDialog(null, list, "Film List", JOptionPane.PLAIN_MESSAGE);

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
}
        });
        ButtonGroup group1 = new ButtonGroup();
        group1.add(radioSAN);
        group1.add(radioSAY);
        group1.add(radioSAR);
        container.add(radioSAN);
        container.add(radioSAY);
        container.add(radioSAR);
        container.add(buttonsort);
        container.add(Search);
        ButtonGroup group = new ButtonGroup();
        group.add(radioSN);
        group.add(radioSY);
        group.add(radioSR);
        container.add(radioSN);
        container.add(radioSY);
        container.add(radioSR);
        container.add(buttonsearch);
    }

//class ButtonEventListener implements ActionListener{
 //       public  void actionPerformed(ActionEvent e){
          //input.getText()
        //  radio1.isSelected()
       //   check.isSelected())
      // JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
      //  }
//}
}
