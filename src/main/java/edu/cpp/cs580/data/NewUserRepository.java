package edu.cpp.cs580.data;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface NewUserRepository extends CrudRepository<NewUserEntity, Long> {
	public NewUserEntity findByTicket(String ticketToSearch);
	public NewUserEntity findByComputerName(String computerNameToSearch);
}