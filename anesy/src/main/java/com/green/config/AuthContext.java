package com.green.config;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.green.entity.Account;
import com.green.entity.Profile;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AuthContext {
	private boolean isAuthenticated;
	
	private Account account = new Account();
	private Profile profile = new Profile();

	public void setContext(Account account, Profile profile) {
		this.account = account;
		this.profile = profile;
		isAuthenticated = true;
	}
	
	public void clearContext() {
		this.account = new Account();
		this.profile = new Profile();
		isAuthenticated = false;
	}
	
	
	public Account getAccount() {
		return account;
	}
	
	public int getUserType() {
		return profile.getUserType();
	}


	public boolean isAuthenticated() {
		return isAuthenticated;
	}
	
	public Integer getAccountId() {
		return account.getId();
	}

	public String getEmail() {
		return account.getEmail();
	}
	
	public String getFullName() {
		return profile.getFullName();
	}

	public Profile getProfile() {
		return profile;
	}
	
	public String getAvatar() {
		return profile.getAvatar();
	}
	
}
