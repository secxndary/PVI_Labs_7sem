package by.bstu.dao;

import by.bstu.entity.WSRefComment;

import java.util.List;

public interface WSRefCommentDao {

    void save(WSRefComment wsRefComment);

    WSRefComment findById(int id);

    List<WSRefComment> findAll();

    List<WSRefComment> findAllByWsRefId(int wsRefId);

    void update(WSRefComment wsRefComment);

    void delete(int id);
}

