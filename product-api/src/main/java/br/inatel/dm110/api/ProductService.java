package br.inatel.dm110.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.inatel.dm110.api.dto.ProductDTO;

@Path("/product")
public interface ProductService {
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public ProductDTO create(ProductDTO productDTO);
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProductDTO> retrieveAll();
	@GET
	@Path("{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProductDTO retrieveByCode(@PathParam("code") Integer code);
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public ProductDTO update(ProductDTO productDTO);
}