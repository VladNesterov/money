package com.example.money.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RequestMoneyDto {

    @ApiModelProperty(value = "sender", required = true)
    private String sender;

    @ApiModelProperty(value = "recipient", required = true)
    private String recipient;

    @ApiModelProperty(value = "amount", required = true)
    private Long amount;

}
