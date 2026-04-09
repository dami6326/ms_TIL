package test;
import main.Lion;

import java.util.Scanner;

public class Access {
    /*
    public String pu (Lion l){
        Scanner sc = new Scanner(System.in);

        l.name = sc.nextLine();
        return l.name;
    }
    */
    /*
    public String de (Lion l){
        Scanner sc = new Scanner(System.in);
        System.out.println("default 필드 접근을 시도합니다.");
        System.out.println("전공을 입력하세요");
        l.specialty = sc.nextLine();
        return l.specialty;
    }
    */

    public int pr (Lion l){
        Scanner sc = new Scanner(System.in);
        System.out.println("private 필드 접근을 시도합니다.");
        System.out.println("기수를 입력하세요");
        l.horseman = sc.nextInt();
        return l.horseman;
    }

}
