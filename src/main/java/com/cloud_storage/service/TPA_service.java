package com.cloud_storage.service;

import com.cloud_storage.DAO.TPA_DAO;
import com.cloud_storage.service_inter.TPA_service_inter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dell on 3/9/2017.
 */
@Service
public class TPA_service implements TPA_service_inter {
    @Autowired
    private TPA_DAO tpa_dao;

    @Override
    public Boolean validate_token(String token) {
        return tpa_dao.selectToken(token)==1;
    }
}
