package com.cloudstorage.dao;

import com.cloudstorage.entity.Comment;
import com.cloudstorage.entity.Post;
import com.cloudstorage.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dell on 1/24/2017.
 */
@Repository
public interface PostDAO {
    public List<Post> selectMessageByUser(User u);
    public List<Post> selectZoneMessageById(int id);
    public int insert_message(Post post);
    public int insert_comment(Comment comment);
    public List<Comment> selectComment(int message_id);
    public int update_comment_num(int message_id);
}
