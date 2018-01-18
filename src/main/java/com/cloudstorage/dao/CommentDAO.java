package com.cloudstorage.dao;

import com.cloudstorage.entity.Comment;
import org.springframework.stereotype.Repository;

/**
 * @Author: Ironman
 * @Description:
 * @Date: Created in 18:20 2017/12/31 0031
 **/
@Repository
public interface CommentDAO {
	void save(Comment comment);

	void update(Comment comment);

	void delete(Long id);

	void selectAll();
}
