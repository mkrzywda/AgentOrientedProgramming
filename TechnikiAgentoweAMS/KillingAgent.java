import jade.content.onto.basic.Action;
import jade.core.AID;
import jade.core.Agent;
import jade.core.ContainerID;
import jade.domain.FIPANames;
import jade.domain.JADEAgentManagement.CreateAgent;
import jade.domain.JADEAgentManagement.JADEManagementOntology;
import jade.domain.JADEAgentManagement.KillAgent;
import jade.lang.acl.ACLMessage;
import jade.proto.AchieveREInitiator;


public class KillingAgent extends Agent {

  public void setup() {

    getContentManager().registerLanguage(new jade.content.lang.sl.SLCodec(0));
    getContentManager().registerOntology(JADEManagementOntology.getInstance());

    KillAgent ka = new KillAgent();
    Action actExpr = new Action(getAMS(), ka);

    ka.setAgent(new AID("john", AID.ISLOCALNAME));

    ACLMessage request = new ACLMessage(ACLMessage.REQUEST);
    request.addReceiver(getAMS());
    request.setOntology(JADEManagementOntology.getInstance().getName());
    request.setLanguage(FIPANames.ContentLanguage.FIPA_SL0);
    request.setProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST);
    try {
      getContentManager().fillContent(request, actExpr);
      addBehaviour(new AchieveREInitiator(this, request) {
        protected void handleInform(ACLMessage inform) {
          System.out.println("Agent successfully created");
        }
        protected void handleFailure(ACLMessage failure) {
          System.out.println("Error creating agent.\n"+failure);
        }
      } );
    }


    catch (Exception e) {
      e.printStackTrace();
    }

}

}
