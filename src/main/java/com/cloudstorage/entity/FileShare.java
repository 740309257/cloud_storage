package com.cloudstorage.entity;

/**
 * Created by dell on 1/23/2017.
 */
public class FileShare extends BaseEntity{
	private long userId;
	private long targetId;
	private long fileId;
	private int isValid;

	public long getUserId(){
		return userId;
	}

	public void setUserId(long userId){
		this.userId = userId;
	}

	public long getTargetId(){
		return targetId;
	}

	public void setTargetId(long targetId){
		this.targetId = targetId;
	}

	public long getFileId(){
		return fileId;
	}

	public void setFileId(long fileId){
		this.fileId = fileId;
	}

	public int getIsValid(){
		return isValid;
	}

	public void setIsValid(int isValid){
		this.isValid = isValid;
	}
}
