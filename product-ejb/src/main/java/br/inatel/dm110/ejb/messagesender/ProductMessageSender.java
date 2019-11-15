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

@Stateless
public class ProductMessageSender {
	@Resource(lookup="java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;
	@Resource(lookup="java:/jms/queue/productqueue") //The "productqueue" queue must be configured in WildFly container
	private Queue queue;
	
	public void sendProductDTO(ProductDTO productDTO) {
		try {
			Connection connection = connectionFactory.createConnection();
			Session session = connection.createSession();
			MessageProducer messageProducer = session.createProducer(queue);
			ObjectMessage objectMessage = session.createObjectMessage(productDTO);
			messageProducer.send(objectMessage);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
