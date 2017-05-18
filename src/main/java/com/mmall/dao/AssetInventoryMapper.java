package com.mmall.dao;

import com.mmall.pojo.AssetInventory;

import java.util.List;

public interface AssetInventoryMapper {
    int deleteByPrimaryKey(String assetId);

    int insert(AssetInventory record);

    int insertSelective(AssetInventory record);

    AssetInventory selectByPrimaryKey(String assetId);

    int updateByPrimaryKeySelective(AssetInventory record);

    int updateByPrimaryKey(AssetInventory record);

    List<AssetInventory> selectAll();

    List<AssetInventory> selectByName(String assetName);

    List<AssetInventory> selectByType(String assetCategory);

}