package step2;

import role.Lion;
import role.Role;
import role.Staff;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Role> members = new ArrayList<>();

        while (true) {
            System.out.println("=====멤버 관리 시스템=====");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 파트별 멤버 조회");
            System.out.println("5. 종료");
            System.out.print("선택: ");

            int select = sc.nextInt();

            switch (select) {

                // 1
                case 1:
                    System.out.print("역할 선택(운영진: 1, 아기사자: 2): ");
                    int human = sc.nextInt();
                    sc.nextLine();

                    if (human == 1) {
                        System.out.print("운영진 이름 입력: ");
                        String name = sc.nextLine();

                        //중복 체크
                        if (isDuplicate(members, name)) {
                            System.out.println("이미 존재하는 이름입니다.");
                            break;
                        }

                        System.out.print("전공 입력: ");
                        String major = sc.nextLine();

                        System.out.print("기수 입력: ");
                        int gen = sc.nextInt();
                        sc.nextLine();

                        System.out.print("파트 입력: ");
                        String part = sc.nextLine();

                        System.out.print("직책 입력: ");
                        String position = sc.nextLine();

                        Staff staff = new Staff(name, major, gen, part, position);
                        members.add(staff);

                        System.out.println("등록 완료!");
                    } else if (human == 2) {
                        System.out.print("아기사자 이름 입력: ");
                        String name = sc.nextLine();

                        //중복 체크
                        if (isDuplicate(members, name)) {
                            System.out.println("이미 존재하는 이름입니다.");
                            break;
                        }

                        System.out.print("전공 입력: ");
                        String major = sc.nextLine();

                        System.out.print("기수 입력: ");
                        int gen = sc.nextInt();
                        sc.nextLine();

                        System.out.print("파트 입력: ");
                        String part = sc.nextLine();

                        System.out.print("학번 입력: ");
                        int studentId = sc.nextInt();
                        sc.nextLine();

                        Lion lion = new Lion(name, major, gen, part, studentId);
                        members.add(lion);

                        System.out.println("등록 완료!");
                    }
                    break;

                // 2
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
                    break;

                // 3
                case 3:
                    sc.nextLine();
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
                    break;

                //4
                case 4:
                    sc.nextLine();
                    System.out.print("조회할 파트 입력: ");
                    String targetPart = sc.nextLine();

                    boolean foundPart = false;
                    int index = 1;

                    System.out.println("— 파트별 멤버 목록 —");

                    for (Role r : members) {
                        if (r.getPart().equals(targetPart)) {
                            System.out.println(
                                    index + ". [" + r.getRole() + "] "
                                            + r.getName() + " - "
                                            + r.getHorseman() + "기"
                            );
                            index++;
                            foundPart = true;
                        }
                    }

                    if (!foundPart) {
                        System.out.println("해당 파트의 멤버 없음");
                    } else {
                        System.out.println("총 " + (index - 1) + "명");
                    }

                    break;
                case 5:
                    System.out.println("프로그램 종료");
                    return;

                default:
                    System.out.println("잘못된 입력");
            }

            System.out.println(); // 줄 띄우기
        }
    }

    static boolean isDuplicate(List<Role> members, String name) {
        for (Role r : members) {
            if (r.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}