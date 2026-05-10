package role;

import policy.Policy;

public abstract class Role {
    private String role;
    private String name;
    private String specialty;
    private String part;
    private int horseman;

    public Role(String role, String name, String specialty, int horseman, String part) {
        this.role = role;
        this.name = name;
        this.specialty = specialty;
        this.part = part;
        this.horseman = horseman;
    }

    public abstract Policy getPolicy();

    public abstract String getInfo();

    public boolean canSubmit() {
        return getPolicy().submit();
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getPart() {
        return part;
    }

    public int getHorseman() {
        return horseman;
    }
}
