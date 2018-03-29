package com.cloudstorage.service_inter;

import com.cloudstorage.entity.*;

import java.util.HashMap;
import java.util.List;

/**
 * Created by dell on 1/26/2017.
 */
public interface file_service_inter {
    public List<UserFile> getAllFilesByUser(User u);
    public List<File> getPublicFilesByUser(User u);
    public File getFileById(int file_id);
    public UserFile getUser_FileById(int file_id, int id);
    public HashMap getFileDetailById(int file_id,int id);
    public Boolean share_file(FileShare file_share);
    public List<FileShare> get_share(int target_id);
    public Boolean change_share_states_0(FileShare file_share);
    public Boolean add_file(File file);
    public Boolean add_user_file(UserFile user_file);
    public Boolean add_file_nums(int file_id);
    public Boolean change_file_auth(int file_id,int id,int auth);
    public List<HashMap> get_share_info(int target_id);
    public Boolean rename_file(int file_id,int id,String new_name);
    public Boolean save_file(int file_id,int id);
    public Boolean delete_entry(int file_id,int id);
    public Boolean delete_user_file(int file_id,int id);

}
