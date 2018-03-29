package com.cloudstorage.dao;

import com.cloudstorage.entity.UserFile;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: Ironman
 * @Description:
 * @Date: Created in 18:04 2017/12/31 0031
 **/
public interface UserFileDAO {
	public UserFile selectUserFileById(@Param("fileId")int fileId, @Param("userId")int UserId);
}
