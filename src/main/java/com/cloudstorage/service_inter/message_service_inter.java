package com.cloudstorage.service_inter;

import com.cloudstorage.entity.Comment;
import com.cloudstorage.entity.Post;
import com.cloudstorage.entity.User;

import java.util.List;

/**
 * Created by dell on 1/24/2017.
 */
public interface message_service_inter {
    public List<Post> getMessageByUser(User u);
    public List<Post> getZoneMessageById(int id);
    public Boolean save_message(Post post);
    public Boolean save_comment(Comment comment);
    public List<Comment> getComment(int message_id);
    public Boolean Comment_num_plus(int message_id);
}
