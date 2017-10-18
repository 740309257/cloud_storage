package com.cloud_storage.service;

import com.cloud_storage.DAO.File_DAO;
import com.cloud_storage.DAO.User_DAO;
import com.cloud_storage.entity.File;
import com.cloud_storage.entity.File_share;
import com.cloud_storage.entity.User;
import com.cloud_storage.entity.User_File;
import com.cloud_storage.service_inter.file_service_inter;
import com.cloud_storage.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dell on 1/26/2017.
 */
@Service
public class FileService implements file_service_inter {
    @Autowired
    File_DAO file_dao;
    @Autowired
    User_DAO user_dao;

    public List<User_File> getAllFilesByUser(User u){
        List<User_File> files=file_dao.selectAllFilesByUser(u);
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

    public HashMap getFileDetailById(int file_id,int user_id){
        return file_dao.selectFileDetailById(file_id,user_id);
    }
    public File getFileById(int file_id){return file_dao.selectFileById(file_id);}
    public User_File getUser_FileById(int file_id,int user_id){return file_dao.selectUser_FileById(file_id,user_id);}


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
    public Boolean add_user_file(User_File user_file){return file_dao.insert_user_file(user_file)==1;}
    public Boolean add_file_nums(int file_id){return file_dao.add_file_nums(file_id)==1;}
    public Boolean change_file_auth(int file_id,int user_id,int auth){
        return file_dao.update_file_auth(file_id,user_id,auth)==1;
    }
    public Boolean rename_file(int file_id,int user_id,String new_name){
        return file_dao.update_file_name(file_id,user_id,new_name)==1;
    }
    public Boolean delete_user_file(int file_id,int user_id){
        return file_dao.delete_user_file(file_id,user_id)==1;
    }
    public Boolean save_file(int file_id,int user_id){

        User_File user_file=file_dao.selectUser_FileById(file_id,user_id);
        if(user_file!=null) {
            user_file.setUser_id(user_id);
            user_file.setAuthority(1);
            user_file.setDate(new Date().toString());


            if (add_user_file(user_file)) {
                if (add_file_nums(user_file.getFile_id())) {
                    return true;
                }
            }
        }
        return false;
    }
    public Boolean delete_entry(int file_id,int user_id){
        if(delete_user_file(file_id,user_id)){
            int file_nums=file_dao.select_file_nums(file_id);
            if(file_nums==1){
                String path="";
                File file=file_dao.selectFileById(file_id);
                if(file!=null){
                    path=file.getFile_path();
                    if(file_dao.delete_file(file_id)==1){
                        try {
                            java.io.File file1=new java.io.File(path);
                            if(file1.exists()){
                                file1.delete();
                            }
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                        finally {
                            return true;
                        }
                    }
                }
            }
            else {
                if(file_dao.minus_file_nums(file_id)==1){
                    return true;
                }
            }
        }

       return false;

    }




}
