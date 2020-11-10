package com.example.money.repository;

import com.example.money.entity.MoneyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface MoneyRepository extends JpaRepository<MoneyEntity, Long> {

    @Query(" SELECT SUM(amount) FROM MoneyEntity WHERE sender = :senderName")
    Long getAmountByPerson(String senderName);

}
