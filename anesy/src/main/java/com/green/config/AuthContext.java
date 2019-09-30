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
		this.isAuthenticated = true;
	}
	
	public void clear() {
		this.isAuthenticated = false;
		this.account = new Account();
		this.profile = new Profile();
	}
	
	public Account getAccount() {
		return account;
	}
	
	public Profile getProfile() {
		return profile;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public void setProfile(Profile profile) {
		this.profile = profile;
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
		return profile.getEmail();
	}

	public String getFullName() {
		return profile.getFullName();
	}


}
