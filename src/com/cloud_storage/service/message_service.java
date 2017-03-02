package com.cloud_storage.service;

import com.cloud_storage.DAO.Message_DAO;
import com.cloud_storage.entity.Comment;
import com.cloud_storage.entity.Message;
import com.cloud_storage.entity.User;
import com.cloud_storage.service_inter.message_service_inter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 1/24/2017.
 */
@Service
public class message_service implements message_service_inter {
    @Autowired
    private Message_DAO message_dao;

    public List<Message> getMessageByUser(User u){
       return message_dao.selectMessageByUser(u);
    }
    public List<Message> getZoneMessageById(int user_id){
        return message_dao.selectZoneMessageById(user_id);
    }
    public Boolean save_message(Message message){
        int result=message_dao.insert_message(message);
        if(result==1){
            return true;
        }
        else {
            return false;
        }
    }
    public Boolean save_comment(Comment comment){
        int result=message_dao.insert_comment(comment);
        if(result==1){
            return true;
        }
        else {
            return false;
        }
    }
    public List<Comment> getComment(int message_id){
        return message_dao.selectComment(message_id);
    }
    public Boolean Comment_num_plus(int message_id){
        int result=message_dao.update_comment_num(message_id);
        if(result==1){
            return true;
        }
        else {
            return false;
        }
    }
}
