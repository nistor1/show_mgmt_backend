package ro.ps.showmgmtbackend.dto.user;

import lombok.*;
import ro.ps.showmgmtbackend.model.Role;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {
    private UUID userId;
    private String name;
    private Role role;
    private Integer age;
    private String email;
}
