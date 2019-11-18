package br.inatel.dm110.mdb;

import javax.jms.JMSException;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import br.inatel.dm110.ejb.log.Audit;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/productqueue"),
		@ActivationConfigProperty(propertyName = "maxSession", propertyValue = "5")
})
public class AuditMDB implements MessageListener{
	@Override
	public void onMessage(Message message) {
		try {
			//message process
			//if(message instanceof TextMessage) {
			//	TextMessage txtMessage = (TextMessage) message;
			//	
			//	String text = txtMessage.getText();
			//	
			//	System.out.println("Iniciando processamento da mensagem - tiagokxuera...");
			//	Thread.sleep(5000);
			//	System.out.println("Mensagem recebida por HelloMDB - tiagokxuera: "+text);
			//	System.out.println("Finalizando processamento da mensagem - tiagokxuera...");
			//}
			//else {
			
				System.out.println("Just arrived a message from a queue. Let´s check what is this");
				//If arrived a message with an object Audit type:
				if(message instanceof ObjectMessage) {
					ObjectMessage objectMessage = (ObjectMessage)message;
					
					if(objectMessage.getObject() instanceof Audit) {
						Audit audit = (Audit) objectMessage.getObject();						
						System.out.println("Something changed in database...");
						System.out.println("Audit id: "+audit.getId());
						System.out.println("Product code: "+audit.getCode());
						System.out.println("Operation: "+audit.getOperation());
						System.out.println("Date: "+audit.getDate());	
					}
					else {
						System.out.println("Something arrived in queue, but it is not a Audit Object...");
					}
				}
				else {
					System.out.print("Couldn´t identify the type of message that just arrived...");
				}
			//}
			
		} catch(JMSException e) {
			e.printStackTrace();
		}
	}
}