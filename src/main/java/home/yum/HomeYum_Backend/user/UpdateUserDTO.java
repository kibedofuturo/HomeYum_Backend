package home.yum.HomeYum_Backend.user;

import jakarta.validation.constraints.NotNull;

public record UpdateUserDTO(
        @NotNull
        long id,
        String name,      String email,
        String password
) {

}
