package likelion;
import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int babylion;

        do {
            System.out.print("아기사자 수: ");
            babylion = sc.nextInt();
            if (babylion < 5){
                System.out.print("다시 입력하세요\n");
            }
        } while (babylion < 5);

        String[] babylion_name;
        babylion_name = new String[babylion];

        for (int i = 0 ; i < babylion ; i+=1){
            System.out.print("이름을 입력하세요: ");
            babylion_name[i] = sc.next();
        }
        System.out.print("최종 아기사자 명단\n");
        for (int i = 0 ; i < babylion ; i+=1){
            System.out.print((i+1)+"."+babylion_name[i]+"\n");
        }

        sc.close();
    }
}