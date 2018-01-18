package com.cloudstorage.service;


import com.cloudstorage.entity.File;
import com.cloudstorage.entity.User;
import com.cloudstorage.dao.UserDAO;
import com.cloudstorage.service_inter.user_service_inter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 1/23/2017.
 */
@Service
public class UserService implements user_service_inter {
    @Autowired
    private UserDAO user_dao;

    public Boolean username_exist(String username){
        int user_num=user_dao.select_user_num(username);
        return !(user_num==0);
    }

    public Boolean save_user(User u){
        int user_num=user_dao.select_user_num(u.getUsername());
        if(user_num==0){
            int add_result=user_dao.addUser(u);
            if(add_result==1){
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    public Boolean verify_password(String username,String password){
        String correct_password=user_dao.get_password(username);
        if(password.equals(correct_password)){
            return true;
        }
        else {
            return false;
        }
    }

    public int get_id_by_name(String username){
        return user_dao.get_id_by_name(username);
    }

    public List<User> search_users(String username){
        return user_dao.selectUsers(username);
    }
    public List<File> search_files(String filename){
        return user_dao.selectFiles(filename);
    }
    public User getUserByID(int id){return user_dao.selectUserByID(id);}
    public Boolean setPicPath(int id,String path){return user_dao.updatePicPath(id, path)==1;}
}
