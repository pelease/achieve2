package com.achive2.demo.controller;

import com.achive2.demo.dto.Achive2Dto;
import com.achive2.demo.entity.Achive2;
import com.achive2.demo.service.Achive2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/achive2")
@RequiredArgsConstructor
public class Achive2Controller {

    private final Achive2Service achive2Service;

    @PostMapping
    public Achive2 save(@RequestBody Achive2Dto achive2Dto) {
        Achive2 achive2 = achive2Service.save(achive2Dto);
        if (achive2.getMessage() == "ни одно из исключений не было вызвано.") {
            achive2.setNumber(achive2.getNumber() + 1);
        }
        return achive2;
    }

    @GetMapping
    public Iterable<Achive2> getAll() {
        return achive2Service.getAll();
    }
}
