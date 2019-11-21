package br.inatel.dm110.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.inatel.dm110.api.dto.AuditDTO;

@Path("/audit")
public interface AuditService {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<AuditDTO> retrieveAll();
}
