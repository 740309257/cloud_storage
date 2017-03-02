package com.cloud_storage.service_inter;

import com.cloud_storage.entity.File;
import com.cloud_storage.entity.User;

import java.util.List;

/**
 * Created by dell on 1/23/2017.
 */
public interface user_service_inter {
    public Boolean username_exist(String username);
    public Boolean save_user(User u);
    public Boolean verify_password(String username,String password);
    public int get_user_id_by_name(String username);
    public List<User> search_users(String username);
    public List<File> search_files(String filename);
    public User getUserByID(int id);
}
