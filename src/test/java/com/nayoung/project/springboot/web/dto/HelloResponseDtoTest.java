package com.nayoung.project.springboot.web.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;


public class HelloResponseDtoTest {
    @Test
    public void lombok_기능_테스트() {
        // given
        String name ="test";
        int amount=1000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // then
        // assertThat : assertj 라는 테스트 검증 라이브러리 메소드
        // 검증 하고 싶은 대상을 메소드 인자로 받음
        // 메소드 체이닝이 지원되어 isEqualTo와 같은 메소드를 이어서 사용가능
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }

}
