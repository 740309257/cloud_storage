package com.cloud_storage.DAO;

import com.cloud_storage.entity.File;
import com.cloud_storage.entity.File_share;
import com.cloud_storage.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dell on 1/26/2017.
 */
@Repository
public interface File_DAO {
    public File selectFileById(int file_id);
    public List<File> selectAllFilesByUser(User u);
    public List<File> selectPublicFilesByUser(User u);
    public int insert_file_share(File_share file_share);
    public List<File_share> select_file_share(int target_id);
    public int update_share_states_to_0(File_share file_share);
    public int insert_file(File file);
    public int update_file_auth(@Param("File_id")int file_id, @Param("Auth")int auth);
    public int update_file_name(@Param("File_id")int file_id,@Param("New_name")String new_name);
    public int delete_file(int file_id);
}
