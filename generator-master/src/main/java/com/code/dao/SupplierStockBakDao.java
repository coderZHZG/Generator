package com.code.dao;

import com.code.entity.SupplierStockBak;

import java.util.HashMap;
import java.util.List;

/**
* Author zzg
* Date  2019-01-12
*/
public interface SupplierStockBakDao {

    //增
    public int insertSelective(SupplierStockBak supplierStockBak);
    //批量新增
    public int insertSelectiveBatch(List<SupplierStockBak> supplierStockBaks);
    //查-列表
    public List<SupplierStockBak> findList(HashMap<String, Object> param);
    //查-总数
    public int findListCount(HashMap<String, Object> param);
    //查-byId
    public SupplierStockBak findById(Integer id);
    //改
    public int updateSelective(SupplierStockBak supplierStockBak);
    //删
    public int delete(SupplierStockBak supplierStockBak);



}