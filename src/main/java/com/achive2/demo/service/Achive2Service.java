package com.achive2.demo.service;

import com.achive2.demo.dto.Achive2Dto;
import com.achive2.demo.entity.Achive2;
import com.achive2.demo.exceptions.firstException;
import com.achive2.demo.exceptions.firstException;
import com.achive2.demo.exceptions.secondException;
import com.achive2.demo.repository.Achive2Repository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Achive2Service {

    private final Achive2Repository achive2Repository;

    public Achive2 save(Achive2Dto achive2Dto) throws Exception {

        Achive2 achive2;
        if (achive2Dto.getNumber() < 0) {
            throw new IllegalArgumentException();
        }

        Iterable<Achive2> achive2s = achive2Repository.findAll();
        for(Achive2 check : achive2s) {
            if (achive2Dto.getNumber() == check.getNumber()) {
                throw new firstException();
            } else if (achive2Dto.getNumber() == check.getNumber() - 1) {
                throw new secondException();
            }
        }
        achive2 = new Achive2()
                .setId(achive2Dto.getNumber())
                .setNumber(achive2Dto.getNumber())
                .setMessage("ни одно из исключений не было вызвано.");
        return achive2Repository.save(achive2);
    }

    public Iterable<Achive2> getAll() {
        return achive2Repository.findAll();
    }

    public void deleteAll() {
        achive2Repository.deleteAll();
    }
}
