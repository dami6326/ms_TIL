package com.msPBL.demo.service;

import com.msPBL.demo.domain.Member;
import com.msPBL.demo.domain.RoleType;
import com.msPBL.demo.dto.LionCreateRequest;
import com.msPBL.demo.dto.LionUpdateRequest;
import com.msPBL.demo.dto.StaffCreateRequest;
import com.msPBL.demo.dto.StaffUpdateRequest;
import com.msPBL.demo.global.exception.DuplicateMemberNameException;
import com.msPBL.demo.global.exception.MemberNotFoundException;
import com.msPBL.demo.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository repo;

    public MemberService(MemberRepository repo) {
        this.repo = repo;
    }

    // Lion 생성
    @Transactional
    public Member createLion(LionCreateRequest dto) {

        if (repo.existsByName(dto.getName())) {
            throw new DuplicateMemberNameException(
                    "이미 존재하는 멤버 이름입니다."
            );
        }

        Member member = new Member(
                dto.getName(),
                dto.getMajor(),
                dto.getPart(),
                dto.getGeneration(),
                RoleType.LION,
                dto.getStudentId(),
                null
        );

        return repo.save(member);
    }

    // Staff 생성
    @Transactional
    public Member createStaff(StaffCreateRequest dto) {

        if (repo.existsByName(dto.getName())) {
            throw new DuplicateMemberNameException(
                    "이미 존재하는 멤버 이름입니다."
            );
        }

        Member member = new Member(
                dto.getName(),
                dto.getMajor(),
                dto.getPart(),
                dto.getGeneration(),
                RoleType.STAFF,
                null,
                dto.getPosition()
        );

        return repo.save(member);
    }

    // Lion 수정
    @Transactional
    public Member updateLion(
            Long id,
            LionUpdateRequest dto
    ) {

        Member member = repo.findById(id)
                .orElseThrow(() ->
                        new MemberNotFoundException("멤버를 찾을 수 없습니다."));

        member.update(
                dto.getName(),
                dto.getMajor(),
                dto.getPart(),
                dto.getGeneration(),
                RoleType.LION,
                dto.getStudentId(),
                null
        );

        return repo.save(member);
    }

    // Staff 수정
    @Transactional
    public Member updateStaff(
            Long id,
            StaffUpdateRequest dto
    ) {

        Member member = repo.findById(id)
                .orElseThrow(() ->
                        new MemberNotFoundException("멤버를 찾을 수 없습니다."));

        member.update(
                dto.getName(),
                dto.getMajor(),
                dto.getPart(),
                dto.getGeneration(),
                RoleType.STAFF,
                null,
                dto.getPosition()
        );

        return repo.save(member);
    }

    // 삭제
    @Transactional
    public void deleteMember(Long id) {

        Member member = repo.findById(id)
                .orElseThrow(() ->
                        new MemberNotFoundException("멤버를 찾을 수 없습니다."));

        repo.delete(member);
    }

    // 단건 조회
    public Member findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new MemberNotFoundException("멤버를 찾을 수 없습니다."));
    }

    // 전체 조회
    public List<Member> getAll() {
        return repo.findAll();
    }

    // 파트별 조회
    public List<Member> findByPart(String part) {
        return repo.findByPart(part);
    }

}