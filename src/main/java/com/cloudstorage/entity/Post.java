package com.cloudstorage.entity;

/**
 * Created by dell on 1/23/2017.
 */
public class Message extends BaseEntity{
	private long userId;
	private String text;
	private int likes;

	public long getUserId(){
		return userId;
	}

	public void setUserId(long userId){
		this.userId = userId;
	}

	public String getText(){
		return text;
	}

	public void setText(String text){
		this.text = text;
	}

	public int getLikes(){
		return likes;
	}

	public void setLikes(int likes){
		this.likes = likes;
	}
}
