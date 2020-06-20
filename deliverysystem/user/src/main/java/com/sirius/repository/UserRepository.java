package com.sirius.repository;


import com.sirius.entity.User;

import java.util.List;

public interface UserRepository {
    public List<User> findAll();
    public User findById(int userid);
    public User findByName(String nickname);
    public int count();
    public void save(User user);
    public void update(User user);
    public void deleteById(int userid);
    public void deleteByName(String nickname);
}
