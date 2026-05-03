package step1;

import role.Lion;
import role.Staff;
import java.util.Scanner;
import role.Role;
import java.util.List;

public class Select{
    Scanner sc = new Scanner(System.in);

    List<Role> members;

    public Select(List<Role> members) {
        this.members = members;
    }

    String select(int select){
        switch (select){
            case 1:
                System.out.print("역할 선택(운영진: 1, 아기사자: 2): ");
                int human = sc.nextInt();
                return lion1(human);
            case 2:
                System.out.println("— 전체 멤버 목록 —");

                if (members.isEmpty()) {
                    System.out.println("등록된 멤버 없음");
                } else {
                    int index = 1;

                    for (Role r : members) {
                        System.out.println(
                                index + ". [" + r.getRole() + "] "
                                        + r.getName() + " - "
                                        + r.getHorseman() + "기"
                        );
                        index++;
                    }

                    System.out.println("총 " + members.size() + "명");
                }

                return "조회 완료";

            case 3:
                System.out.print("검색할 이름 입력: ");
                String target = sc.nextLine();

                boolean found = false;

                for (Role r : members) {
                    if (r.getName().equals(target)) {
                        System.out.println(r.getInfo());
                        System.out.println("------------");
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("해당 이름의 멤버 없음");
                }

                return "검색 완료";
        }
        return "error";
    }

    String lion1(int human){
        if (human == 1){
            sc.nextLine();
            System.out.print("운영진 이름 입력: ");
            String a = sc.nextLine();

            if (isDuplicate(a)) {
                System.out.println("이미 존재하는 이름입니다.");
                return "중복";
            }

            System.out.print("전공 입력: ");
            String b = sc.nextLine();
            System.out.print("기수 입력: ");
            int c = sc.nextInt();
            sc.nextLine();
            System.out.print("파트 입력: ");
            String d = sc.nextLine();
            System.out.print("직책 입력: ");
            String ee = sc.nextLine();

            Staff staff = new Staff(a, b, c, d, ee);
            members.add(staff);
            System.out.println("운영진 등록 완료");
            return staff.getInfo();

        } else if (human == 2) {
            sc.nextLine();
            System.out.print("아기사자 이름 입력: ");
            String a = sc.nextLine();

            if (isDuplicate(a)) {
                System.out.println("이미 존재하는 이름입니다.");
                return "중복";
            }

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
            members.add(lion);
            System.out.println("아기사자 등록 완료");
            return lion.getInfo();
        } else {
            return "error";
        }
    }

    boolean isDuplicate(String name) {
        for (Role r : members) {
            if (r.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

}
