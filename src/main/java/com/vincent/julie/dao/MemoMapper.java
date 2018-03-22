package com.vincent.julie.dao;

import com.vincent.julie.bean.MemoBean;

import java.util.List;
import java.util.Map;

/**
 * @author chenpy-1072
 * @desc MemoMapper
 * @date 2018/3/19 13:02
 * @see
 */
public interface MemoMapper {

    int addMemo(MemoBean memoBean);

    MemoBean getMemoFromTitle(Map<String, Object> paramMap);

    List<MemoBean> getMemoAll(Integer param);
}
