package com.teamvaps.app.service;

import java.util.List;

import com.teamvaps.app.model.Usedchecklist;

public interface UsedchecklistService {

	List<Usedchecklist> findAllByTicketId(Long ticketid);

	List<Usedchecklist> findAllUsedchecklist();

	void updateUsedchecklist(Usedchecklist usedchecklist);

	void saveUsedchecklist(Usedchecklist usedchecklist);

}
