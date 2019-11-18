package br.inatel.dm110.ejb.messagesender;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

import br.inatel.dm110.api.dto.ProductDTO;
import br.inatel.dm110.ejb.log.Audit;

@Stateless
public class AuditMessageSender {
	@Resource(lookup="java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;
	@Resource(lookup="java:/jms/queue/productqueue") //The "productqueue" queue must be configured in WildFly container
	private Queue queue;
	
	public void sendProductDTO(ProductDTO productDTO, String operation) {
		try {
			Connection connection = connectionFactory.createConnection();
			Session session = connection.createSession();
			MessageProducer messageProducer = session.createProducer(queue);
			
			//Now, we are going to create a Audit message:
			Audit audit = new Audit();
			audit.setCode(productDTO.getCode());	//Audit code is the product code!
			audit.setOperation(operation);
			
			System.out.println("Audit Message generated successfull");
			
			ObjectMessage objectMessage = session.createObjectMessage(audit);
			messageProducer.send(objectMessage);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
