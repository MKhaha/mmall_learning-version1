package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.AssetInventory;


import java.util.List;

/**
 * Created by Administrator on 2017/5/18.
 */
public interface AssetManageService {

    ServerResponse<AssetInventory> selectById(String assetId);

    ServerResponse<List<AssetInventory>> selectByName(String assetName);

    ServerResponse<List<AssetInventory>> selectByType(String assetCategory);

    ServerResponse<List<AssetInventory>> selectAll();
}
