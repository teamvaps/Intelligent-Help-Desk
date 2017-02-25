package edu.cpp.cs580.data;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface UserTermRepository extends CrudRepository<UserTermEntity, Long> {
	public UserTermEntity findByTicket(String ticketToSearch);
	public UserTermEntity findByComputerName(String computerNameToSearch);
}