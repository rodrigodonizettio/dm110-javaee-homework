package br.inatel.dm110.ejb.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.inatel.dm110.api.dto.AuditDTO;
import br.inatel.dm110.ejb.dao.AuditDAO;
import br.inatel.dm110.ejb.entity.Audit;
import br.inatel.dm110.ejbclient.audit.AuditLocal;
import br.inatel.dm110.ejbclient.audit.AuditRemote;

@Stateless
@Local(AuditLocal.class)
@Remote(AuditRemote.class)
public class AuditBean implements AuditLocal, AuditRemote {
	@EJB
	private AuditDAO auditDAO;
	
	@Override
	public List<AuditDTO> retrieveAll() {
		List<Audit> audits = auditDAO.retrieveAll();
		List<AuditDTO> auditDTOs = new ArrayList<>();
		audits.forEach(a -> {
			auditDTOs.add(new AuditDTO(
					a.getId(),
					a.getCode(),
					a.getOperation(),
					a.getDate()));
		});
		return auditDTOs;
	}
}
