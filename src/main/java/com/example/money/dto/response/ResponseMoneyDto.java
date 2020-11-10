package com.example.money.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ResponseMoneyDto {

    @ApiModelProperty(value = "sender")
    private long id;

    @ApiModelProperty(value = "sender")
    private String sender;

    @ApiModelProperty(value = "recipient")
    private String recipient;

    @ApiModelProperty(value = "amount")
    private Long amount;

}
