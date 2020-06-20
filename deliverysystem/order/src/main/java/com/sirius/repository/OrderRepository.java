package com.sirius.repository;

import com.sirius.entity.Order;

import java.util.List;

public interface OrderRepository {
    public void save(Order order);
    public List<Order> findAll();
    public List<Order> findAllByUid(int uid);
    public int countByUid(int uid);
    public void deleteByMid(int mid);
    public void deleteByUid(int uid);
    public List<Order> findAllByState(int state,int index,int limit);
    public int countByState(int state);
    public void updateState(int id,int aid,int state);

    public List<Order> findAllByRid(int rid);

    public void update(Order order);
    public void receiveAction(long oid);
    public void commentAction(long oid);
}
