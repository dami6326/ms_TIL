package com.msPBL.demo.repository;

import com.msPBL.demo.role.Role;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository {

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
