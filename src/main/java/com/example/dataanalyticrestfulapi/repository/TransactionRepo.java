package com.example.dataanalyticrestfulapi.repository;

import com.example.dataanalyticrestfulapi.model.Transaction;
import com.example.dataanalyticrestfulapi.model.request.TransactionRequest;
import com.example.dataanalyticrestfulapi.model.response.TransactionResponse;
import com.example.dataanalyticrestfulapi.repository.provider.TransactionProvider;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.*;

import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface TransactionRepo {

    @Results({
            @Result(column = "sender_account_id",property = "senderAccountId"),
            @Result(column = "receiver_account-id",property = "receiveAccountId"),
            @Result(column = "transfer_at",property = "transferAt")
    })
    @SelectProvider(type = TransactionProvider.class,method = "getAllTransaction")
    List<Transaction> getAllTransaction();

    @InsertProvider(type = TransactionProvider.class,method = "insertTransaction")
    int createTransaction(@Param("trans") TransactionRequest transaction);
    @UpdateProvider(type = TransactionProvider.class,method = "updateTransaction")
    int updateTransaction(@Param("tran") TransactionRequest transactionRequest, @Param("id") int id);
    @DeleteProvider(type = TransactionProvider.class,method = "deleteTransaction")
    int deleteTransaction(@Param("id") int id);

    @Results({
            @Result(column = "sender_account_id",property = "senderAccountId",one = @One(select = "com.example.demo.repository.TransactionAccountRepository.getTransactionAccount")),
            @Result(column = "receiver_account-id",property = "receiveAccountId",one = @One(select = "com.example.demo.repository.TransactionAccountRepository.getTransactionAccount")),
            @Result(column = "transfer_at",property = "transferAt")
    })
    @SelectProvider(type = TransactionProvider.class,method = "getAllTransactionAccount")
    List<TransactionResponse> getAllTransactionAccount();
}
