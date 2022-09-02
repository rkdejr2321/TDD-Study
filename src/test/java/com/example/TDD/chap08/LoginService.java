package com.example.TDD.chap08;

public class LoginService {
    private String authKey = "someKey";
    private CustomerRepository customerRepo;

    public LoginService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    public LoginService(String id, String pw) {
        int resp = 0;
        boolean authorized = AuthUtil.authorize(authKey);
    }
}
