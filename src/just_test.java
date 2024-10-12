public class just_test {
    public static void main(String[] args){
        int numOfLines = 5;
        for(int i=1;i<=(numOfLines*2)-1;i=i*2-1){
            for(int j=0;j<i;j++){
                System.out.printf("+");
            }
            System.out.printf("\n");
        }

    }
}
