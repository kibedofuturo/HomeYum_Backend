package home.yum.HomeYum_Backend.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IuserService {
    User findById(Long userId);

    Page<ListUserDTO> findAllUsers(Pageable pagination);

    void saveUser(UserDTO data);

    void updateUser(UpdateUserDTO data);

    void deleteUser(Long userId);
}
