package com.lis.api.Test;

import org.jasypt.util.text.BasicTextEncryptor;

public class testDecrypt {
    public static void main(String[] args) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //加密所需的salt(盐)
        textEncryptor.setPassword("Bt%XJ^n1j8mz");
        //要加密的数据（数据库的用户名或密码）
        String username = textEncryptor.encrypt("postgres");
        String password = textEncryptor.encrypt("postgres");
        System.out.println("username: " + username);
        System.out.println("password:" + password);

    }
}
