package com.blueharvest.account.repository;

import com.blueharvest.account.service.UserInformationSummary;
import com.blueharvest.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    long countById(Long id);

    @Query("SELECT a.id as id, a.customerId  as customerId , a.balance as balance , a.accountNumber as accountNumber, a.createdDate as createdDate , c.name as name ," +
            "c.surName as surName FROM Account a LEFT JOIN Customer c on c.id = a.customerId where  c.id =:customerId ")
    List<UserInformationSummary> getUserInformation(@Param("customerId") Long customerId);
}
