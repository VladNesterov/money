package com.example.money.controller;

import com.example.money.dto.request.RequestMoneyDto;
import com.example.money.dto.response.ResponseMoneyDto;
import com.example.money.service.MoneyService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MoneyController {

    private final MoneyService moneyService;

    @Autowired
    public MoneyController(MoneyService moneyService) {
        this.moneyService = moneyService;
    }

    @ApiOperation(value = "Get list sender, recipient, amount")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Progress successfully returned", response = ResponseMoneyDto.class),
    })
    @RequestMapping(value = "/question/create", method = RequestMethod.POST)
    public List<ResponseMoneyDto> savePayments(@RequestBody List<RequestMoneyDto> requestMoneyDtos) {
       return moneyService.savePayments(requestMoneyDtos);
    }

    @ApiOperation(value = "Get total amount sender")
    @RequestMapping(value = "/question/read", method = RequestMethod.GET)
    public Long getTotalAmountSender(@RequestParam String nameSender) {
        return moneyService.getAmountBySender(nameSender);
    }

}
