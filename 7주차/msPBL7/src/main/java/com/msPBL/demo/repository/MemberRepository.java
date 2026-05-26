package com.msPBL.demo.repository;

import com.msPBL.demo.role.Role;

import java.util.List;

public interface MemberRepository {

    void save(Role member);

    List<Role> findAll();

    Role findByName(String name);

    // 추가
    void updateByName(String name, Role member);

    boolean deleteByName(String name);

    boolean existsByName(String name);
}
