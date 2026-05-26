package com.msPBL.demo.dto;

public class LionUpdateRequest {

    private String specialty;
    private int horseman;
    private String part;
    private int studentId;

    public LionUpdateRequest(
            String specialty,
            int horseman,
            String part,
            int studentId
    ) {
        this.specialty = specialty;
        this.horseman = horseman;
        this.part = part;
        this.studentId = studentId;
    }

    public String getSpecialty() {
        return specialty;
    }

    public int getHorseman() {
        return horseman;
    }

    public String getPart() {
        return part;
    }

    public int getStudentId() {
        return studentId;
    }
}
