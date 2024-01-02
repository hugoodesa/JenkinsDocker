package br.com.stapassoli.calulator.dto;


import br.com.stapassoli.calulator.enums.Operation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ArithmeticOperationRes {

    public double numA;
    public double numB;
    public double result;
    public Operation operation;

}
