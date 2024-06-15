    package academic.driver;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;
    import java.util.TreeSet;
    import academic.model.Course;
    import academic.model.Enrollment;
    import academic.model.Student;
    import academic.model.Lecturer;

    public class Driver1 {

        final static Scanner scanner = new Scanner(System.in);

        public static void main(String[] _args) {
            List<Course> courses = new ArrayList<>();
            List<Student> students = new ArrayList<>();
            List<Enrollment> enrollments = new ArrayList<>();
            List<String> inputList = new ArrayList<>();
            List<Lecturer> lecturers = new ArrayList<>();

            do {
                String input = scanner.nextLine();
                if (input.equals("---")) {
                    break;
                }
                inputList.add(input);
            } while (true);

            for (String input : inputList) {
                String[] command = input.split("#");

                switch (command[0]) {
                    case "course-add":
                        if (command.length >= 6) {
                        List<String> lecturerInitials = List.of(command[5].split(","));
                        Course course = new Course(command[1], command[2], Integer.parseInt(command[3]), command[4], lecturerInitials);
                        if (!isDuplicateCourse(course, courses)) {
                            courses.add(course);
                            }
                        }
                        break;
                case "lecturer-add":
                        if (command.length == 6) {
                            Lecturer lecturer = new Lecturer(command[1], command[2], command[3], command[4], command[5]);
                            if (!isDuplicateLecturer(lecturer, lecturers)) {
                                lecturers.add(lecturer);
                            }
                        }
                        break;
                    
                    case "student-add":
                        if (command.length == 5) {
                            Student student = new Student(command[1], command[2], command[3], command[4]);
                            if (!isDuplicateStudent(student, students)) {
                                students.add(student);
                            }
                        }
                        break;
                    default:
                        break;
                }
            }


            for (Course course : courses) {
                System.out.println(course);
            }
            for (Lecturer lecturer : lecturers) {
                System.out.println(lecturer);
            
            }
            //buatlah untuk lecturer
            for (Student student : students) {
                System.out.println(student);
            }
        }

        private static boolean isDuplicateCourse(Course course, List<Course> courses) {
            return courses.stream().anyMatch(c -> c.getCode().equals(course.getCode()));
        }

        private static boolean isDuplicateStudent(Student student, List<Student> students) {
            return students.stream().anyMatch(s -> s.getId().equals(student.getId()));
        }

        private static boolean isDuplicateLecturer(Lecturer lecturer, List<Lecturer> lecturers) {
        return lecturers.stream().anyMatch(e -> e.getName().equals(lecturer.getName()));
    }

    }
    
