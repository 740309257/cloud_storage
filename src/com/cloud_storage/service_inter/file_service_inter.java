package com.cloud_storage.service_inter;

import com.cloud_storage.entity.File;
import com.cloud_storage.entity.File_share;
import com.cloud_storage.entity.Friend_apply;
import com.cloud_storage.entity.User;

import java.util.HashMap;
import java.util.List;

/**
 * Created by dell on 1/26/2017.
 */
public interface file_service_inter {
    public List<File> getAllFilesByUser(User u);
    public List<File> getPublicFilesByUser(User u);
    public File getFileById(int file_id);
    public Boolean share_file(File_share file_share);
    public List<File_share> get_share(int target_id);
    public Boolean change_share_states_0(File_share file_share);
    public Boolean add_file(File file);
    public Boolean change_file_auth(int file_id,int auth);
    public List<HashMap> get_share_info(int target_id);
    public String generate_file_path(String user_id,String file_name);
    public Boolean rename_file(int file_id,String new_name);
    public Boolean delete_file(int file_id);

}
