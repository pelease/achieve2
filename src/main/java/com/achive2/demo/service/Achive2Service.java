package com.achive2.demo.service;

import com.achive2.demo.dto.Achive2Dto;
import com.achive2.demo.entity.Achive2;
import com.achive2.demo.repository.Achive2Repository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Achive2Service {

    private final Achive2Repository achive2Repository;

    public Achive2 save(Achive2Dto achive2Dto) {

        Achive2 achive2;
        if (achive2Dto.getNumber() < 0) {
            achive2 = new Achive2()
                    .setNumber(-1)
                    .setMessage("Число меньше 0");
            return achive2Repository.save(achive2);
        }

        Iterable<Achive2> achive2s = achive2Repository.findAll();
        for(Achive2 check : achive2s) {
            if (achive2Dto.getNumber() == check.getNumber()) {
                achive2 = new Achive2()
                        .setNumber(-1)
                        .setMessage("Исключение 1: такое число уже поступало");
                return achive2Repository.save(achive2);
            } else if (achive2Dto.getNumber() == check.getNumber() - 1) {
                achive2 = new Achive2()
                        .setNumber(-1)
                        .setMessage("Исключение 2: число на 1 меньше уже обработанного числа");
                return achive2Repository.save(achive2);
            }
        }
        achive2 = new Achive2()
                .setNumber(achive2Dto.getNumber())
                .setMessage("ни одно из исключений не было вызвано.");
        return achive2Repository.save(achive2);
    }

    public Iterable<Achive2> getAll() {
        return achive2Repository.findAll();
    }
}
