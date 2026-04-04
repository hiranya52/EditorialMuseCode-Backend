package mapper;

import model.dto.UserDTO;
import model.entity.Category;
import model.entity.User;

import java.util.stream.Collectors;

public final class UserMapper {

    // 🔄 Entity → DTO
    public static UserDTO mapToDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .provider(user.getProvider())
                .categories(
                        user.getCategories() == null ? null :
                                user.getCategories()
                                        .stream()
                                        .map(Category::getName)
                                        .collect(Collectors.toSet())
                )
                .build();
    }

}
