package com.cloudstorage.service;

import com.cloudstorage.dao.TPADAO;
import com.cloudstorage.service_inter.TPA_service_inter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dell on 3/9/2017.
 */
@Service
public class TPA_service implements TPA_service_inter {
    @Autowired
    private TPADAO TPADAO;

    @Override
    public Boolean validate_token(String token) {
        return TPADAO.selectToken(token)==1;
    }
}
