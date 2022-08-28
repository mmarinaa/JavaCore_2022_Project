import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Film {
    private String name;
    private int year;
    private double rating;

    public List<String> comments = new ArrayList<String>();
   // int commentsCounter = 0;
    public Film() {

    }
    public Film(String name, int year, double rating) {
        this.name = name;
        this.year = year;
        this.rating = rating;
    }

    public Film(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void addComment(String comment) {
        comments.add(comment);
    }

    public void ShowComments(){
        for(int i = 0; i < this.comments.size(); i++){
            System.out.println(i+comments.get(i)+"\n");
        }
    }
        public void writeFilm() throws IOException {

            try (BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(new File("src/films.txt") , true))) {

                bufferedWriter.write(this.name+","+this.year+","+this.rating);
                bufferedWriter.newLine();
                bufferedWriter.flush();
               // JOptionPane.showMessageDialog(null, "Film added!", "Congrats!", JOptionPane.PLAIN_MESSAGE);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public static Film readFilm(File file) throws IOException, ClassNotFoundException {
        Film result = null;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            result = (Film) ois.readObject();
        }
        return result;
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                '}';
    }


}

