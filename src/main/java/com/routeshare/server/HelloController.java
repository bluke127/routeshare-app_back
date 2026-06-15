package com.routeshare.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 1. 이 클래스는 프론트엔드에 데이터를 던져주는 안내 데스크라고 지정!
public class HelloController {

    @GetMapping("/") // 2. 사용자가 주소창에 아무것도 안 붙이고 그냥 들어왔을 때(루트 주소)
    public String hello() {
        return "🚗 델따줄까 백엔드 서버 정상 작동 중!"; // 3. 이 글자를 화면에 보여줘라!
    }
}