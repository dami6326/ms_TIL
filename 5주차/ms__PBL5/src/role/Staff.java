package role;

import policy.Policy;
import policy.StaffPolicy;

public class Staff extends Role {

    private String position;

    public Staff(String name, String specialty, int horseman, String part, String position) {
        super("운영진", name, specialty, horseman, part);
        this.position = position;
    }

    @Override
    public Policy getPolicy() {
        return new StaffPolicy();
    }

    public String getInfo() {
        return "역할: " + getRole() + "\n" +
                "이름: " + getName() + "\n" +
                "전공: " + getSpecialty() + "\n" +
                "기수: " + getHorseman() + "\n" +
                "파트: " + getPart() + "\n" +
                "직책: " + position + "\n" +
                "과제 제출 가능 여부: " +
                (canSubmit() ? "가능" : "불가능");
    }
}
