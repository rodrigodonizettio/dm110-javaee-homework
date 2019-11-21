package br.inatel.dm110.ejb.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.inatel.dm110.api.dto.ProductDTO;
import br.inatel.dm110.ejb.constants.OperationConstants;
import br.inatel.dm110.ejb.dao.ProductDAO;
import br.inatel.dm110.ejb.entity.Product;
import br.inatel.dm110.ejb.messagesender.AuditMessageSender;
import br.inatel.dm110.ejbclient.product.ProductLocal;
import br.inatel.dm110.ejbclient.product.ProductRemote;

@Stateless
@Local(ProductLocal.class)
@Remote(ProductRemote.class)
public class ProductBean implements ProductLocal, ProductRemote {
	@EJB
	private ProductDAO productDAO;
	@EJB
	private AuditMessageSender auditMessageSender;
	
	@Override
	public ProductDTO create(ProductDTO productDTO) {
		productDAO.create(new Product(
				productDTO.getCode(),
				productDTO.getName(),
				productDTO.getDescription(),
				productDTO.getPrice(),
				productDTO.getCategory()));
		auditMessageSender.sendProductDTO(productDTO, OperationConstants.CREATE);
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
		auditMessageSender.sendProductDTO(null, OperationConstants.RETRIEVE_ALL);
		return productsDTO;
	}
	
	@Override
	public ProductDTO retrieveByCode(Integer code) {
		Product product = productDAO.retrieveByCode(code);
		ProductDTO productDTO = new ProductDTO(
				product.getCode(),
				product.getName(),
				product.getDescription(),
				product.getPrice(),
				product.getCategory());
		auditMessageSender.sendProductDTO(productDTO, OperationConstants.RETRIEVE_BY_CODE);
		return productDTO;
	}
	
	@Override
	public ProductDTO update(ProductDTO productDTO) {
		productDAO.update(new Product(
				productDTO.getCode(),
				productDTO.getName(),
				productDTO.getDescription(),
				productDTO.getPrice(),
				productDTO.getCategory()));
		auditMessageSender.sendProductDTO(productDTO, OperationConstants.UPDATE);
		return productDTO;
	}
}