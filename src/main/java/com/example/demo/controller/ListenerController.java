package com.example.demo.controller;

import com.example.demo.data.entity.ListenerEntity;
import com.example.demo.service.impl.ListenerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/listener")
public class ListenerController {

    private ListenerServiceImpl listenerService;

    @Autowired
    public ListenerController(ListenerServiceImpl listenerService) {
        this.listenerService = listenerService;
    }

    @GetMapping
    public String getListener(Long id) {
        listenerService.getEntity(id);

        return "ok";
    }

    @PostMapping
    public void saveListener(String name) {
        ListenerEntity listenerEntity = new ListenerEntity();

        listenerEntity.setName(name);
        listenerService.saveEntity(listenerEntity);
    }

    @PutMapping
    public void updateListener(Long id, String name) {
        ListenerEntity listenerEntity = new ListenerEntity();

        listenerEntity.setId(id);
        listenerEntity.setName(name);
        listenerService.saveEntity(listenerEntity);
    }

    @DeleteMapping
    public void deleteListener(Long id) {
        ListenerEntity listenerEntity = listenerService.getEntity(id);

        listenerService.removeEntity(listenerEntity);
    }
}
