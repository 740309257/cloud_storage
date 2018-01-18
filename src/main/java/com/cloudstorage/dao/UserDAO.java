package com.cloudstorage.DAO;

import com.cloudstorage.entity.File;
import com.cloudstorage.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dell on 12/17/2016.
 */
@Repository
public interface User_DAO {
    public User selectUserByID(int id);
    public List<User> selectUsers(String username);
    public List<File> selectFiles(String filename);
    public int addUser(User user);
    public int updateUser(User user);
    public int deleteUser(int id);
    public int select_user_num(String username);
    public String get_password(String username);
    public int get_id_by_name(String username);
    public int updatePicPath(@Param("id") int id, @Param("Path") String path);
}
