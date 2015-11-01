package com.hust.htd.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hust.htd.config.AuthenticatedUser;
import com.hust.htd.persistence.mapper.RoleMapper;
import com.hust.htd.persistence.mapper.UserMapper;
import com.hust.htd.persistence.model.Role;
import com.hust.htd.persistence.model.RoleExample;
import com.hust.htd.persistence.model.User;
import com.hust.htd.persistence.model.UserExample;

/**
 * @author HuyTaDuc
 *
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private RoleMapper roleMapper;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			UserExample userExample = new UserExample();
			userExample.setDistinct(true);
			userExample.createCriteria().andUsernameEqualTo(username);
			User user = userMapper.selectByExample(userExample).get(0);
			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

			RoleExample roleExample = new RoleExample();
			roleExample.createCriteria().andRoleIdGreaterThanOrEqualTo(user.getRoleId());
			List<Role> roles = roleMapper.selectByExample(roleExample);
			for (Role role : roles) {
				authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
			}

			AuthenticatedUser authenticatedUser = new AuthenticatedUser(user, authorities);
			return authenticatedUser;
		} catch (Exception e) {
			throw new UsernameNotFoundException("User not found");
		}
	}

}
