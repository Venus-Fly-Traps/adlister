package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);

    User findById(long user_id);

    void update(User user);

    AtomicLong findUserId(long id);
}
