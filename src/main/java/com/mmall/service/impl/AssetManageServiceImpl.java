package com.mmall.service.impl;

import com.mmall.common.ServerResponse;
import com.mmall.dao.AssetInventoryMapper;
import com.mmall.pojo.AssetInventory;
import com.mmall.service.AssetManageService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/5/18.
 */
@Service("iAssetManageService")
public class AssetManageServiceImpl implements AssetManageService {

    private Logger logger = LoggerFactory.getLogger(com.mmall.service.impl.AssetManageServiceImpl.class);

    @Autowired
    private AssetInventoryMapper assetInventoryMapper;


    @Override
    public ServerResponse<AssetInventory> selectById(String assetId) {
        AssetInventory assetInventory = assetInventoryMapper.selectByPrimaryKey(assetId);
        if(assetInventory != null) {
            return ServerResponse.createBySuccess(assetInventory);
        }
        return ServerResponse.createByErrorMessage("没有记录");

    }

    @Override
    public ServerResponse<List<AssetInventory>> selectByName(String assetName) {
        List<AssetInventory> assetInventoryList = assetInventoryMapper.selectByName(assetName);
        if(CollectionUtils.isEmpty(assetInventoryList)) {
            logger.info("未找到任何数据");
        }
        return ServerResponse.createBySuccess(assetInventoryList);
    }

    @Override
    public ServerResponse<List<AssetInventory>> selectByType(String assetCategory) {
        List<AssetInventory> assetInventoryList = assetInventoryMapper.selectByType(assetCategory);
        if(CollectionUtils.isEmpty(assetInventoryList)) {
            logger.info("未找到任何数据");
        }
        return ServerResponse.createBySuccess(assetInventoryList);
    }

    @Override
    public ServerResponse<List<AssetInventory>> selectAll() {
        List<AssetInventory> assetInventoryList = assetInventoryMapper.selectAll();
        if(CollectionUtils.isEmpty(assetInventoryList)) {
            logger.info("未找到任何数据");
        }
        return ServerResponse.createBySuccess(assetInventoryList);
    }
}
