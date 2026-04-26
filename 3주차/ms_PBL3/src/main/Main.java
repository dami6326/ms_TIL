package main;
import java.util.Scanner;
import role.Lion;
import role.Staff;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("아기사자 이름 입력: ");
        String a = sc.nextLine();
        System.out.print("전공 입력: ");
        String b = sc.nextLine();
        System.out.print("기수 입력: ");
        int c = sc.nextInt();
        sc.nextLine();
        System.out.print("파트 입력: ");
        String d = sc.nextLine();
        System.out.print("학번 입력: ");
        int e = sc.nextInt();
        sc.nextLine();

        Lion lion = new Lion(a, b, c, d, e);

        System.out.print("운영진 이름 입력: ");
        a = sc.nextLine();
        System.out.print("전공 입력: ");
        b = sc.nextLine();
        System.out.print("기수 입력: ");
        c = sc.nextInt();
        sc.nextLine();
        System.out.print("파트 입력: ");
        d = sc.nextLine();
        System.out.print("직책 입력: ");
        String ee = sc.nextLine();

        Staff staff = new Staff(a, b, c, d, ee);

        System.out.println("결과\n");

        System.out.println(lion.getInfo());
        System.out.println("\n");
        System.out.println(staff.getInfo());
    }
}