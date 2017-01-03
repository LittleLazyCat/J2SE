package com.wms.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.springframework.stereotype.Repository;

import com.wms.bean.GiveBack;

import java.util.List;
import java.util.Map;

@Repository
public interface GiveBackMapper {
    int deleteByPrimaryKey(Integer gbId);

    int insert(GiveBack record);

    int insertSelective(GiveBack record);

    GiveBack selectByPrimaryKey(Integer gbId);

    List<GiveBack> select(Pagination page, Map<String,Object> map);

    int updateByPrimaryKeySelective(GiveBack record);

    int updateByPrimaryKey(GiveBack record);
}