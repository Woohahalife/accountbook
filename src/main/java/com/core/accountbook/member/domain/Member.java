package com.core.accountbook.member.domain;

import com.core.accountbook.common.entity.BaseEntity;
import com.core.accountbook.email.event.publisher.MemberRegisterEmailPublisher;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Embedded
    @Column(nullable = false)
    private Password password;

    @Column(nullable = false)
    private String name;

    @Column
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "login_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private LoginType loginType;

    @Column(name = "email_verified")
    private boolean emailVerified;

    @Column(name = "lock_count")
    private int lockCount;

    @Builder
    private Member(String email,
                  String password,
                  String name,
                  String address,
                  String phoneNumber,
                  Role role,
                  LoginType loginType,
                  boolean emailVerified,
                  int lockCount) {
        this.email = email;
        this.password = toPassword(password);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.loginType = loginType;
        this.emailVerified = emailVerified;
        this.lockCount = lockCount;
    }

    @PostPersist
    private void registerEvent() {
        MemberRegisterEmailPublisher.publishEvent(this);
    }

    public Password toPassword(String password) {
        return new Password(password);
    }

    public Member encode(String rowPassword, PasswordEncryptor encoder) {
        password = this.password.encodePassword(rowPassword, encoder);
        return this;
    }

    public boolean checkPassword(String password, PasswordEncryptor passwordEncoder) {
        return this.password.decode(passwordEncoder).equals(password);
    }
}
