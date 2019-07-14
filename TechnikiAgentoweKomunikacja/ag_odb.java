import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class ag_odb extends Agent {
    protected void setup() {

        addBehaviour(new CyclicBehaviour(this) {
            @Override
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    ACLMessage reply = msg.createReply();
                    if (msg.getPerformative() == ACLMessage.REQUEST) {
                        reply.setPerformative(ACLMessage.INFORM);
                        reply.setContent("Wykonalem");
                    }
                    else {
                        reply.setPerformative(ACLMessage.NOT_UNDERSTOOD);
                        reply.setContent("Nie znam tego komunikatu");
                    }
                    myAgent.send(reply);
                }
                else {
                    block();
                }
            }
        } );
    }
}