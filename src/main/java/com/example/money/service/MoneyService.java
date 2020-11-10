package com.example.money.service;

import com.example.money.customExeptions.NotFoundException;
import com.example.money.dto.request.RequestMoneyDto;
import com.example.money.dto.response.ResponseMoneyDto;
import com.example.money.entity.MoneyEntity;
import com.example.money.repository.MoneyRepository;
import com.example.money.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MoneyService {

    private final MapperUtil mapper;
    private final MoneyRepository moneyRepository;

    @Autowired
    public MoneyService(MapperUtil mapper, MoneyRepository moneyRepository) {
        this.mapper = mapper;
        this.moneyRepository = moneyRepository;
    }

    public Long getAmountBySender(String nameSender) {
        Long response = moneyRepository.getAmountByPerson(nameSender);
        if (response == null) {
            throw new NotFoundException("Not found sender with name = " + nameSender);
        }
        return moneyRepository.getAmountByPerson(nameSender);
    }

    public List<ResponseMoneyDto> savePayments(List<RequestMoneyDto> requestMoneyDtos) {
        List<MoneyEntity> moneyEntityList = requestMoneyDtos.stream()
                .map(mapper::mapToMoneyEntity)
                .collect(Collectors.toList());
        return moneyRepository.saveAll(moneyEntityList).stream().map(mapper::mapToResponseMoneyDto).collect(Collectors.toList());
    }


}
