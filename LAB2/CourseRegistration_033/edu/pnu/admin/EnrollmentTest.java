package Java_platform.CourseRegistration_033.edu.pnu.admin;

import Java_platform.CourseRegistration_033.edu.pnu.enroll.*;
import Java_platform.CourseRegistration_033.edu.pnu.member.*;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.*;

public class EnrollmentTest {
    private static School pnu = new School("PNU");
    private static AcademicScheduler scheduler = new AcademicScheduler(2024, "2학기");

    static {
        pnu.setLectures(createLectures());
        pnu.addStudentAll(createStudents());
        pnu.printLectureAll();
    }

    interface MidTermTestCase {
        void tc();
    }

    public static void main(String[] args) {
        MidTermTestCase[] testCases = new MidTermTestCase[]{
                EnrollmentTest::testWishListEnrollment,
                EnrollmentTest::testCourseRegistration,
                EnrollmentTest::testEnrollmentOutsidePeriod
        };

        //System.out.println("Enter test case number (0, 1, or 2):");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        if (num >= 0 && num < testCases.length) {
            switch(num){
                case 0:
                    System.out.println("\n--- 테스트 1: 희망 과목 신청 시작 ---");
                    break;
                case 1:
                    System.out.println("\n--- 테스트 2: 정규 수강신청 시작 ---");
                    break;
                case 2:
                    System.out.println("\n--- 테스트 3: 수강신청 기간 외 수강신청 ---");
                    break;

            }
            testCases[num].tc();
        } else {
            System.out.println("Invalid test case number.");
        }
    }

    private static void testWishListEnrollment() {
        scheduler.beginPreEnrollment();
        for (int i = 1; i <= 2; i++) {
            if (i == 2) {
                Collections.sort(pnu.getStudentAll(), Comparator.comparing(Student::getName));
            }
            for (Student student : pnu.getStudentAll()) {
                WishListService.getInstance().enroll(pnu.findLecture(i), student);
            }
        }
        scheduler.endPreEnrollment();
        pnu.printStudentAll();
    }

    private static void testCourseRegistration() {
        testWishListEnrollment();
        scheduler.beginEnrollment();
        Lecture[] lectures = {pnu.findLecture(1), pnu.findLecture(2)};
        for (Lecture lecture : lectures) {
            if (lecture != null && pnu.findStudent("김동욱", 2) != null) {
                Enrollment.getInstance().drop(lecture, pnu.findStudent("김동욱", 2));
            }

            if (lecture != null && pnu.findStudent("박정재", 2) != null) {
                Enrollment.getInstance().enroll(lecture, pnu.findStudent("박정재", 2));
            }
        }
        pnu.printStudentAll();
        scheduler.endEnrollment();
    }

    private static void testEnrollmentOutsidePeriod() {
        testCourseRegistration();
        System.out.println("\n수강신청 기간 종료 후 학생을 취소/등록하려고 시도합니다.");

        Enrollment.getInstance().drop(pnu.findLecture(2), pnu.findStudent("박정재", 2));
        Enrollment.getInstance().enroll(pnu.findLecture(1), pnu.findStudent("김동욱", 2));
        pnu.printStudentAll();
    }

    private static List<Student> createStudents() {
        String[] studentNames = {"김동욱", "나은우", "이동원", "박정재"};
        List<Student> students = new ArrayList<>();
        for (String s : studentNames) {
            students.add(new Student(s, 2));
        }
        return students;
    }

    private static List<Lecture> createLectures() {
        List<Lecture> classList = new ArrayList<>();

        Lecture lecture1 = new Lecture.Builder()
                .setCourse(new Course("플랫폼기반프로그래밍", "전공선택"))
                .addInstructor("홍길동")
                .addScheduleTime(DayOfWeek.TUESDAY, LocalTime.of(13, 30))
                .addScheduleTime(DayOfWeek.THURSDAY, LocalTime.of(13, 30))
                .setMaxUnits(3)
                .build();

        Lecture lecture2 = new Lecture.Builder()
                .setCourse(new Course("소프트웨어공학", "전공필수"))
                .addInstructor("이순신")
                .addScheduleTime(DayOfWeek.MONDAY, LocalTime.of(10, 30))
                .addScheduleTime(DayOfWeek.WEDNESDAY, LocalTime.of(10, 30))
                .setMaxUnits(3)
                .build();

        classList.add(lecture1);
        classList.add(lecture2);

        return classList;
    }
}

