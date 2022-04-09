package students;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TeacherNotebook {

    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public void readFromFile(Path inputfile) {
        String name = null;
        String clas = null;
        List<Integer> grades = null;

        int rowNumber = 0;
        try (
                BufferedReader br = Files.newBufferedReader(inputfile)) {
            String line;
            while ((line = br.readLine()) != null) {

                name = parseName(line);
                clas = parseClas(line);
                grades = parseNotes(line);
                students.add(new Student(name, clas, grades));
                System.out.println(students);
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

    private List<Integer> parseNotes(String line) {
        List<Integer> notes = new ArrayList<>();
        String[] tempStr = line.split(";");
        for (int i = 2; i < tempStr.length; i++) {
            notes.add(Integer.parseInt(tempStr[i]));
        }
        System.out.println("Az átadott beolvasott jegy listák:");
        System.out.println(notes);
        return notes;
    }


}
