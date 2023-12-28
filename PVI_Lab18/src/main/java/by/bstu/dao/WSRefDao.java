package by.bstu.dao;

import by.bstu.entity.WSRef;

import java.util.List;

public interface WSRefDao {

    void save(WSRef wsRef);

    WSRef findById(int id);

    List<WSRef> findAll();

    List<WSRef> findAllByKey(String key);

    void update(WSRef wsRef);

    void delete(int id);

    void addLike(int id);

    void addDisLike(int id);
}

