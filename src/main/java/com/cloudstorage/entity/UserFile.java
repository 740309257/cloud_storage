package com.cloudstorage.entity;

/**
 * Created by dell on 3/24/2017.
 */
public class UserFile extends BaseEntity{
	private long userId;
	private long fileId;
	private String filename;
	private int authority;//0-->public 1-->private

	public long getUserId(){
		return userId;
	}

	public void setUserId(long userId){
		this.userId = userId;
	}

	public long getFileId(){
		return fileId;
	}

	public void setFileId(long fileId){
		this.fileId = fileId;
	}

	public String getFilename(){
		return filename;
	}

	public void setFilename(String filename){
		this.filename = filename;
	}

	public int getAuthority(){
		return authority;
	}

	public void setAuthority(int authority){
		this.authority = authority;
	}
}
