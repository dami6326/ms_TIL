package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean e1,e2,e3;
        String q;


        System.out.println("아기사자 이름을 입력해 주세요: ");
        String a = sc.nextLine();

        System.out.println("전공을 입력해 주세요: ");
        String b = sc.nextLine();

        System.out.println("기수를 입력해 주세요: ");
        int c = sc.nextInt();

        Lion l = new Lion(a,b,c);

        System.out.println("객체 생성이 완료되었습니다. 아기사자 객체의 상태를 확인합니다.");


        e1 = l.verification1(l.name);
        e2 = l.verification2(l.specialty);
        e3 = l.verification3(l.getHorsman());

        if (e1) {
            System.out.println("이름은 비어 있을 수 없습니다.");
        }
        if (e2) {
            System.out.println("전공은 비어 있을 수 없습니다.");
        }
        if (e3) {
            System.out.println("기수는 1 이상이어야 합니다.");
        }

        System.out.println(l.verification(e1,e2,e3,l));
    }
}