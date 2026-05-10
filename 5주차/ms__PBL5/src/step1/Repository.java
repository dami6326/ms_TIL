package step1;

import role.Role;
import java.util.*;

public class Repository {
    private List<Role> members = new ArrayList<>();

    public void save(Role member) {
        members.add(member);
    }

    public List<Role> findAll() {
        return members;
    }

    public Role findByName(String name) {
        for (Role r : members) {
            if (r.getName().equals(name)) {
                return r;
            }
        }
        return null;
    }

    public boolean isDuplicate(String name) {
        return findByName(name) != null;
    }
}