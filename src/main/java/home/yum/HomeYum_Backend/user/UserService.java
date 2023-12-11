package home.yum.HomeYum_Backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IuserService{

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Page<ListUserDTO> findAllUsers(Pageable pagination) {
        return userRepository.findAllByActiveTrue(pagination).map(ListUserDTO::new);
    }

    @Override
    public User findById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public void saveUser(UserDTO data) {
        userRepository.save(new User(data));
    }

    @Override
    public void updateUser(UpdateUserDTO data) {
        var user = userRepository.getReferenceById(data.id());
        user.UpdateInfo(data);
    }

    @Override
    public void deleteUser(Long userId) {
        var user = userRepository.getReferenceById(userId);
        user.delete();
    }
}