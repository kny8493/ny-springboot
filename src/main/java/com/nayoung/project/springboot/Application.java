package com.nayoung.project.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// Application : 메인 클래스

// @EnableJpaAuditing
// @SpringBootApplication : 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정
// 해당 어노테이션이 있는 곳부터 설정을 읽기 때문에 항상 프로젝트 최상단에 있어야함
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // SpringApplication.run 을 통해 내장 was를 실행
        // 내장 WAS란? Web Application Server 로 외부 was를 두지 않고 실행시 내부에서 was를 실행 하는 것
        // 내장 was실행하면 항상 서버에 톰캣을 설치할 필요가 없고, 스프링 부트로 만들어진 Jar파일(실행가는한 JAVA파일)로 실행됨
        // 사용 이유? 내장 WAS를 사용하면 언제 어디서나 같은 환경에서 스프링 부트를 배포할 있다
        SpringApplication.run(Application.class, args);
    }
}
