package role;

import policy.Policy;
import policy.LionPolicy;

public class Lion extends Role {

    private int studentNumber;

    public Lion(String name, String specialty, int horseman, String part, int studentNumber) {
        super("아기사자", name, specialty, horseman, part);
        this.studentNumber = studentNumber;
    }

    @Override
    public Policy getPolicy() {
        return new LionPolicy();
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public String getInfo() {
        return "역할: " + getRole() + "\n" +
                "이름: " + getName() + "\n" +
                "전공: " + getSpecialty() + "\n"+
                "기수: " + getHorseman() + "\n" +
                "파트: " + getPart() + "\n" +
                "학번: " + studentNumber + "\n" +
                "과제 제출 가능 여부: " +
                (canSubmit() ? "가능" : "불가능");
    }
}

