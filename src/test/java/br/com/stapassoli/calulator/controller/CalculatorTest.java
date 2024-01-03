package br.com.stapassoli.calulator.controller;

import br.com.stapassoli.calulator.dto.ArithmeticOperationDTO;
import br.com.stapassoli.calulator.enums.Operation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class CalculatorTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Test to check to the sum between 2.5 and 3.5")
    public void testAddition() throws Exception {

        ArithmeticOperationDTO request = new ArithmeticOperationDTO();
        request.setNumA(3.0);
        request.setNumB(3.5);
        request.setOperation(Operation.SUM);

        mockMvc.perform(MockMvcRequestBuilders.post("/calculator")
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.numA").value(3.0))
            .andExpect(MockMvcResultMatchers.jsonPath("$.numB").value(3.5))
            .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(6.5))
            .andExpect(MockMvcResultMatchers.jsonPath("$.operation").value("SUM"));
    }
}


