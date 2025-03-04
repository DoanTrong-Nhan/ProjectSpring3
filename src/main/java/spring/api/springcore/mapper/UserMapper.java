package spring.api.springcore.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import spring.api.springcore.dto.request.UserCreationRequest;
import spring.api.springcore.dto.request.UserUpdateRequest;
import spring.api.springcore.dto.request.response.UserResponse;
import spring.api.springcore.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);
    void  updateUser(@MappingTarget User user, UserUpdateRequest request);

}
