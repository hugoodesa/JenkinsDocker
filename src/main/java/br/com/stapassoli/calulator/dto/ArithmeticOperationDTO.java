package br.com.stapassoli.calulator.dto;


import br.com.stapassoli.calulator.enums.Operation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArithmeticOperationDTO {

    public double numA;
    public double numB;
    public Operation operation;

    public Double executeOperation() {
        return operation.execute(this.numA, this.numB);
    }

}
