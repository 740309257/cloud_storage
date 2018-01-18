package com.cloudstorage.DAO;

import org.springframework.stereotype.Repository;

/**
 * Created by dell on 3/9/2017.
 */
@Repository
public interface TPA_DAO {
    public int selectToken(String token);
}
