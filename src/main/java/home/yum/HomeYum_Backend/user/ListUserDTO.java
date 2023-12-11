package home.yum.HomeYum_Backend.user;

public record ListUserDTO(
        long id,
        String name,
        String email,
        String password
) {
    public ListUserDTO(User user) {
        this(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword()
        );
    }
}
