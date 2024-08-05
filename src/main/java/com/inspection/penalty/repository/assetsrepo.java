package com.inspection.penalty.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import com.inspection.penalty.model.assets.Assetsmodel;

@Repository
public class assetsrepo {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public static class fetchdatarepo implements RowMapper<Assetsmodel>{

        @Override
        @Nullable
        public Assetsmodel mapRow(@SuppressWarnings("null") ResultSet rs, int rowNum) throws SQLException {
            // TODO Auto-generated method stub
                Assetsmodel assetsmodelr=new Assetsmodel();

                
                assetsmodelr.setDevice(rs.getString("device"));
                assetsmodelr.setMake(rs.getString("make"));
                assetsmodelr.setModel(rs.getString("model_no"));
                assetsmodelr.setSerial(rs.getString("serial_no"));
                assetsmodelr.setImei1(rs.getString("imei_no1"));
                assetsmodelr.setImei2(rs.getString("imei_no2"));
                assetsmodelr.setPorts(rs.getString("Ports"));
                assetsmodelr.setRam(rs.getString("ram"));
                assetsmodelr.setProcessor(rs.getString("processor"));
                assetsmodelr.setStorage(rs.getString("storage"));
                assetsmodelr.setAssetTag(rs.getString("asset_tag"));
                assetsmodelr.setIsActive(rs.getString("is_active"));
                assetsmodelr.setAssetsReceived(rs.getDate("assets_recieved"));
                assetsmodelr.setWarrantyExp(rs.getDate("warranty_exp_date"));
                assetsmodelr.setBillInvoice(rs.getString("bill_invoice"));
                return assetsmodelr;
        }

    }
    public int addassets(Assetsmodel formdata){

        System.out.println(formdata);

        String sql = "INSERT INTO assets_master (device, make, model_no, serial_no, imei_no1, imei_no2, Ports, ram, processor, storage, asset_tag, is_active, assets_recieved, warranty_exp_date, bill_invoice) " +
        "VALUES ('"+formdata.getdevice()+"','"+formdata.getMake()+"','"+formdata.getModel()+"', '"+formdata.getSerial()+"', '"+formdata.getImei1()+"', '"+formdata.getImei2()+"', '"+formdata.getPorts()+"', '"+formdata.getRam()+"', '"+formdata.getProcessor()+"', '"+formdata.getStorage()+"', '"+formdata.getAssetTag()+"', '"+formdata.getIsActive()+"', '"+formdata.getAssetsReceived()+"', '"+formdata.getWarrantyExp()+"', '"+formdata.getBillInvoice()+"')";

           int status=jdbcTemplate.update(sql);
System.out.println(status);



        return status;

    }

    public List<Assetsmodel> assetsdata(){

      List<Assetsmodel> assetdata;
        String sql ="SELECT * FROM `assets_master`;";
        assetdata=jdbcTemplate.query(sql, new fetchdatarepo());
        

        return assetdata;
    }
    
}
