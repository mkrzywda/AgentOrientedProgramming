import jade.core.Agent;
import jade.core.AID;
import jade.lang.acl.ACLMessage;
import jade.proto.AchieveREInitiator;
import jade.domain.FIPANames;

import java.util.Date;
import java.util.Random;
import java.util.Vector;

public class InitiatorAgent extends Agent {
    private int nResponders;
    private Random random;
    private Integer messageNumber;

    protected void setup() {
        Object[] args = getArguments();
        random = new Random();
        if (args != null && args.length > 0) {
            nResponders = args.length;
            System.out.println("Requesting dummy-action to "+nResponders+" responders.");
            ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
            for (int i = 0; i < args.length; ++i) {
                msg.addReceiver(new AID((String) args[i], AID.ISLOCALNAME));
            }
            msg.setProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST);
            msg.setReplyByDate(new Date(System.currentTimeMillis() + 10000));

            messageNumber = (int)(Math.round(random.nextInt(200) -100));
            System.out.println("wyslana liczba = " + messageNumber);
            msg.setContent(Integer.toString(messageNumber));


            addBehaviour(new AchieveREInitiator(this, msg) {
                protected void handleInform(ACLMessage inform) {
                    System.out.println("Agent "+inform.getSender().getName()+" successfully performed the requested action");
                }
                protected void handleRefuse(ACLMessage refuse) {
                    System.out.println("Agent "+refuse.getSender().getName()+" refused to perform the requested action");
                    nResponders--;
                }
                protected void handleFailure(ACLMessage failure) {
                    if (failure.getSender().equals(myAgent.getAMS())) {
                        System.out.println("Responder does not exist");
                    }
                    else {
                        System.out.println("Agent "+failure.getSender().getName()+" failed to perform the requested action");
                    }
                }
                protected void handleAllResultNotifications(Vector notifications) {
                    if (notifications.size() < nResponders) {
                        System.out.println("Timeout expired: missing "+(nResponders - notifications.size())+" responses");
                    }
                }
            } );
        }
        else {
            System.out.println("No responder specified.");
        }
    }
}
