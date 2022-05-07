package com.mailbox.email.inbox.emailslist;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface EmailsListRepository extends CassandraRepository<EmailsList, EmailsListPrimaryKey>  {
    List<EmailsList> findAllById_UserIdAndId_Label(String userId, String label); 
}
