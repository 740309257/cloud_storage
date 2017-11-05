package com.cloud_storage.DAO;

import com.cloud_storage.entity.File;
import com.cloud_storage.entity.File_share;
import com.cloud_storage.entity.User;
import com.cloud_storage.entity.User_File;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by dell on 1/26/2017.
 */
@Repository
public interface File_DAO {
    public HashMap selectFileDetailById(@Param("File_id")int file_id,@Param("User_id")int user_id);
    public File selectFileById(int file_id);
    public User_File selectUser_FileById(@Param("File_id")int file_id,@Param("User_id")int user_id);
    public List<User_File> selectAllFilesByUser(User u);
    public List<File> selectPublicFilesByUser(User u);
    public int insert_file_share(File_share file_share);
    public List<File_share> select_file_share(int target_id);
    public int update_share_states_to_0(File_share file_share);
    public int insert_file(File file);
    public int insert_user_file(User_File user_file);
    public int update_file_auth(@Param("File_id")int file_id,@Param("User_id")int user_id, @Param("Auth")int auth);
    public int update_file_name(@Param("File_id")int file_id,@Param("User_id")int user_id,@Param("New_name")String new_name);
    public int delete_user_file(@Param("File_id") int file_id,@Param("User_id") int user_id);
    public int delete_file(int file_id);
    public int add_file_nums(int file_id);
    public int minus_file_nums(int file_id);
    public int select_file_nums(int file_id);

    }
