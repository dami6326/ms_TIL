package step2;

import role.Role;
import java.util.*;

public class MemoryRepository implements Repository {

    private List<Role> members = new ArrayList<>();

    @Override
    public void save(Role member) {
        members.add(member);
    }

    @Override
    public List<Role> findAll() {
        return members;
    }

    @Override
    public Role findByName(String name) {
        for (Role r : members) {
            if (r.getName().equals(name)) return r;
        }
        return null;
    }

    @Override
    public boolean isDuplicate(String name) {
        return findByName(name) != null;
    }
}
