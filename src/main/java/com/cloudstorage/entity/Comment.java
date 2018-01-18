package com.cloudstorage.entity;

/**
 * Created by dell on 1/23/2017.
 */
public class Comment extends BaseEntity {

	private long postId;
	private long userId;
	private String text;
	private int likes;
	private boolean deleted;

	public long getPostId(){
		return postId;
	}

	public void setPostId(long postId){
		this.postId = postId;
	}

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

	public boolean isDeleted(){
		return deleted;
	}

	public void setDeleted(boolean deleted){
		this.deleted = deleted;
	}
}
