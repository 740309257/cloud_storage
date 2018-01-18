package com.cloudstorage.entity;

import java.util.Date;

/**
 * @Author: Ironman
 * @Description:
 * @Date: Created in 16:15 2017/12/31 0031
 **/
public class CloudEntity {
	private long id;
	private Date create_time;

	public long getId(){
		return id;
	}

	public void setId(long id){
		this.id = id;
	}

	public Date getCreate_time(){
		return create_time;
	}

	public void setCreate_time(Date create_time){
		this.create_time = create_time;
	}
}
