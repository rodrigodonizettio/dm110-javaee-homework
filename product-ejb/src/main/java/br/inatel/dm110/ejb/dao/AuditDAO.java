package br.inatel.dm110.ejb.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.inatel.dm110.ejb.entity.Audit;
import br.inatel.dm110.ejb.entity.Product;

@Stateless
public class AuditDAO {
	@PersistenceContext(unitName="product_pu") //Configured in: "product-ejb/src/main/resources/META-INF/persistence.xml"
	private EntityManager entityManager;
	
	public Audit create(Audit audit) {
		entityManager.persist(audit);
		return audit;
	}
	
	public List<Audit> retrieveAll() {
		Query query = entityManager.createQuery("SELECT a FROM Audit a", Audit.class);
		return query.getResultList();
	}
}
