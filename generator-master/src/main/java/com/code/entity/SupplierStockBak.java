package com.code.entity;

import java.io.Serializable;
import java.util.List;

/**
* Author zzg
* Date  2019-01-12
*/
public class SupplierStockBak implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private int companyId;
    private int brandId;
    private String model;
    private int quantity;
    private Timestamp updatetime;
    private String supplierModel;
    private boolean isDelete;
    private int warehouseId;
    private BigDecimal price;
    private int isTaxIncluded;
    private int isComparison;
    private BigDecimal taxPrice;
    private String area;
    private String brandplaceorigindetailId;
    private boolean packtype;


    public SupplierStockBak(){
    }


    public void setId (int id) {this.id = id;} 
    public int getId(){ return id;} 
    public void setCompanyId (int companyId) {this.companyId = companyId;} 
    public int getCompanyId(){ return companyId;} 
    public void setBrandId (int brandId) {this.brandId = brandId;} 
    public int getBrandId(){ return brandId;} 
    public void setModel (String model) {this.model = model;} 
    public String getModel(){ return model;} 
    public void setQuantity (int quantity) {this.quantity = quantity;} 
    public int getQuantity(){ return quantity;} 
    public void setUpdatetime (Timestamp updatetime) {this.updatetime = updatetime;} 
    public Timestamp getUpdatetime(){ return updatetime;} 
    public void setSupplierModel (String supplierModel) {this.supplierModel = supplierModel;} 
    public String getSupplierModel(){ return supplierModel;} 
    public void setIsDelete (boolean isDelete) {this.isDelete = isDelete;} 
    public boolean isIsDelete(){ return isDelete;} 
    public void setWarehouseId (int warehouseId) {this.warehouseId = warehouseId;} 
    public int getWarehouseId(){ return warehouseId;} 
    public void setPrice (BigDecimal price) {this.price = price;} 
    public BigDecimal getPrice(){ return price;} 
    public void setIsTaxIncluded (int isTaxIncluded) {this.isTaxIncluded = isTaxIncluded;} 
    public int getIsTaxIncluded(){ return isTaxIncluded;} 
    public void setIsComparison (int isComparison) {this.isComparison = isComparison;} 
    public int getIsComparison(){ return isComparison;} 
    public void setTaxPrice (BigDecimal taxPrice) {this.taxPrice = taxPrice;} 
    public BigDecimal getTaxPrice(){ return taxPrice;} 
    public void setArea (String area) {this.area = area;} 
    public String getArea(){ return area;} 
    public void setBrandplaceorigindetailId (String brandplaceorigindetailId) {this.brandplaceorigindetailId = brandplaceorigindetailId;} 
    public String getBrandplaceorigindetailId(){ return brandplaceorigindetailId;} 
    public void setPacktype (boolean packtype) {this.packtype = packtype;} 
    public boolean isPacktype(){ return packtype;} 

}