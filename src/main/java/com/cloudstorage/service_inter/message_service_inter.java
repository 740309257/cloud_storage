package com.cloud_storage.service_inter;

import com.cloud_storage.entity.Comment;
import com.cloud_storage.entity.Message;
import com.cloud_storage.entity.User;

import java.util.List;

/**
 * Created by dell on 1/24/2017.
 */
public interface message_service_inter {
    public List<Message> getMessageByUser(User u);
    public List<Message> getZoneMessageById(int user_id);
    public Boolean save_message(Message message);
    public Boolean save_comment(Comment comment);
    public List<Comment> getComment(int message_id);
    public Boolean Comment_num_plus(int message_id);
}
