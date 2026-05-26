package com.msPBL.demo.controller;

import com.msPBL.demo.dto.LionCreateRequest;
import com.msPBL.demo.dto.LionResponse;
import com.msPBL.demo.dto.StaffCreateRequest;
import com.msPBL.demo.dto.StaffResponse;
import com.msPBL.demo.role.Lion;
import com.msPBL.demo.role.Staff;
import com.msPBL.demo.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.msPBL.demo.role.Role;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.msPBL.demo.dto.LionUpdateRequest;
import com.msPBL.demo.dto.StaffUpdateRequest;


@RestController
@RequestMapping("/members")
public class MemberController {

    private MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    // Lion 등록
    @PostMapping("/lions")
    public ResponseEntity<LionResponse> createLion(
            @RequestBody LionCreateRequest dto
    ) {

        Lion lion = service.createLion(dto);

        // 이름 중복
        if (lion == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        LionResponse response = new LionResponse(
                lion.getName(),
                lion.getSpecialty(),
                lion.getHorseman(),
                lion.getPart(),
                lion.getStudentId()
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    // Staff 등록
    @PostMapping("/staffs")
    public ResponseEntity<StaffResponse> createStaff(
            @RequestBody StaffCreateRequest dto
    ) {

        Staff staff = service.createStaff(dto);

        // 이름 중복
        if (staff == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        StaffResponse response = new StaffResponse(
                staff.getName(),
                staff.getSpecialty(),
                staff.getHorseman(),
                staff.getPart(),
                staff.getPosition()
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
    @GetMapping("/{name}")
    public ResponseEntity<?> getMember(
            @PathVariable String name
    ) {

        Role role = service.search(name);

        // 멤버 없음
        if (role == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }

        // Lion인 경우
        if (role instanceof Lion lion) {

            LionResponse response = new LionResponse(
                    lion.getName(),
                    lion.getSpecialty(),
                    lion.getHorseman(),
                    lion.getPart(),
                    lion.getStudentId()
            );

            return ResponseEntity.ok(response);
        }

        // Staff인 경우
        Staff staff = (Staff) role;

        StaffResponse response = new StaffResponse(
                staff.getName(),
                staff.getSpecialty(),
                staff.getHorseman(),
                staff.getPart(),
                staff.getPosition()
        );

        return ResponseEntity.ok(response);
    }

    // Lion 수정
    @PutMapping("/lions/{name}")
    public ResponseEntity<LionResponse> updateLion(
            @PathVariable String name,
            @RequestBody LionUpdateRequest dto
    ) {

        Lion lion = service.updateLion(name, dto);

        // 멤버 없음
        if (lion == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }

        LionResponse response = new LionResponse(
                lion.getName(),
                lion.getSpecialty(),
                lion.getHorseman(),
                lion.getPart(),
                lion.getStudentId()
        );

        return ResponseEntity.ok(response);
    }


    // Staff 수정
    @PutMapping("/staffs/{name}")
    public ResponseEntity<StaffResponse> updateStaff(
            @PathVariable String name,
            @RequestBody StaffUpdateRequest dto
    ) {

        Staff staff = service.updateStaff(name, dto);

        // 멤버 없음
        if (staff == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }

        StaffResponse response = new StaffResponse(
                staff.getName(),
                staff.getSpecialty(),
                staff.getHorseman(),
                staff.getPart(),
                staff.getPosition()
        );

        return ResponseEntity.ok(response);
    }
    // 멤버 삭제
    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteMember(
            @PathVariable String name
    ) {

        boolean deleted = service.deleteMember(name);

        // 멤버 없음
        if (!deleted) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }

        // 삭제 성공
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}