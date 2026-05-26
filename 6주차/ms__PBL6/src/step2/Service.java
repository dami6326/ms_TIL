package step2;

import role.Role;
import java.util.*;

public class Service {
    private Repository repo;

    // ⭐ 생성자 주입
    public Service(Repository repo) {
        this.repo = repo;
    }

    public boolean register(Role member) {
        if (repo.isDuplicate(member.getName())) {
            return false;
        }
        repo.save(member);
        return true;
    }

    public List<Role> getAll() {
        return repo.findAll();
    }

    public Role search(String name) {
        return repo.findByName(name);
    }
}