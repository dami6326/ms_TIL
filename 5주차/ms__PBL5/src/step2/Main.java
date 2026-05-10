package step2;

import role.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("🔧 저장소를 선택하세요:");
        System.out.println("1. MemoryRepository (실제 저장)");
        System.out.println("2. MockRepository (더미 데이터)");
        System.out.print("선택: ");

        int repoChoice = sc.nextInt();
        sc.nextLine();

        Repository repo;

        if (repoChoice == 1) {
            repo = new MemoryRepository();
        } else {
            repo = new MockRepository();
        }

        Service service = new Service(repo);

        while (true) {
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 종료");
            System.out.print("선택: ");

            int select = sc.nextInt();
            sc.nextLine();

            switch (select) {

                case 1:
                    System.out.print("역할 선택(운영진: 1, 아기사자: 2): ");
                    int human = sc.nextInt();
                    sc.nextLine();

                    System.out.print("이름 입력: ");
                    String name = sc.nextLine();

                    System.out.print("전공 입력: ");
                    String major = sc.nextLine();

                    System.out.print("기수 입력: ");
                    int gen = sc.nextInt();
                    sc.nextLine();

                    System.out.print("파트 입력: ");
                    String part = sc.nextLine();

                    Role member = null;

                    if (human == 1) {
                        System.out.print("직책 입력: ");
                        String position = sc.nextLine();
                        member = new Staff(name, major, gen, part, position);
                    } else if (human == 2) {
                        System.out.print("학번 입력: ");
                        int studentId = sc.nextInt();
                        sc.nextLine();
                        member = new Lion(name, major, gen, part, studentId);
                    }

                    if (!service.register(member)) {
                        System.out.println("이미 존재하는 이름입니다.");
                    } else {
                        System.out.println("등록 완료!");
                    }
                    break;

                case 2:
                    List<Role> list = service.getAll();

                    if (list.isEmpty()) {
                        System.out.println("등록된 멤버 없음");
                    } else {
                        int index = 1;
                        for (Role r : list) {
                            System.out.println(
                                    index + ". [" + r.getRole() + "] "
                                            + r.getName() + " - "
                                            + r.getHorseman() + "기"
                            );
                            index++;
                        }
                        System.out.println("총 " + list.size() + "명");
                    }
                    break;

                case 3:
                    System.out.print("검색할 이름 입력: ");
                    String target = sc.nextLine();

                    Role result = service.search(target);

                    if (result == null) {
                        System.out.println("해당 이름의 멤버 없음");
                    } else {
                        System.out.println(result.getInfo());
                    }
                    break;

                case 4:
                    System.out.println("프로그램 종료");
                    return;

                default:
                    System.out.println("잘못된 입력");
            }

            System.out.println();
        }
    }
}