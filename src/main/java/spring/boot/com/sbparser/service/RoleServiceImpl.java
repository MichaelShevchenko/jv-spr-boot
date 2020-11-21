package spring.boot.com.sbparser.service;

import spring.boot.com.sbparser.model.Role;
import spring.boot.com.sbparser.repository.RoleRepository;

public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role add(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getByRoleName(String roleName) {
        return roleRepository.getByRoleName(Role.of(roleName).getRoleName());
    }
}
