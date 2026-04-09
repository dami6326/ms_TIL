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

        int e = 0;
        if (a.equals("") || a.equals(" ")) {
            e++;
            System.out.println("이름은 비어 있을 수 없습니다.");
        }
        if (b.equals("") || b.equals(" ")) {
            e++;
            System.out.println("전공은 비어 있을 수 없습니다.");
        }
        if (c < 1) {
            e++;
            System.out.println("기수는 1 이상이어야 합니다.");
        }
        if (e != 0){
            System.out.println("잘못된 아기사자 정보입니다.");
        } else {
            System.out.println("아기사자 객체가 자신의 상태를 정상으로 판단했습니다.");
            System.out.println("아기사자 정보를 출력합니다.");
            System.out.println("이름: "+l.name+" | 전공: "+l.specialty+" | 기수: "+l.getHorsman());
        }
    }
}