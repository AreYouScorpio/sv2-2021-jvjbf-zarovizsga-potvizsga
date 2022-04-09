package students;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String className;
    private List<Integer> grades = new ArrayList<>();

    public Student(String className, String clas) {
        this.name = className;
        this.className = clas;
    }

    public String getName() {
        return name;
    }
    public String getClassName() {
        return className;
    }

    public List<Integer> getGrades() {
        return new ArrayList<>(grades);
    }

    public void addGrade(int note){
        grades.add(note);
    }

    public void readFromFile(Path inputfile) {
        String name = null;
        String clas = null;
        String notes = null;

        int rowNumber = 0;
        try (
                BufferedReader br = Files.newBufferedReader(inputfile)) {
            String line;
            while ((line = br.readLine()) != null) {

                name = parseName(line);
                clas = parseClas(line);
                // notes = parseNotes(line);
                System.out.println(name + clas);
                //notes.add(new Student(name, clas));
            }
            rowNumber++;
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot read file: " + inputfile);
        }
    }

    private String parseName(String line) {
        String[] tempStr = line.split(";");
        return tempStr[0];
    }

    private String parseClas(String line) {
        String[] tempStr = line.split(";");
        return tempStr[1];
    }


}
