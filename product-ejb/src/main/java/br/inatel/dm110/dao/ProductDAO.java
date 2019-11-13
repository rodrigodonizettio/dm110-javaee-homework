package br.inatel.dm110.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.inatel.dm110.entity.Product;

@Stateless
public class ProductDAO {
	@PersistenceContext(unitName="product_pu") //Configured in: "product-ejb/src/main/resources/META-INF/persistence.xml"
	private EntityManager entityManager;
	
	
	public List<Product> listAll() {
		Query query = entityManager.createQuery("from Product p", Product.class);
		return query.getResultList();
	}
	
	public void insert(Product product) {
		entityManager.persist(product);
	}
}
