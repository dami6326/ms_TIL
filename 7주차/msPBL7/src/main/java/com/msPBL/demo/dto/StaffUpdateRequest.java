package com.msPBL.demo.dto;

public class StaffUpdateRequest {

    private String specialty;
    private int horseman;
    private String part;
    private String position;

    public StaffUpdateRequest(
            String specialty,
            int horseman,
            String part,
            String position
    ) {
        this.specialty = specialty;
        this.horseman = horseman;
        this.part = part;
        this.position = position;
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