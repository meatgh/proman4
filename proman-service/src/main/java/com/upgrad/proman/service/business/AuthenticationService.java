package com.upgrad.proman.service.business;

import com.upgrad.proman.service.dao.UserDao;
import com.upgrad.proman.service.entity.UserEntity;
import com.upgrad.proman.service.exception.AuthenticationFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordCryptographyProvider cryptographyProvider;

    public UserEntity authenticate(final String username, final String password) throws AuthenticationFailedException {

        UserEntity userEntity = userDao.getUserByEmail(username);
        if(userEntity == null){
            throw new AuthenticationFailedException("ATH 001", "User with email not found");
        }

        final String encryptedPassword = cryptographyProvider.encrypt(password, userEntity.getSalt());
        if(encryptedPassword.equals(userEntity.getPassword())){

        }else{
            throw new AuthenticationFailedException("ATH 001", "Password failed");
        }

    }
}
