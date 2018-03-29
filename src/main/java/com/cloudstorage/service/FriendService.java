package com.cloudstorage.service;

import com.cloudstorage.dao.FriendDAO;
import com.cloudstorage.dao.UserDAO;
import com.cloudstorage.entity.FriendApply;
import com.cloudstorage.entity.User;
import com.cloudstorage.service_inter.friend_service_inter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dell on 1/24/2017.
 */
@Service
public class FriendService implements friend_service_inter {
    @Autowired
    private FriendDAO friend_dao;
    @Autowired
    private UserDAO user_dao;

    public List<User> getFriendsByUser(User u){
        int item_id;
        User user;
        List<User> users=new ArrayList<User>();
        List<Integer> friends_id=friend_dao.selectFriendsByUser(u);
        for(int i=0;i<friends_id.size();i++){
            item_id=friends_id.get(i);
            user=user_dao.selectUserByID(item_id);
            if(user!=null){
                users.add(user);
            }
        }
        return users;
    }

    public Boolean have_applied(FriendApply friend_apply){
        return friend_dao.select_same_apply(friend_apply)==1;
    }


    public Boolean apply_friend(FriendApply friend_apply){
        if(is_friend(friend_apply.getApplier_id(),friend_apply.getTarget_id())){
            return false;
        }
        if (have_applied(friend_apply)){
            return false;
        }

        int result=friend_dao.insert_Friend_apply(friend_apply);
        if(result==1){
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean is_friend(int applier_id,int target_id){ return friend_dao.select_friend(applier_id,target_id)==1;}

    public List<FriendApply> get_apply(int target_id){
        return friend_dao.select_Friend_apply(target_id);
    }

    public List<HashMap> get_apply_info(int target_id){
        List<FriendApply> l_apply=get_apply(target_id);
        List<HashMap> apply_info=new ArrayList<>();
        User u;
        for(int i=0;i<l_apply.size();i++){
            u=user_dao.selectUserByID(l_apply.get(i).getApplier_id());
            HashMap<String,Object> hashMap=new HashMap<>();
            hashMap.put("id",u.getId());
            hashMap.put("username",u.getUsername());
            hashMap.put("date",l_apply.get(i).getDate().toString());
            apply_info.add(hashMap);
        }
        return apply_info;
    }
    public Boolean change_apply_states_0(FriendApply friend_apply){
        int result=friend_dao.update_friend_apply_to_0(friend_apply);
        if(result==1){
            return true;
        }
        else {
            return false;
        }
    }


    public Boolean add_friend(int id1,int id2){
        int result=friend_dao.insert_Friends(id1,id2);
        if(result==1){
            return true;
        }
        else {
            return false;
        }
    }
}
