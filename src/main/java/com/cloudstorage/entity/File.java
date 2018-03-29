package com.cloudstorage.entity;

/**
 * Created by dell on 1/23/2017.
 */
public class File extends BaseEntity {
	private String uniqueId;
	private long providerId;
	private String originName;
	private String path;
	private long size;
	private int type;

	public long getProviderId(){
		return providerId;
	}

	public void setProviderId(long providerId){
		this.providerId = providerId;
	}

	public String getOriginName(){
		return originName;
	}

	public void setOriginName(String originName){
		this.originName = originName;
	}

	public String getPath(){
		return path;
	}

	public void setPath(String path){
		this.path = path;
	}

	public String getUniqueId(){
		return uniqueId;
	}

	public void setUniqueId(String uniqueId){
		this.uniqueId = uniqueId;
	}

	public long getSize(){
		return size;
	}

	public void setSize(long size){
		this.size = size;
	}

	public int getType(){
		return type;
	}

	public void setType(int type){
		this.type = type;
	}

	enum Type {
		AUDIO(1),
		VIDEO(2),
		TEXT(3),
		EXE(4),
		MIRROR(5),
		ZIP(6),
		PDF(7),
		OTHERS(8);
		private int id;

		Type(int id){
			this.id = id;
		}

		public int getId(){
			return id;
		}
	}
}
