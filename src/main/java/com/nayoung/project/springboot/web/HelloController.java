package com.nayoung.project.springboot.web;

import com.nayoung.project.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// @RestController는 @Controller + @ResponseBody 합친것
// 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어줌
@RestController
public class HelloController {
    // GET요청을 받을 수 있는 API
    // 과거 @RequestMapping(method=RequestMethod.GET)과 같음
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
