package com.xxxd.community.dao;

import org.springframework.stereotype.Repository;

@Repository("Hibernatelmpl")
public class AlphaDaoHibernatelmpl implements AlphaDao {

    @Override
    public String select() {
        return "Hibernatelmpl";
    }
}
