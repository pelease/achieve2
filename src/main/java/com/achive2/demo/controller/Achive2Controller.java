package com.achive2.demo.controller;

import com.achive2.demo.dto.Achive2Dto;
import com.achive2.demo.entity.Achive2;
import com.achive2.demo.service.Achive2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/achive2")
@RequiredArgsConstructor
public class Achive2Controller {

    private final Achive2Service achive2Service;

    @PostMapping
    public Achive2 save(@RequestBody Achive2Dto achive2Dto) {
        return achive2Service.save(achive2Dto);
    }

    @GetMapping
    public Iterable<Achive2> getAll() {
        return achive2Service.getAll();
    }
}
