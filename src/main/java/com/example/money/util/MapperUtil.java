package com.example.money.util;

import com.example.money.dto.request.RequestMoneyDto;
import com.example.money.dto.response.ResponseMoneyDto;
import com.example.money.entity.MoneyEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MapperUtil {

    private final ModelMapper mapper = new ModelMapper();
    private final ObjectMapper oMapper = new ObjectMapper();

    public MoneyEntity mapToMoneyEntity(RequestMoneyDto requestMoneyDto) {

        return mapper.map(requestMoneyDto, MoneyEntity.class);
    }

    public ResponseMoneyDto mapToResponseMoneyDto(MoneyEntity moneyEntity) {

        return mapper.map(moneyEntity, ResponseMoneyDto.class);
    }

}