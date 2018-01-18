package com.cloudstorage.DAO;

import com.cloudstorage.entity.FriendApply;
import com.cloudstorage.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dell on 1/24/2017.
 */
@Repository
public interface Friend_DAO {
    public List<Integer> selectFriendsByUser(User u);
    public int insert_Friend_apply(FriendApply friend_apply);
    public List<FriendApply> select_Friend_apply(int target_id);
    public int select_same_apply(FriendApply friend_apply);
    public int select_friend(@Param("User_id1") int id1,@Param("User_id2") int id2);
    public int update_friend_apply_to_0(FriendApply friend_apply);
    public int insert_Friends(@Param("User_id1")int User_id1,@Param("User_id2")int User_id2);
}
