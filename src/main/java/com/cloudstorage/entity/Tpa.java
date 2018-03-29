package com.cloudstorage.entity;

/**
 * Created by dell on 1/23/2017.
 */
public class Tpa extends BaseEntity{
	private String token;
	private String description;

	public String getToken(){
		return token;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getDescription(){
		return description;
	}

	public void setDescription(String description){
		this.description = description;
	}
}
