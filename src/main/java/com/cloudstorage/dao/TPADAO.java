package com.cloudstorage.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by dell on 3/9/2017.
 */
@Repository
public interface TPADAO {
    public int selectToken(String token);
}
