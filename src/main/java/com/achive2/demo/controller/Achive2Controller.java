package com.achive2.demo.controller;

import com.achive2.demo.dto.Achive2Dto;
import com.achive2.demo.entity.Achive2;
import com.achive2.demo.exceptions.firstException;
import com.achive2.demo.exceptions.secondException;
import com.achive2.demo.service.Achive2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/achive2")
@RequiredArgsConstructor
public class Achive2Controller {

    private final Achive2Service achive2Service;

    @PostMapping
    public Achive2 save(@RequestBody Achive2Dto achive2Dto) {
        try {
            Achive2 achive2 = achive2Service.save(achive2Dto);
            if (achive2.getMessage() == "ни одно из исключений не было вызвано.") {
                achive2.setNumber(achive2.getNumber() + 1);
            }
            return achive2;
        } catch (firstException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The number is the same as in database", ex);
        } catch (secondException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The number is less by 1 than in the database", ex);
        } catch (IllegalArgumentException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The number is less then 0", ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping
    public Iterable<Achive2> getAll() {
        return achive2Service.getAll();
    }

    @DeleteMapping
    public void deleteAll() {
        achive2Service.deleteAll();
    }
}
