package br.inatel.dm110.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import br.inatel.dm110.api.ProductService;
import br.inatel.dm110.api.dto.ProductDTO;
import br.inatel.dm110.ejbclient.product.ProductRemote;

@RequestScoped
public class ProductService_Impl implements ProductService {
	//TODO: Verify if the lookup is correct
	@EJB(lookup="ejb:product-ear-1.0/product-ejb-1.0/ProductBean!br.inatel.dm110.ejbclient.product.ProductRemote")
	private ProductRemote productRemote;
	
	@Override
	public ProductDTO create(ProductDTO productDTO) {
		return productRemote.create(productDTO);
	}

	@Override
	public List<ProductDTO> retrieveAll() {
		return productRemote.retrieveAll();
	}

	@Override
	public ProductDTO retrieveByCode(Integer code) {
		return productRemote.retrieveByCode(code);
	}

	@Override
	public ProductDTO update(ProductDTO productDTO) {
		return productRemote.update(productDTO);
	}

}
