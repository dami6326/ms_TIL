package com.msPBL.demo.controller;

import com.msPBL.demo.domain.Assignment;
import com.msPBL.demo.dto.AssignmentCreateRequest;
import com.msPBL.demo.dto.AssignmentResponse;
import com.msPBL.demo.dto.AssignmentUpdateRequest;
import com.msPBL.demo.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignmentService assignmentService;

    // 과제 등록
    @PostMapping("/members/{memberId}/assignments")
    public ResponseEntity<AssignmentResponse> create(
            @PathVariable Long memberId,
            @RequestBody AssignmentCreateRequest request
    ) {
        Assignment assignment = assignmentService.create(memberId, request);

        if (assignment == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(AssignmentResponse.from(assignment));
    }

    // 멤버별 과제 목록 조회
    @GetMapping("/members/{memberId}/assignments")
    public ResponseEntity<List<AssignmentResponse>> findByMemberId(
            @PathVariable Long memberId
    ) {
        List<AssignmentResponse> responses =
                assignmentService.findByMemberId(memberId)
                        .stream()
                        .map(AssignmentResponse::from)
                        .toList();

        return ResponseEntity.ok(responses);
    }

    // 과제 단건 조회
    @GetMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponse> findById(
            @PathVariable Long id
    ) {
        Assignment assignment = assignmentService.findById(id);

        if (assignment == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(
                AssignmentResponse.from(assignment)
        );
    }

    // 과제 수정
    @PutMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponse> update(
            @PathVariable Long id,
            @RequestBody AssignmentUpdateRequest request
    ) {
        Assignment assignment =
                assignmentService.update(id, request);

        if (assignment == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(
                AssignmentResponse.from(assignment)
        );
    }

    // 과제 삭제
    @DeleteMapping("/assignments/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {
        Assignment assignment =
                assignmentService.findById(id);

        if (assignment == null) {
            return ResponseEntity.notFound().build();
        }

        assignmentService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
