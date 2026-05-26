package com.msPBL.demo.repository;

import com.msPBL.demo.role.Role;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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
        for (Role member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    // 수정 기능
    @Override
    public void updateByName(String name, Role member) {

        for (int i = 0; i < members.size(); i++) {

            if (members.get(i).getName().equals(name)) {
                members.set(i, member);
                return;
            }
        }
    }

    // 삭제 기능
    @Override
    public boolean deleteByName(String name) {

        return members.removeIf(member ->
                member.getName().equals(name)
        );
    }

    // 존재 여부 확인
    @Override
    public boolean existsByName(String name) {

        for (Role member : members) {

            if (member.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }
}