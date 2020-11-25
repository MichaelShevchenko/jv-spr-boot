package spring.boot.com.sbparser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.boot.com.sbparser.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role getByRoleName(Role.RoleName roleName);
}
