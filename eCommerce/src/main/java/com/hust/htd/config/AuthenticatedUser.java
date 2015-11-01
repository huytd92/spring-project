package com.hust.htd.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.hust.htd.persistence.model.User;

public class AuthenticatedUser extends org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = -8458612268213490250L;

	private Long roleId;
	private String displayName;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public AuthenticatedUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}

	public AuthenticatedUser(User user, Collection<? extends GrantedAuthority> authorities) {
		super(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
		this.setRoleId(user.getRoleId());
		this.setDisplayName(user.getUserDisplayName());
	}
}
