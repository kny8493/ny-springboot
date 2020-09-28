package com.nayoung.project.springboot.domain.posts;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
// JPA Entity 클래스 들이 BaseTimeEntity을 상속할 경우 필드들(createdDate, modifiedDate)도 컬럼으로 인식하게 함
@MappedSuperclass
// EntityListeners : BaseTimeEntity 클래스에 Auditing 기능 포함
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {
    // Entity 생성되어 저장될때 자동저장
    @CreatedDate
    private LocalDateTime createDate;
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
