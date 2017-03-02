package com.cloud_storage.service_inter;

import com.cloud_storage.entity.Friend_apply;
import com.cloud_storage.entity.User;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dell on 1/24/2017.
 */
public interface friend_service_inter {
    public List<User> getFriendsByUser(User u);
    public Boolean apply_friend(int applier_id,int target_id,int is_valid,String date);
    public Boolean is_friend(int applier_id,int target_id);
    public List<Friend_apply> get_apply(int target_id);
    public List<HashMap> get_apply_info(int target_id);
    public Boolean change_apply_states_0(int applier_id,int target_id,int is_valid,String date);
    public Boolean add_friend(int user_id1,int user_id2);
}

