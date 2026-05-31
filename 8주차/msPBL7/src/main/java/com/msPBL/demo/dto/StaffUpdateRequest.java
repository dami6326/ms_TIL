package com.msPBL.demo.dto;

public class StaffUpdateRequest {

    private String name;
    private String major;
    private int generation;
    private String part;
    private String position;

    public StaffUpdateRequest(
            String name,
            String major,
            int generation,
            String part,
            String position
    ) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public int getGeneration() {
        return generation;
    }

    public String getPart() {
        return part;
    }

    public String getPosition() {
        return position;
    }
}