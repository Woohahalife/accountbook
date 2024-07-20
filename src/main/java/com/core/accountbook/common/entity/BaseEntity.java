package com.core.accountbook.common.entity;

import com.core.accountbook.common.exception.globalerror.GlobalErrorCode;
import com.core.accountbook.common.exception.globalerror.GlobalException;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class BaseEntity {

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedDateTime;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    public boolean isDeleted() {
        return status == Status.DELETE;
    }

    public void activate() {
        status = Status.ACTIVE;
    }

    public void softDelete() {

        if(isDeleted()) {
            throw new GlobalException(GlobalErrorCode.ALREADY_DELETED_DATA);
        }

        activate();
    }
}
