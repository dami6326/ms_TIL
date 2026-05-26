package com.msPBL.demo;

import com.msPBL.demo.role.Role;
import java.util.*;

public class MemberService {
    private MemberRepository repo;

    public MemberService(MemberRepository repo) {
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
