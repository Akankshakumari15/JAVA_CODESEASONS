import java.util.Scanner;

public class Solid_Rectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of rows:");
        int n = sc.nextInt();
        System.out.println("Enter no. of columns:");
        int m = sc.nextInt();
        sc.close();

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        }
    
}
