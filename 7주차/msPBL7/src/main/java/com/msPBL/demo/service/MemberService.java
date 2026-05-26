package com.msPBL.demo.service;

import com.msPBL.demo.dto.LionCreateRequest;
import com.msPBL.demo.dto.LionUpdateRequest;
import com.msPBL.demo.dto.StaffCreateRequest;
import com.msPBL.demo.dto.StaffUpdateRequest;
import com.msPBL.demo.repository.MemberRepository;
import com.msPBL.demo.role.Lion;
import com.msPBL.demo.role.Role;
import com.msPBL.demo.role.Staff;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private MemberRepository repo;

    public MemberService(MemberRepository repo) {
        this.repo = repo;
    }

    // Lion 생성
    public Lion createLion(LionCreateRequest dto) {

        if (repo.existsByName(dto.getName())) {
            return null;
        }

        Lion lion = new Lion(
                dto.getName(),
                dto.getSpecialty(),
                dto.getHorseman(),
                dto.getPart(),
                dto.getStudentId()
        );

        repo.save(lion);

        return lion;
    }

    // Staff 생성
    public Staff createStaff(StaffCreateRequest dto) {

        if (repo.existsByName(dto.getName())) {
            return null;
        }

        Staff staff = new Staff(
                dto.getName(),
                dto.getSpecialty(),
                dto.getHorseman(),
                dto.getPart(),
                dto.getPosition()
        );

        repo.save(staff);

        return staff;
    }

    // Lion 수정
    public Lion updateLion(
            String name,
            LionUpdateRequest dto
    ) {

        Role role = repo.findByName(name);

        if (role == null) {
            return null;
        }

        Lion lion = (Lion) role;

        lion.setSpecialty(dto.getSpecialty());
        lion.setHorseman(dto.getHorseman());
        lion.setPart(dto.getPart());
        lion.setStudentId(dto.getStudentId());

        repo.updateByName(name, lion);

        return lion;
    }

    // Staff 수정
    public Staff updateStaff(
            String name,
            StaffUpdateRequest dto
    ) {

        Role role = repo.findByName(name);

        if (role == null) {
            return null;
        }

        Staff staff = (Staff) role;

        staff.setSpecialty(dto.getSpecialty());
        staff.setHorseman(dto.getHorseman());
        staff.setPart(dto.getPart());
        staff.setPosition(dto.getPosition());

        repo.updateByName(name, staff);

        return staff;
    }

    // 삭제
    public boolean deleteMember(String name) {

        return repo.deleteByName(name);
    }

    // 전체 조회
    public List<Role> getAll() {

        return repo.findAll();
    }

    // 단일 조회
    public Role search(String name) {

        return repo.findByName(name);
    }
}
