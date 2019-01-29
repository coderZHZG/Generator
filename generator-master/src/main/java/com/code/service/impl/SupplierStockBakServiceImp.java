package com.code.service.impl;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.code.dao.SupplierStockBakDao;
import com.code.service.SupplierStockBakService;
import com.code.entity.SupplierStockBak;

import java.util.HashMap;
import java.util.List;

/**
* Author zzg
* Date  2019-01-12
*/
@Service("supplierStockBakService")
@Transactional
public class SupplierStockBakServiceImp implements SupplierStockBakService {

    @Autowired
    private SupplierStockBakDao supplierStockBakDao;

    @Override
    public int insertSelective(SupplierStockBak supplierStockBak) {
    return supplierStockBakDao.insertSelective(supplierStockBak);
    }

    @Override
    public int insertSelectiveBatch(List<SupplierStockBak> supplierStockBaks){
    return supplierStockBakDao.insertSelectiveBatch(supplierStockBaks);
    }

    @Override
    public List<SupplierStockBak> findList(HashMap<String, Object> param) {
    return supplierStockBakDao.findList(param);
    }

    @Override
    public int findListCount(HashMap<String, Object> param) {
    return supplierStockBakDao.findListCount(param);
    }

    @Override
    public SupplierStockBak findById(Integer id){
        return supplierStockBakDao.findById(id);
    }

    @Override
    public int updateSelective(SupplierStockBak supplierStockBak) {
        return supplierStockBakDao.updateSelective(supplierStockBak);
    }

    @Override
    public int delete(SupplierStockBak supplierStockBak) {
        return supplierStockBakDao.delete(supplierStockBak);
    }

}
