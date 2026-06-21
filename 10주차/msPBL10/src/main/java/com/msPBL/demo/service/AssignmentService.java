package com.msPBL.demo.service;


import com.msPBL.demo.domain.Assignment;
import com.msPBL.demo.domain.Member;
import com.msPBL.demo.dto.AssignmentCreateRequest;
import com.msPBL.demo.dto.AssignmentUpdateRequest;
import com.msPBL.demo.global.exception.AssignmentNotFoundException;
import com.msPBL.demo.global.exception.MemberNotFoundException;
import com.msPBL.demo.repository.AssignmentRepository;
import com.msPBL.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Assignment create(Long memberId, AssignmentCreateRequest request) {

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() ->
                        new MemberNotFoundException("멤버를 찾을 수 없습니다."));

        Assignment assignment = new Assignment(
                request.getTitle(),
                request.getDescription(),
                member
        );

        return assignmentRepository.save(assignment);
    }

    public List<Assignment> findByMemberId(Long memberId) {
        return assignmentRepository.findByMemberId(memberId);
    }

    public Assignment findById(Long id) {
        return assignmentRepository.findById(id)
                .orElseThrow(() ->
                        new AssignmentNotFoundException("과제를 찾을 수 없습니다."));
    }

    @Transactional
    public Assignment update(
            Long id,
            AssignmentUpdateRequest request
    ) {
        Assignment assignment = assignmentRepository.findById(id)
                .orElseThrow(() ->
                        new AssignmentNotFoundException("과제를 찾을 수 없습니다."));

        assignment.updateInfo(
                request.getTitle(),
                request.getDescription()
        );

        return assignmentRepository.save(assignment);
    }

    @Transactional
    public void delete(Long id) {

        Assignment assignment = assignmentRepository.findById(id)
                .orElseThrow(() ->
                        new AssignmentNotFoundException("과제를 찾을 수 없습니다."));

        assignmentRepository.delete(assignment);
    }

    public List<Assignment> findAll() {
        return assignmentRepository.findAll();
    }

    public List<Assignment> searchByTitle(String keyword) {
        return assignmentRepository.findByTitleContaining(keyword);
    }
}