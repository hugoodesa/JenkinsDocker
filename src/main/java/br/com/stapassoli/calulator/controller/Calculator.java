package br.com.stapassoli.calulator.controller;

import br.com.stapassoli.calulator.dto.ArithmeticOperationDTO;
import br.com.stapassoli.calulator.dto.ArithmeticOperationRes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class Calculator {

    @PostMapping
    public ResponseEntity<ArithmeticOperationRes> calculate (@RequestBody ArithmeticOperationDTO arithmeticOperation) {

        var response = ArithmeticOperationRes
            .builder()
            .operation(arithmeticOperation.getOperation())
            .result(arithmeticOperation.executeOperation())
            .numA(arithmeticOperation.getNumA())
            .numA(arithmeticOperation.getNumB())
            .build();

        return ResponseEntity.ok(response);
    }

}
