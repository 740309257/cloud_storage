package com.cloudstorage.service;

import com.cloudstorage.dao.PostDAO;
import com.cloudstorage.entity.Comment;
import com.cloudstorage.entity.Post;
import com.cloudstorage.entity.User;
import com.cloudstorage.service_inter.message_service_inter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 1/24/2017.
 */
@Service
public class MessageService implements message_service_inter {
    @Autowired
    private PostDAO message_dao;

    public List<Post> getMessageByUser(User u){
       return message_dao.selectMessageByUser(u);
    }
    public List<Post> getZoneMessageById(int id){
        return message_dao.selectZoneMessageById(id);
    }
    public Boolean save_message(Post post){
        int result=message_dao.insert_message(post);
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
