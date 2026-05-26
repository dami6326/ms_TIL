package com.msPBL.demo.dto;

public class StaffResponse {

    private String name;
    private String specialty;
    private int horseman;
    private String part;
    private String position;

    public StaffResponse(
            String name,
            String specialty,
            int horseman,
            String part,
            String position
    ) {
        this.name = name;
        this.specialty = specialty;
        this.horseman = horseman;
        this.part = part;
        this.position = position;
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

    public String getPosition() {
        return position;
    }
}