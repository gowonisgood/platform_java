package Java_platform.CourseRegistration_033.edu.pnu.admin;

import Java_platform.CourseRegistration_033.edu.pnu.enroll.Enrollment;
import Java_platform.CourseRegistration_033.edu.pnu.enroll.WishListService;

public class AcademicScheduler {
    int year;
    String semester;

    public AcademicScheduler(int year, String semester) {
        this.year = year;
        this.semester = semester;
    }

    public void beginPreEnrollment() {
        System.out.printf("\n --- 학사일정 화면 ---\n");
        System.out.printf("%d 학년도 %s 희망과목담기 기간이 시작되었습니다.\n", year, semester);
        WishListService.getInstance().setAvailable(true);
    }

    public void endPreEnrollment(){
        System.out.printf("\n --- 학사일정 화면 ---\n");
        System.out.printf("%d 학년도 %s 희망과목담기 기간이 종료 되었습니다.\n", year, semester);
        System.out.printf("%d 학년도 %s 자동신청제가 시작됩니다.\n", year, semester);
        WishListService.getInstance().enrollAll();
        WishListService.getInstance().setAvailable(false);
        System.out.printf("%d 학년도 %s 희망과목 자동신청이 완료되었습니다.\n", year, semester);
    }

    public void beginEnrollment() {
        System.out.printf("\n --- 학사일정 화면 ---\n");
        System.out.printf("%d 학년도 %s 수강신청이 시작 되었습니다.\n", year, semester);
        Enrollment.getInstance().setAvailable(true);
    }

    public void endEnrollment() {
        System.out.printf("\n --- 학사일정 화면 ---\n");
        System.out.printf("%d 학년도 %s 수강신청이 종료 되었습니다.\n", year, semester);
        Enrollment.getInstance().setAvailable(false);
    }

    @Override
    public String toString() {
        return String.format("PNU %d 년도 %s %n", year, semester);
    }
}
