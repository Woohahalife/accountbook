package com.core.accountbook.member.domain;

public interface PasswordEncryptor {

    String encrypt(String password);
    String decrypt(String password);

}
