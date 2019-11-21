package br.inatel.dm110.ejbclient.audit;

import java.util.List;

import br.inatel.dm110.api.dto.AuditDTO;

public interface Audit {
	public List<AuditDTO> retrieveAll();
}
