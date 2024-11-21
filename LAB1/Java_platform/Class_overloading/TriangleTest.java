package Java_platform.Class_overloading;
import java.util.Scanner;
import java.util.ArrayList;

public class TriangleTest {
    public static class Triangle {
        //Your code here (멤버 변수로 밑변과 높이를 정의)
        private int height;
        private int width;

        public Triangle(int x, int y){
            width = x;
            height = y;
        }

        public double getArea(){
            return (double)(0.5)*height*width;
        }

        public void printArea(){
            System.out.printf("Triangle [base=%d, height=%d, area=%.2f]\n",width,height,getArea());
        }


        //Your code here (생성자, getArea(), toString() 메서드 정의)
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //sc.nextLine();

        int x = 0;
        int y = 0;

        //ArrayList<Triangle> Triangles = new ArrayList<>();

        for(int i=0;i<n;i++){
            x = sc.nextInt();
            y = sc.nextInt();
            //sc.nextLine();
            Triangle t = new Triangle(x,y);
            t.printArea();
        }
        sc.close();
    }
}
