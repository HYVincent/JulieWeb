package com.vincent.julie.dao;

import com.vincent.julie.bean.VersionBean;
import org.apache.ibatis.annotations.Select;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: (用一句话描述该文件做什么)
 * @author: Vinent QQ:1032006226
 * @date:
 * @Copyright: 注意：本内容仅限于是我写的
 */


public interface VersionMapper {

    /**
     * 添加新版本
     * @param versionBean
     */
    void addVersion(VersionBean versionBean);

    /**
     * 查询最新版本
     * @param params
     * @return
     */
    VersionBean getLatestVersion();

    /**
     * 查询某个版本
     * @param versionCode
     * @return
     */
    VersionBean getVersion(int versionCode);

    /**
     * 删除某个版本
     * @param versionCode
     */
    void deleteIdVersion(int versionCode);

}
