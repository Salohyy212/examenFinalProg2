package com.examfinal.examfinalprog2.service;

import com.examfinal.examfinalprog2.entity.Contain;
import org.springframework.stereotype.Service;
import com.examfinal.examfinalprog2.repository.ContainCrud;
import java.sql.SQLException;
import java.util.List;


@Service
public class ContainService {
    private ContainCrud containCrud;

    public ContainService(ContainCrud containCrud) {
        this.containCrud = containCrud;
    }
    public void insertContain(Contain contain) throws SQLException {
        containCrud.insertContain(contain);
    }

    public Contain findContainById(int id) throws SQLException {
        return containCrud.findContainById(id);
    }

    public List<Contain> findAllContains() throws SQLException {
        return containCrud.findAllContains();
    }

    public boolean deleteContain(int id) throws SQLException {
        return containCrud.deleteContain(id);
    }

    public boolean updateContain(Contain containUpdate) throws SQLException {
        return containCrud.updateContain(containUpdate);
    }
}
