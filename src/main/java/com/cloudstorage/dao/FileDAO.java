package com.cloudstorage.dao;

import com.cloudstorage.entity.File;
import com.cloudstorage.entity.FileShare;
import com.cloudstorage.entity.User;
import com.cloudstorage.entity.UserFile;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by dell on 1/26/2017.
 */
@Repository
public interface FileDAO {
    public File selectById(int id);
    public List<UserFile> selectAllByUserId(User u);
    public List<File> selectPublicFilesByUser(User u);
    public int insert_file_share(FileShare file_share);
    public List<FileShare> select_file_share(int target_id);
    public int update_share_states_to_0(FileShare file_share);
    public int insert_file(File file);
    public int insert_user_file(UserFile user_file);
    public int update_file_auth(@Param("File_id")int file_id,@Param("User_id")int id, @Param("Auth")int auth);
    public int update_file_name(@Param("File_id")int file_id,@Param("User_id")int id,@Param("New_name")String new_name);
    public int delete_user_file(@Param("File_id") int file_id,@Param("User_id") int id);
    public int delete_file(int file_id);
    public int add_file_nums(int file_id);
    public int minus_file_nums(int file_id);
    public int select_file_nums(int file_id);
}
