package com.xworkz.userapp.service;

import com.xworkz.userapp.dto.UserDto;

public interface UserService {
   void validateAndSave(UserDto userDto);
}
