import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class ag_pl extends Agent {
    protected void setup() {
        addBehaviour(new CyclicBehaviour(this) {
            @Override
            public void action() {
                MessageTemplate template = MessageTemplate.MatchLanguage("Polski");
                ACLMessage msg = receive(template);
                if (msg != null) {
                    System.out.println("Message " + msg.getContent());
                }
                else {
                    block();
                }
            }
        } );
    }
}