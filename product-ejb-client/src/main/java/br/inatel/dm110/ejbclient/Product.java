package br.inatel.dm110.ejbclient;

import java.util.List;

import br.inatel.dm110.api.dto.ProductDTO;

public interface Product {
	public ProductDTO create(ProductDTO productDTO);
	public List<ProductDTO> retrieveAll();
	public ProductDTO retrieveByCode(Integer code);
	public ProductDTO update(ProductDTO productDTO);
}
