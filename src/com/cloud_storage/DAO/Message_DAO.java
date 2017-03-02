package com.cloud_storage.DAO;

import com.cloud_storage.entity.Comment;
import com.cloud_storage.entity.Message;
import com.cloud_storage.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dell on 1/24/2017.
 */
@Repository
public interface Message_DAO {
    public List<Message> selectMessageByUser(User u);
    public List<Message> selectZoneMessageById(int user_id);
    public int insert_message(Message message);
    public int insert_comment(Comment comment);
    public List<Comment> selectComment(int message_id);
    public int update_comment_num(int message_id);
}
