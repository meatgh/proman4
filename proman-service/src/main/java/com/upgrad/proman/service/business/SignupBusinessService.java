package com.upgrad.proman.service.business;

import com.upgrad.proman.service.dao.UserDao;
import com.upgrad.proman.service.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class SignupBusinessService {


    @Autowired
    private UserAdminBusinessService userAdminBusinessService;


    @Transactional(propagation = Propagation.REQUIRED)
    public UserEntity signup(UserEntity userEntity){

//        removed in the authorizationi video section for code centralization;
//        String[] encryptedText = cryptographyProvider.encrypt(userEntity.getPassword());
//        userEntity.setSalt(encryptedText[0]);
//        userEntity.setPassword(encryptedText[1]);

        return userAdminBusinessService.createUser(userEntity);

//        return userDao.createUser(userEntity);
    }



}
