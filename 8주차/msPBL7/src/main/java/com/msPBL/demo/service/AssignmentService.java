package com.msPBL.demo.service;


import com.msPBL.demo.domain.Assignment;
import com.msPBL.demo.domain.Member;
import com.msPBL.demo.dto.AssignmentCreateRequest;
import com.msPBL.demo.dto.AssignmentUpdateRequest;
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
                .orElse(null);

        if (member == null) {
            return null;
        }

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
                .orElse(null);
    }

    @Transactional
    public Assignment update(
            Long id,
            AssignmentUpdateRequest request
    ) {
        Assignment assignment = assignmentRepository.findById(id)
                .orElse(null);

        if (assignment == null) {
            return null;
        }

        assignment.updateInfo(
                request.getTitle(),
                request.getDescription()
        );

        return assignmentRepository.save(assignment);
    }

    @Transactional
    public void delete(Long id) {
        assignmentRepository.deleteById(id);
    }
}