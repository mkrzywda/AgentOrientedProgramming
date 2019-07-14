import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

public class ag_wys extends Agent {

    protected void setup() {
        System.out.println("Agent " + getLocalName() + " started.");
        addBehaviour(new ThreeStepBehaviour());
    }

    private class ThreeStepBehaviour extends Behaviour {
        private int step = 1;

        public void action() {
            switch (step) {
                case 1:
                    System.out.println("krok 1");
                    ACLMessage aclMessage = new ACLMessage(ACLMessage.REQUEST);
                    aclMessage.addReceiver(new AID("Ala", AID.ISLOCALNAME));
                    send(aclMessage);
                    step++;
                    break;
                case 2:
                    System.out.println("krok 2");
                    ACLMessage msg = receive();
                    if (msg != null) {
                        System.out.println(msg.getContent());
                        doDelete();
                        step++;
                    }
                    else {
                        block();
                    }
                    break;
            }
        }
        public boolean done() {
            return step == 3;
        }
    }
}