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

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @PostMapping("/lions")
    public ResponseEntity<MemberResponse> createLion(
            @RequestBody LionCreateRequest dto
    ) {

        Member member = service.createLion(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(MemberResponse.from(member));
    }

    @PostMapping("/staffs")
    public ResponseEntity<MemberResponse> createStaff(
            @RequestBody StaffCreateRequest dto
    ) {

        Member member = service.createStaff(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(MemberResponse.from(member));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponse> getMember(
            @PathVariable Long id
    ) {

        Member member = service.findById(id);

        return ResponseEntity.ok(
                MemberResponse.from(member)
        );
    }

    @GetMapping
    public ResponseEntity<List<MemberResponse>> getMembers(
            @RequestParam(required = false) String part
    ) {

        List<Member> members;

        if (part != null) {
            members = service.findByPart(part);
        } else {
            members = service.getAll();
        }

        List<MemberResponse> responses =
                members.stream()
                        .map(MemberResponse::from)
                        .toList();

        return ResponseEntity.ok(responses);
    }

    @PutMapping("/lions/{id}")
    public ResponseEntity<MemberResponse> updateLion(
            @PathVariable Long id,
            @RequestBody LionUpdateRequest dto
    ) {

        Member member = service.updateLion(id, dto);

        return ResponseEntity.ok(
                MemberResponse.from(member)
        );
    }

    @PutMapping("/staffs/{id}")
    public ResponseEntity<MemberResponse> updateStaff(
            @PathVariable Long id,
            @RequestBody StaffUpdateRequest dto
    ) {

        Member member = service.updateStaff(id, dto);

        return ResponseEntity.ok(
                MemberResponse.from(member)
        );
    }

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