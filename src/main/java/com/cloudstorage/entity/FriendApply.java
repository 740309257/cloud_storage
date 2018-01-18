package com.cloudstorage.entity;

/**
 * Created by dell on 1/23/2017.
 */
public class Friend_apply {
	private long applierId;
	private long targetId;
	private int isValid;

	public long getApplierId(){
		return applierId;
	}

	public void setApplierId(long applierId){
		this.applierId = applierId;
	}

	public long getTargetId(){
		return targetId;
	}

	public void setTargetId(long targetId){
		this.targetId = targetId;
	}

	public int getIsValid(){
		return isValid;
	}

	public void setIsValid(int isValid){
		this.isValid = isValid;
	}
}
