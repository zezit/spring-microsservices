package com.calculator.api.calculatorapi;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.calculator.api.calculatorapi.exception.UnsuportedMathOperationException;

@RestController
public class MathController {
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public BigDecimal sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }

        BigDecimal sum = BigDecimal.valueOf(convertDouble(numberOne))
                .add(BigDecimal.valueOf(convertDouble(numberTwo)));

        return sum;
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public BigDecimal sub(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }

        BigDecimal sub = BigDecimal.valueOf(convertDouble(numberOne))
                .subtract(BigDecimal.valueOf(convertDouble(numberTwo)));

        return sub;
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public BigDecimal div(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }

        BigDecimal div = BigDecimal.valueOf(convertDouble(numberOne))
                .divide(BigDecimal.valueOf(convertDouble(numberTwo)), 5, RoundingMode.HALF_UP);

        return div;
    }

    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public BigDecimal mult(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }

        BigDecimal mult = BigDecimal.valueOf(convertDouble(numberOne))
                .multiply(BigDecimal.valueOf(convertDouble(numberTwo)));

        return mult;
    }

    @RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public BigDecimal mean(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }

        BigDecimal sum = BigDecimal.valueOf(convertDouble(numberOne))
                .add(BigDecimal.valueOf(convertDouble(numberTwo)));

        BigDecimal mean = new BigDecimal(sum.doubleValue()).divide(new BigDecimal(2), 5, RoundingMode.HALF_UP);

        return mean;
    }

    @RequestMapping(value = "/sqrt/{number}", method = RequestMethod.GET)
    public BigDecimal sqrt(
            @PathVariable("number") String number) throws Exception {

        if (!isNumeric(number)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }

        BigDecimal sqrt = BigDecimal.valueOf(Math.sqrt(convertDouble(number)));

        return sqrt;
    }

    private Double convertDouble(String strNumber) {
        if (strNumber == null)
            return 0D;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number))
            return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null)
            return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}