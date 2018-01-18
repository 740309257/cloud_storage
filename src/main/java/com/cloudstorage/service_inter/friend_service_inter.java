package com.cloudstorage.service_inter;

import com.cloudstorage.entity.FriendApply;
import com.cloudstorage.entity.User;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dell on 1/24/2017.
 */
public interface friend_service_inter {
    public List<User> getFriendsByUser(User u);
    public Boolean apply_friend(FriendApply friend_apply);
    public Boolean is_friend(int applier_id,int target_id);
    public Boolean have_applied(FriendApply friend_apply);
    public List<FriendApply> get_apply(int target_id);
    public List<HashMap> get_apply_info(int target_id);
    public Boolean change_apply_states_0(FriendApply friend_apply);
    public Boolean add_friend(int id1,int id2);
}

