package spring.api.springcore.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.api.springcore.dto.request.UserCreationRequest;
import spring.api.springcore.dto.request.UserUpdateRequest;
import spring.api.springcore.dto.request.response.UserResponse;
import spring.api.springcore.entity.User;
import spring.api.springcore.exception.AppException;
import spring.api.springcore.exception.ErrorCode;
import spring.api.springcore.mapper.UserMapper;
import spring.api.springcore.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

     UserRepository userRepository;
     UserMapper userMapper;

    public User createRequest(UserCreationRequest request) {

        if (userRepository.existsByUsername(request.getUsername()))
            throw new RuntimeException("ErrorCode.USER_EXISTED");

        User user = userMapper.toUser(request);

        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public UserResponse getUser(String id) {
        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(() ->new RuntimeException("User not found")));
    }

    public UserResponse updateUser(String userId, UserUpdateRequest request) {

       User user = userRepository.findById(userId).orElseThrow(() ->new RuntimeException("User not found"));;
       userMapper.updateUser(user, request);

       return userMapper.toUserResponse(userRepository.save(user));
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
