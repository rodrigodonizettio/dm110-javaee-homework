package br.inatel.dm110.ejb.messagesender;

import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

import br.inatel.dm110.api.dto.ProductDTO;
import br.inatel.dm110.ejb.constants.OperationConstants;
import br.inatel.dm110.ejb.entity.Audit;

@Stateless
public class AuditMessageSender {	
	@Resource(lookup="java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;
	
	//Queue name should refers to Audit and not to Product. Anyway, we kept productqueue this name.
	@Resource(lookup="java:/jms/queue/productqueue") //The "productqueue" queue must be configured in WildFly container
	private Queue queue;
	
	public void sendProductDTO(ProductDTO productDTO, String operation) {
		try {
			Connection connection = connectionFactory.createConnection();
			Session session = connection.createSession();
			MessageProducer messageProducer = session.createProducer(queue);
			
			//Now, we are going to create a Audit message:
			Audit audit = new Audit();
			if(!operation.equals(OperationConstants.RETRIEVE_ALL)) {
				audit.setCode(productDTO.getCode());	//Audit code is the product code!
			}		
			audit.setOperation(operation);
			audit.setDate(new Date()); //TODO: Date is deprecated. Should be replaced by Calendar type
			
			ObjectMessage objectMessage = session.createObjectMessage(audit);
			messageProducer.send(objectMessage);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
