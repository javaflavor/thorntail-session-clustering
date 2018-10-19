package com.redhat.example.rs;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class Counter implements Serializable {
	private static final long serialVersionUID = 1L;
	
	int count;
	
	public int increment() {
		return ++count;
	}

}
