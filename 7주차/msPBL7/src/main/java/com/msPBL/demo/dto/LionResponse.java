package com.msPBL.demo.dto;

public class LionResponse {

    private String name;
    private String specialty;
    private int horseman;
    private String part;
    private int studentId;

    public LionResponse(
            String name,
            String specialty,
            int horseman,
            String part,
            int studentId
    ) {
        this.name = name;
        this.specialty = specialty;
        this.horseman = horseman;
        this.part = part;
        this.studentId = studentId;
    }

    public String getName() {
        return name;
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