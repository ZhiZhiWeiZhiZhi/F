package com.f.service;

import com.f.bean.DataTypeTest;
import com.f.dao.DataTypeTestMapper;
import com.f.service.base.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by F on 2018/5/10.
 */
@Service
public class DataTypeTestService extends BaseServiceImpl<DataTypeTest>{
    @Autowired
    private DataTypeTestMapper dataTypeTestMapper;
}
