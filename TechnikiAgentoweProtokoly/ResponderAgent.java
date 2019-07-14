
import jade.core.Agent;
import jade.core.AID;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.proto.AchieveREResponder;
import jade.domain.FIPANames;
import jade.domain.FIPAAgentManagement.NotUnderstoodException;
import jade.domain.FIPAAgentManagement.RefuseException;
import jade.domain.FIPAAgentManagement.FailureException;

public class ResponderAgent extends Agent {

    protected void setup() {
        System.out.println("Agent "+getLocalName()+" waiting for requests...");
        MessageTemplate template = MessageTemplate.and(
                MessageTemplate.MatchProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST),
                MessageTemplate.MatchPerformative(ACLMessage.REQUEST) );

        addBehaviour(new AchieveREResponder(this, template) {
            protected ACLMessage prepareResponse(ACLMessage request) throws NotUnderstoodException, RefuseException {
                System.out.println("Agent "+getLocalName()+": REQUEST received from "+request.getSender().getName()+". Action is "+request.getContent());
                if (Integer.valueOf(request.getContent()) > 0) {
                    System.out.println("Agent "+getLocalName()+": Agree");


                    int x = Integer.valueOf(request.getContent());
                    System.out.printf("sqrt is"+ Math.sqrt(x));
                    ACLMessage agree = request.createReply();
                    agree.setPerformative(ACLMessage.AGREE);
                    return agree;
                }
                else {
                    System.out.println("Agent "+getLocalName()+": Refuse");
                    throw new RefuseException("check-failed");
                }
            }

            protected ACLMessage prepareResultNotification(ACLMessage request, ACLMessage response) throws FailureException {
                if (Integer.valueOf(request.getContent()) < 0) {
                    System.out.println("Agent "+getLocalName()+": Action successfully performed");
                    ACLMessage inform = request.createReply();
                    inform.setPerformative(ACLMessage.INFORM);
                    return inform;
                }
                else {
                    System.out.println("Agent "+getLocalName()+": Action failed");
                    throw new FailureException("unexpected-error");
                }
            }
        } );
    }
}

