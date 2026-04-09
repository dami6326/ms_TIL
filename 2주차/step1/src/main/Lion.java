package main;

public class Lion {
    public String name;
    String specialty;
    private int horseman;

    public Lion(String name, String specialty, int horseman) {
        this.name = name;
        this.specialty = specialty;
        this.horseman = horseman;
    }

    public int getHorsman(){
        return horseman;
    }
}

