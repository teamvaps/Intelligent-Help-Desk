package edu.cpp.cs580.data;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface BitLockerRepository extends CrudRepository<BitLockerEntity, Long> {
	public BitLockerEntity findByTicket(String ticketToSearch);
	public BitLockerEntity findByComputerName(String computerNameToSearch);
}