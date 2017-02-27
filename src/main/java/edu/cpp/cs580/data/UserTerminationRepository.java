package edu.cpp.cs580.data;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface UserTerminationRepository extends CrudRepository<UserTerminationEntity, Long> {
	public UserTerminationEntity findByTicket(String ticketToSearch);
	public UserTerminationEntity findByComputerName(String computerNameToSearch);
}