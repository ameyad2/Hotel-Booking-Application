package com.adprojects.hotel_lakeSide.services;

import com.adprojects.hotel_lakeSide.models.Role;
import com.adprojects.hotel_lakeSide.models.User;

import java.util.List;

/**
 * @author Ameya Deshmukh
 */

public interface IRoleService {

    List<Role> getRoles();
    Role createRole(Role theRole);

    void deleteRole(Long id);
    Role findByName(String name);

    User removeUserFromRole(Long userId, Long roleId);
    User assignRoleToUser(Long userId, Long roleId);
    Role removeAllUsersFromRole(Long roleId);
}