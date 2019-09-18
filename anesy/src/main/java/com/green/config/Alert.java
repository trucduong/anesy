package com.green.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Alert {
	private List<String> messages = new ArrayList<>();
	private List<MsgType> types = new ArrayList<>();

	public void addMessage(String msg) {
		addMessage(msg, MsgType.info);
	}
	
	public void addMessage(String msg, MsgType type) {
		messages.add(msg);
		types.add(type);
	}
	
	public List<String> getMessages() {
		return messages;
	}
	
	public List<MsgType> getTypes() {
		return types;
	}
	
	public void clear() {
		messages.clear();
		types.clear();
	}
}
