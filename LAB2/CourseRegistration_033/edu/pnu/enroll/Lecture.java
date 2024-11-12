package Java_platform.CourseRegistration_033.edu.pnu.enroll;
import Java_platform.CourseRegistration_033.edu.pnu.member.Student;
import Java_platform.CourseRegistration_033.edu.pnu.member.Professor;
import java.lang.StringBuilder;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;

public class Lecture {
    private static int COUNTER = 1;
    private int Id;

    private List<ScheduleTime> scheduleTimes;
    private List<Professor> instructors;
    private List<Student> students;
    private int maxUnits;
    private Course course;


    private Lecture(Builder builder){
        this.Id = COUNTER++;
        this.scheduleTimes = builder.scheduleTimes;
        this.instructors = builder.instructors;
        this.students = new ArrayList<>();
        this.maxUnits = builder.maxUnits;
        this.course = builder.course;
    }

    public int getID() {
        return Id;
    }

    public String getCourseName(){
        return course.getName(); //확인 !!!!!!
    }

    public String getStudentAll(){
        StringBuilder sb = new StringBuilder();
        for(Student s : students){
            sb.append(s.toString());
        }
        return sb.toString();
    }

    public boolean isEnrollment(){
        return students.size() < maxUnits;
    }

    public void addStudent(Student student){
        if(isEnrollment()) {
            students.add(student);
            //System.out.println("학생: " + student.getName() + " 이(가)" + this.toString() + "강의에 성공적으로 등록되었습니다.");
        }else{
            System.out.println("강의가 정원에 도달하여 학생을 추가할 수 없습니다.");
        }
    }

    public void removeStudent(Student student){
        if(students.remove(student)){
            //System.out.println("학생: "+student.getName()+" 이(가) 강의에서 제거되었습니다.");
        }else{
            System.out.println("학생: "+student.getName()+" 은(는) 등록되지 않았습니다.");
        }
    }

    public boolean isRegistration(Student student){
        return students.contains(student);
    }

    public List<Student> getStudentsAll(){
        return new ArrayList<>(students);
    }


    public static class ScheduleTime{
        private DayOfWeek dayOfWeek;
        private LocalTime time;

        public ScheduleTime(DayOfWeek dayOfWeek, LocalTime time){
            this.dayOfWeek = dayOfWeek;
            this.time = time;
        }

        @Override
        public String toString() {
            return "{" + dayOfWeek + "," + time + "}";
        }
    }

    public static class Builder{
       //private int id;
        private List<ScheduleTime> scheduleTimes =  new ArrayList<>();
        private List<Professor> instructors = new ArrayList<>();
        private int maxUnits;
        private Course course;


        public Builder setCourse(Course course){
            this.course = course;
            return this;
        }

        public Builder addScheduleTime(DayOfWeek dayOfWeek, LocalTime time){
            this.scheduleTimes.add(new ScheduleTime(dayOfWeek, time));
            return this;
        }

        public Builder addInstructor(Professor professor){
            this.instructors.add(professor);
            return this;
        }

        public Builder addInstructor(String professorName){
            Professor professor = new Professor(professorName);
            this.instructors.add(professor);
            return this;
        }


        public Builder setMaxUnits(int maxUnits){
            this.maxUnits = maxUnits;
            return this;
        }

        public Lecture build(){
            return new Lecture(this);
        }

    }
    @Override
    public String toString() {
        return String.format("수업번호=%d {%s, 강의시간=%s, 교수명=%s, 제한인원=%d}",
                this.Id, course.toString(), scheduleTimes.toString(), instructors.toString(), maxUnits);
    }

}
