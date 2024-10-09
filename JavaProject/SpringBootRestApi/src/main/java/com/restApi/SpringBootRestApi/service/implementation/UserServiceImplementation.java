package com.restApi.SpringBootRestApi.service.implementation;

import com.restApi.SpringBootRestApi.dto.UserDto;
import com.restApi.SpringBootRestApi.dto.Userlogin;
import com.restApi.SpringBootRestApi.entity.User;
import com.restApi.SpringBootRestApi.exception.RecordExistException;
import com.restApi.SpringBootRestApi.exception.UserNotFoundException;
import com.restApi.SpringBootRestApi.repository.UserRepository;
import com.restApi.SpringBootRestApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(UserDto userDto) throws RecordExistException {
        Optional<User> userByEmail = userRepository.findByEmail(userDto.getEmail());
        Optional<User> userByMobileNo = userRepository.findByMobileNo(userDto.getMobileNo());

        if (userByEmail.isPresent() && userByMobileNo.isPresent()) {
            throw new RecordExistException("Mobile no and Email already exist!!");
        }
        else if (userByEmail.isPresent()) {
            throw new RecordExistException("Email already exists!!");
        }
        else if (userByMobileNo.isPresent()) {
            throw new RecordExistException("Mobile no already exists!!");
        }

        // Map UserDto to User entity
        User user = this.userDtoToUser(userDto);

        // Save the new user
        return userRepository.save(user);
    }


    @Override
    public boolean login(Userlogin user) throws UserNotFoundException {
        Optional<User> user1 = userRepository.findById(user.getUserId());
        if(user1.isEmpty()){
            throw new UserNotFoundException("User Not Exist!!");
        }
        return user1.get().getPassword().equals(user.getPassword());
    }

    public UserDto userToUserDto(User user){
        UserDto userDto=new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setCity(user.getCity());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setCreated_date(user.getCreated_date());
        userDto.setMobileNo(user.getMobileNo());
        return userDto;
    }

    public User userDtoToUser(UserDto userDto){
        User user=new User();
        user.setUserId(userDto.getUserId());
        user.setCity(userDto.getCity());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setMobileNo(userDto.getMobileNo());
        user.setLastName(userDto.getLastName());
        user.setCreated_date(userDto.getCreated_date());
        return user;
    }
}
