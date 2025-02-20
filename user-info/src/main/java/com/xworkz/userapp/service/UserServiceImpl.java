package com.xworkz.userapp.service;

import com.xworkz.userapp.dto.UserDto;
import com.xworkz.userapp.entity.UserEntity;
import com.xworkz.userapp.repository.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;


@Component
public class UserServiceImpl implements UserService {

    @Autowired
     UserRepo userRepo;

    @Override
    public void validateAndSave(UserDto userDto) {

        ValidatorFactory validatorFactory= Validation.buildDefaultValidatorFactory();
        Validator validator=validatorFactory.getValidator();
        Set<ConstraintViolation<UserDto>> violations=validator.validate(userDto);
        if(!violations.isEmpty()){
            violations.stream().forEach(error-> System.out.println(error.getMessage()));
        }
        UserEntity userEntity=new UserEntity();
        BeanUtils.copyProperties(userDto,userEntity);
        userRepo.save(userEntity);



    }
}
