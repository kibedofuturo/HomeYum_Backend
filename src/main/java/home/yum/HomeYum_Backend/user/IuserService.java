package home.yum.HomeYum_Backend.user;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IuserService {
    User findById(Long userId);

    List<User> findAllUsers();

    void saveUser(User user);

    void updateUser(User user);

    ResponseEntity<String> updateUserAdapted(Long userId, Map<String, Object> updates);

    void deleteUser(String userId);

    void deleteUser(Long userId);
}
