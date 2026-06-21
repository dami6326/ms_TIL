package com.msPBL.demo.dto;

public class LionCreateRequest {

    private String name;
    private String major;
    private int generation;
    private String part;
    private String studentId;

    public LionCreateRequest(
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