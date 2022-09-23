package codingtest.self.modusign;

import java.util.stream.*;

import org.aspectj.weaver.tools.UnsupportedPointcutPrimitiveException;

import java.util.*;

public class Task1 {
	public static class Student {
        private String name;
        private int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public int getScore() {
            return score;
        }

        public String getName() {
            return name;
        }
    }

    public static List<String> studentsThatPass(Stream<Student> students, int passingScore) {
    	return students.filter(s -> passingScore <= s.score)
                .sorted(Comparator.comparing(Student::getScore).reversed())
                .map(Student::getName)
                .toList();
    }

    public static void main(String[] args) {

        List<Student> students = new ArrayList<Student>();

        students.add(new Student("Mike", 80));
        students.add(new Student("s", 50));
        students.add(new Student("h", 49));
        students.add(new Student("c", 51));
        students.add(new Student("q", 51));
        students.add(new Student("c", 53));
        students.add(new Student("test", 1000000000));
        students.add(new Student("James", 57));
        students.add(new Student("Alan", 21));

        studentsThatPass(students.stream(), 50).forEach(System.out::println);
    }

}//end class()
