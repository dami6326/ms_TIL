package step2;

import role.Role;
import java.util.List;

public interface Repository {
    void save(Role member);
    List<Role> findAll();
    Role findByName(String name);
    boolean isDuplicate(String name);
}