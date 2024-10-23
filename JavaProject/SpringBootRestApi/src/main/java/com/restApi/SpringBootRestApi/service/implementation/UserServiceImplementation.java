package com.restApi.SpringBootRestApi.service.implementation;

import com.restApi.SpringBootRestApi.dto.RegistrationRequest;
import com.restApi.SpringBootRestApi.dto.UserDto;
import com.restApi.SpringBootRestApi.dto.Userlogin;
import com.restApi.SpringBootRestApi.entity.User;
import com.restApi.SpringBootRestApi.exception.RecordExistException;
import com.restApi.SpringBootRestApi.exception.UserNotFoundException;
import com.restApi.SpringBootRestApi.repository.UserRepository;
import com.restApi.SpringBootRestApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto registerUser(RegistrationRequest user) throws RecordExistException {
        Optional<User> userByEmail = userRepository.findByEmail(user.getEmail());
        Optional<User> userByMobileNo = userRepository.findByMobileNo(user.getMobileNo());

        if (userByEmail.isPresent() && userByMobileNo.isPresent()) {
            throw new RecordExistException("Mobile no and Email already exist!!");
        }
        else if (userByEmail.isPresent()) {
            throw new RecordExistException("Email already exists!!");
        }
        else if (userByMobileNo.isPresent()) {
            throw new RecordExistException("Mobile no already exists!!");
        }


        // Save the new user
        User createUser=this.userDtoToUser(user);

        User userSaved=userRepository.save(createUser);

        return this.userToUserDto(userSaved);
    }


    @Override
    public UserDto login(Userlogin user) throws UserNotFoundException {
        // Fetch the user based on the provided email
        Optional<User> userOptional = userRepository.findByEmail(user.getEmail());

        if (userOptional.isEmpty()) {
            throw new UserNotFoundException("User does not exist!");
        }

        User userEntity = userOptional.get();

        // Use BCryptPasswordEncoder to match the provided password with the stored hashed password
        if (!passwordEncoder.matches(user.getPassword(), userEntity.getPassword())) {
            throw new UserNotFoundException("Invalid credentials!");
        }

        // Return the UserDto representation of the user entity
        return this.userToUserDto(userEntity);
    }


    private UserDto userToUserDto(User user){
        UserDto userDto=new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setCity(user.getCity());
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setCreated_date(user.getCreated_date());
        userDto.setMobileNo(user.getMobileNo());
        return userDto;
    }

    private User userDtoToUser(RegistrationRequest userDto){
        User user=new User();
        user.setCity(userDto.getCity());
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setMobileNo(userDto.getMobileNo());
        user.setLastName(userDto.getLastName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRoles(userDto.getRoles());
        return user;
    }
}
