package org.justintruesell.citizendash.services;
import org.justintruesell.citizendash.models.Role;

import java.util.List;
public interface RoleService {
    public void saveRole(Role role);
    public Role findRoleByRoleName(String name);
    public List<Role> getAllRoles();
    public List<Role> getRolesByUser(long id);
}
