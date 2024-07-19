package com.core.accountbook.category;

import com.core.accountbook.member.exception.MemberErrorCode;
import com.core.accountbook.member.exception.MemberException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/get")
    public ResponseEntity<TestDto> Method() {

        TestDto ok = new TestDto("OK");
        return ResponseEntity.ok(ok);
    }

    @GetMapping("/get2")
    public String getStringMethod() {
        return null;
    }

    @GetMapping("/error1")
    public void exception1() {
        throw new MemberException(MemberErrorCode.TEST_ERROR, "시범용 에러 사용");
    }

    @GetMapping("/error2")
    public void exception2() {
        throw new IllegalArgumentException();
    }
}
