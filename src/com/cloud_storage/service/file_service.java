package com.cloud_storage.service;

import com.cloud_storage.DAO.File_DAO;
import com.cloud_storage.DAO.User_DAO;
import com.cloud_storage.entity.File;
import com.cloud_storage.entity.File_share;
import com.cloud_storage.entity.User;
import com.cloud_storage.service_inter.file_service_inter;
import com.cloud_storage.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dell on 1/26/2017.
 */
@Service
public class file_service implements file_service_inter {
    @Autowired
    File_DAO file_dao;
    @Autowired
    User_DAO user_dao;

    public List<File> getAllFilesByUser(User u){
        List<File> files=file_dao.selectAllFilesByUser(u);
        return files;
    }
    public List<File> getPublicFilesByUser(User u){
        List<File> files=file_dao.selectPublicFilesByUser(u);
        return files;
    }
    public Boolean share_file(File_share file_share){
        int result=file_dao.insert_file_share(file_share);
        return result==1;
    }

    public List<File_share> get_share(int target_id){
        return file_dao.select_file_share(target_id);
    }

    public File getFileById(int file_id){
        return file_dao.selectFileById(file_id);
    }

    public List<HashMap> get_share_info(int target_id){
        List<File_share> file_shares=get_share(target_id);
        List<HashMap> share_info=new ArrayList<>();
        User u;
        File f;
        for(int i=0;i<file_shares.size();i++){
            u=user_dao.selectUserByID(file_shares.get(i).getUser_id());
            f=file_dao.selectFileById(file_shares.get(i).getFile_id());
            HashMap<String,Object> hashMap=new HashMap();
            hashMap.put("user_id",u.getUser_id());
            hashMap.put("username",u.getUsername());
            hashMap.put("file_id",f.getFile_id());
            hashMap.put("filename",f.getFilename());
            hashMap.put("date",file_shares.get(i).getDate().toString());
            share_info.add(hashMap);
        }
        return share_info;
    }

    public Boolean change_share_states_0(File_share file_share){
        return file_dao.update_share_states_to_0(file_share)==1;
    }
    public Boolean add_file(File file){
        return file_dao.insert_file(file)==1;
    }
    public Boolean change_file_auth(int file_id,int auth){
        return file_dao.update_file_auth(file_id,auth)==1;
    }
    public Boolean rename_file(int file_id,String new_name){
        return file_dao.update_file_name(file_id,new_name)==1;
    }
    public Boolean delete_file(int file_id){
        return file_dao.delete_file(file_id)==1;
    }



    public String generate_file_path(String user_id,String file_name){
        String base_path=Properties.file_path;
        String path=base_path+user_id+"_"+file_name;
        return path;
    }

    public String generate_profile_path(String user_id,String file_name){
        String base_path=Properties.user_pic_path;
        String path=base_path+user_id+"_"+file_name;
        return path;
    }
}
