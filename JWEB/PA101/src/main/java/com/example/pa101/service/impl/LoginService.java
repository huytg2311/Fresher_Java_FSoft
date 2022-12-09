package com.example.pa101.service.impl;

import com.example.pa101.repository.ILoginRepository;
import com.example.pa101.repository.impl.LoginRepository;
import com.example.pa101.service.ILoginService;

public class LoginService implements ILoginService {

    ILoginRepository iLoginRepository = new LoginRepository();

    @Override
    public boolean loginAction(String username, String password) {
        return iLoginRepository.loginAction(username, password);
    }
}
