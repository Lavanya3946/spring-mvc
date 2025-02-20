package com.xworkz.userapp.repository;

import com.xworkz.userapp.entity.UserEntity;

public interface UserRepo {
    boolean save(UserEntity userEntity);
}
