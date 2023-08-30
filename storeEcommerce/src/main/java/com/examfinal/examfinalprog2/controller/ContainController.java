package com.examfinal.examfinalprog2.controller;

import com.examfinal.examfinalprog2.entity.Contain;
import org.springframework.web.bind.annotation.*;
import com.examfinal.examfinalprog2.service.ContainService;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/contains")
public class ContainController {
    private ContainService containService;

    public ContainController(ContainService containService) {
        this.containService = containService;
    }

    @GetMapping("/")
    public List<Contain> getAllContains() throws SQLException {
        return containService.findAllContains();
    }

    @GetMapping("/{id}")
    public Contain getContainById(@PathVariable int id) throws SQLException {
        return containService.findContainById(id);
    }

    @PostMapping("/")
    public void addContain(@RequestBody Contain contain) throws SQLException {
        containService.insertContain(contain);
    }

    @PutMapping("/{id}")
    public void updateContain(@RequestBody Contain containUpdate) throws SQLException {
        containService.updateContain(containUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteContain(@PathVariable int id) throws SQLException {
        containService.deleteContain(id);
    }
}
