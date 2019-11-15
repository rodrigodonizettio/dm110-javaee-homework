package br.inatel.dm110.ejb.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.inatel.dm110.ejb.entity.Product;

@Stateless
public class ProductDAO {
	@PersistenceContext(unitName="product_pu") //Configured in: "product-ejb/src/main/resources/META-INF/persistence.xml"
	private EntityManager entityManager;
	
	public Product create(Product product) {
		entityManager.persist(product);
		return product;
	}
	
	public List<Product> retrieveAll() {
		Query query = entityManager.createQuery("SELECT p FROM Product p", Product.class);
		return query.getResultList();
	}	
	
	public Product retrieveByCode(Integer code) {
		Query query = entityManager.createQuery("SELECT p FROM Product p WHERE p.code = :code")
				.setParameter("code", code);
		return (Product) query.getSingleResult();
	}
	
	//TODO: must be tested
	public Product update(Product product) {
		Query query = entityManager.createQuery("UPDATE Product SET "
				+ "name = :name, "
				+ "description = :description, "
				+ "price = :price, "
				+ "category = :category "
				+ "WHERE code = :code");
		query.setParameter("name", product.getName());
		query.setParameter("description", product.getDescription());
		query.setParameter("price", product.getPrice());
		query.setParameter("category", product.getCategory());
		query.setParameter("code", product.getCode());
		query.executeUpdate();
		return product;
	}
}