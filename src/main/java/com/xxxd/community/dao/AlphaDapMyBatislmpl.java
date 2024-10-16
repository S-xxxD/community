package com.xxxd.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class AlphaDapMyBatislmpl implements AlphaDao{

    @Override
    public String select() {
        return "MyBatis";
    }
}
