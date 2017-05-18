package com.mmall.controller.portal;

import com.mmall.common.ServerResponse;
import com.mmall.service.AssetManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/5/18.
 */
@Controller
@RequestMapping("/user/")
public class AssetsManageHandler {

    @Autowired
    private AssetManageService iAssetManageService;

    private static final String SEARCH_BY_ASSET_ID = "searchByAssetId";
    private static final String SEARCH_BY_ASSET_NAME = "searchByAssetName";
    private static final String SEARCH_BY_ASSET_TYPE = "searchByAssetType";
    private static final String SEARCH_ALL = "searchAll";


    @RequestMapping(value = "getAssetList.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse getGoodsList(@RequestParam("searchType") String searchType,
                                       @RequestParam("keyWord") String keyWord) {

        switch (searchType) {
            case SEARCH_BY_ASSET_ID:
                return iAssetManageService.selectById(keyWord);
            case SEARCH_BY_ASSET_NAME:
                return iAssetManageService.selectByName(keyWord);
            case SEARCH_BY_ASSET_TYPE:
                return iAssetManageService.selectByType(keyWord);
            case SEARCH_ALL:
                return iAssetManageService.selectAll();
            default:
                return ServerResponse.createByErrorMessage("参数错误");
        }
    }
}
