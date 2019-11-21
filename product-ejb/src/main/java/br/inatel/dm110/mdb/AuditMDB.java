package br.inatel.dm110.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import br.inatel.dm110.ejb.dao.AuditDAO;
import br.inatel.dm110.ejb.entity.Audit;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/productqueue"),
		@ActivationConfigProperty(propertyName = "maxSession", propertyValue = "5")
})
public class AuditMDB implements MessageListener{
	@EJB
	private AuditDAO auditDAO;
	
	@Override
	public void onMessage(Message message) {
		try {
				//If arrived a message with an object Audit type:
				if(message instanceof ObjectMessage) {
					ObjectMessage objectMessage = (ObjectMessage)message;
					
					if(objectMessage.getObject() instanceof Audit) {
						Audit audit = (Audit) objectMessage.getObject();						
						auditDAO.create(audit);
					}
					else {
						System.out.println("Something arrived in queue, but it is not a Audit Object...");
					}
				}
				else {
					System.out.print("Couldn´t identify the type of message that just arrived...");
				}
		} catch(JMSException e) {
			e.printStackTrace();
		}
	}
}