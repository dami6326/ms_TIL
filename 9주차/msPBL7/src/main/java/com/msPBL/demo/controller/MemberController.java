package com.msPBL.demo.controller;

import com.msPBL.demo.domain.Member;
import com.msPBL.demo.dto.LionCreateRequest;
import com.msPBL.demo.dto.LionUpdateRequest;
import com.msPBL.demo.dto.MemberResponse;
import com.msPBL.demo.dto.StaffCreateRequest;
import com.msPBL.demo.dto.StaffUpdateRequest;
import com.msPBL.demo.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    // Lion 등록
    @PostMapping("/lions")
    public ResponseEntity<MemberResponse> createLion(
            @RequestBody LionCreateRequest dto
    ) {

        Member member = service.createLion(dto);

        if (member == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(MemberResponse.from(member));
    }

    // Staff 등록
    @PostMapping("/staffs")
    public ResponseEntity<MemberResponse> createStaff(
            @RequestBody StaffCreateRequest dto
    ) {

        Member member = service.createStaff(dto);

        if (member == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(MemberResponse.from(member));
    }

    // 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<MemberResponse> getMember(
            @PathVariable Long id
    ) {

        Member member = service.findById(id);

        if (member == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }

        return ResponseEntity.ok(
                MemberResponse.from(member)
        );
    }

    // Lion 수정
    @PutMapping("/lions/{id}")
    public ResponseEntity<MemberResponse> updateLion(
            @PathVariable Long id,
            @RequestBody LionUpdateRequest dto
    ) {

        Member member = service.updateLion(id, dto);

        if (member == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }

        return ResponseEntity.ok(
                MemberResponse.from(member)
        );
    }

    // Staff 수정
    @PutMapping("/staffs/{id}")
    public ResponseEntity<MemberResponse> updateStaff(
            @PathVariable Long id,
            @RequestBody StaffUpdateRequest dto
    ) {

        Member member = service.updateStaff(id, dto);

        if (member == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }

        return ResponseEntity.ok(
                MemberResponse.from(member)
        );
    }

    // 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(
            @PathVariable Long id
    ) {

        service.deleteMember(id);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}