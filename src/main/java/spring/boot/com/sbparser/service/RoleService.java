package spring.boot.com.sbparser.service;

import spring.boot.com.sbparser.model.Role;

public interface RoleService {
    Role add(Role role);

    Role getByRoleName(String roleName);
}
