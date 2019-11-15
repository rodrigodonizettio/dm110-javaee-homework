package br.inatel.dm110.ejb.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.inatel.dm110.api.dto.ProductDTO;
import br.inatel.dm110.ejb.dao.ProductDAO;
import br.inatel.dm110.ejb.entity.Product;
import br.inatel.dm110.ejb.messagesender.ProductMessageSender;
import br.inatel.dm110.ejbclient.ProductLocal;
import br.inatel.dm110.ejbclient.ProductRemote;

@Stateless
@Local(ProductLocal.class)
@Remote(ProductRemote.class)
public class ProductBean implements ProductLocal, ProductRemote {
	@EJB
	private ProductDAO productDAO;
	@EJB
	private ProductMessageSender productMessageSender;
	
	
	@Override
	public ProductDTO create(ProductDTO productDTO) {
		productDAO.create(new Product(
				productDTO.getCode(),
				productDTO.getName(),
				productDTO.getDescription(),
				productDTO.getPrice(),
				productDTO.getCategory()));
		return productDTO;
	}
	@Override
	public List<ProductDTO> retrieveAll() {
		List<Product> products = productDAO.retrieveAll();
		List<ProductDTO> productsDTO = new ArrayList<>();
		products.forEach(p -> {
			productsDTO.add(new ProductDTO(
					p.getCode(),
					p.getName(),
					p.getDescription(),
					p.getPrice(),
					p.getCategory()));		
			});
		return productsDTO;
	}
	@Override
	public ProductDTO retrieveByCode(Integer code) {
		Product product = productDAO.retrieveByCode(code);
		return new ProductDTO(
				product.getCode(),
				product.getName(),
				product.getDescription(),
				product.getPrice(),
				product.getCategory());
	}
	@Override
	public ProductDTO update(ProductDTO productDTO) {
		productDAO.update(new Product(
				productDTO.getCode(),
				productDTO.getName(),
				productDTO.getDescription(),
				productDTO.getPrice(),
				productDTO.getCategory()));
		return productDTO;
	}
}
