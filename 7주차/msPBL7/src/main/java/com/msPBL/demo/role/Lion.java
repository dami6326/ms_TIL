package com.msPBL.demo.role;

import com.msPBL.demo.policy.SubmissionPolicy;
import com.msPBL.demo.policy.LionSubmissionPolicy;

public class Lion extends Role {

    private int studentId;

    public Lion(String name, String specialty, int horseman, String part, int studentNumber) {
        super("아기사자", name, specialty, horseman, part);
        this.studentId = studentId;
    }

    @Override
    public SubmissionPolicy getPolicy() {
        return new LionSubmissionPolicy();
    }

    public int getStudentNumber() {
        return studentId;
    }

    public String getInfo() {
        return "역할: " + getRole() + "\n" +
                "이름: " + getName() + "\n" +
                "전공: " + getSpecialty() + "\n"+
                "기수: " + getHorseman() + "\n" +
                "파트: " + getPart() + "\n" +
                "학번: " + studentId + "\n" +
                "과제 제출 가능 여부: " +
                (canSubmit() ? "가능" : "불가능");
    }
    public void setStudentId(int studentNumber) {
        this.studentId = studentNumber;
    }
    public int getStudentId() {
        return studentId;
    }
}
