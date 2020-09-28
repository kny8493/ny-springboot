package com.nayoung.project.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// @RunWith(SpringRunner.class) : 테스트 진행 JUnit에 내장된 실행자외 다른 실행자 진행시킴
//                              : SpringRunner이란 실행자 사용 -> 스프링부트 테스트와 JUnit사이에 연결자 역할
@RunWith(SpringRunner.class)
// @WebMvcTest
// : Web(Spring MVC)에 집중할 수 있는 어노테이션
// : @Controller, @ControllerAdvice 사용가능
// : @Service, @Component, @Repository 사용 불가
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
    //@Autowired : 스프링이 관리하는 빈 주입
    @Autowired
    // 웹 API테스트시 사용, 스프링 MVC 테스트의 시작점, REST API 테스트 가능
    private MockMvc mvc;

    @Test
    public void hello가_리턴됨() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name="hello";
        int amount = 1000;
        // param : API테스트시 사용될 파라미터 설정
        // 단, String 만 허용
        mvc.perform(
                get("/hello/dto")
                    .param("name", name)
                    .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                // jsonPath : JSON응답값을 필드별로 검증할 수 있는 메소드
                // $ 기준으로 필드명 명시
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
