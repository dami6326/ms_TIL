package com.msPBL.demo;

import com.msPBL.demo.role.Role;
import java.util.List;

public interface MemberRepository {
    void save(Role member);
    List<Role> findAll();
    Role findByName(String name);
    boolean isDuplicate(String name);
}
