package com.msPBL.demo.dto;

public class LionUpdateRequest {

    private String name;
    private String major;
    private String part;
    private int generation;
    private String studentId;

    public LionUpdateRequest(
            String name,
            String major,
            String part,
            int generation,
            String studentId
    ) {
        this.name = name;
        this.major = major;
        this.part = part;
        this.generation = generation;
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public String getPart() {
        return part;
    }

    public int getGeneration() {
        return generation;
    }

    public String getStudentId() {
        return studentId;
    }
}