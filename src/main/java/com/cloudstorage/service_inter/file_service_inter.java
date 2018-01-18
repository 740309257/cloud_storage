package com.cloud_storage.service_inter;

import com.cloud_storage.entity.*;

import java.util.HashMap;
import java.util.List;

/**
 * Created by dell on 1/26/2017.
 */
public interface file_service_inter {
    public List<User_File> getAllFilesByUser(User u);
    public List<File> getPublicFilesByUser(User u);
    public File getFileById(int file_id);
    public User_File getUser_FileById(int file_id,int user_id);
    public HashMap getFileDetailById(int file_id,int user_id);
    public Boolean share_file(File_share file_share);
    public List<File_share> get_share(int target_id);
    public Boolean change_share_states_0(File_share file_share);
    public Boolean add_file(File file);
    public Boolean add_user_file(User_File user_file);
    public Boolean add_file_nums(int file_id);
    public Boolean change_file_auth(int file_id,int user_id,int auth);
    public List<HashMap> get_share_info(int target_id);
    public Boolean rename_file(int file_id,int user_id,String new_name);
    public Boolean save_file(int file_id,int user_id);
    public Boolean delete_entry(int file_id,int user_id);
    public Boolean delete_user_file(int file_id,int user_id);

}
