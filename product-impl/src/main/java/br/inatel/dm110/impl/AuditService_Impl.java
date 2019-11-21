package br.inatel.dm110.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import br.inatel.dm110.api.AuditService;
import br.inatel.dm110.api.ProductService;
import br.inatel.dm110.api.dto.AuditDTO;
import br.inatel.dm110.api.dto.ProductDTO;
import br.inatel.dm110.ejbclient.audit.AuditRemote;
import br.inatel.dm110.ejbclient.product.ProductRemote;

@RequestScoped
public class AuditService_Impl implements AuditService {
	//TODO: Verify if the lookup is correct
	@EJB(lookup="ejb:product-ear-1.0/product-ejb-1.0/AuditBean!br.inatel.dm110.ejbclient.audit.AuditRemote")
	private AuditRemote auditRemote;
	
	@Override
	public List<AuditDTO> retrieveAll() {
		return auditRemote.retrieveAll();
	}
}
