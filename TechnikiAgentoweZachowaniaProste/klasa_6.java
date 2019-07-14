import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.core.behaviours.WakerBehaviour;


public class klasa_6 extends Agent {

    protected void setup() {
        System.out.println(getLocalName()+" startuje");

        addBehaviour(SmallTick);
        addBehaviour(BigTick);
        addBehaviour(RemoveAgent);
        addBehaviour(RemoveBeh);

    }
    protected void takeDown(){
        System.out.println(""+getLocalName() +" zaraz sie usune!");

    }

    public Behaviour SmallTick = new TickerBehaviour(this, 2000) {
        protected void onTick() {
            System.out.println("Maly Tick");
        }
    };

    public Behaviour BigTick = new TickerBehaviour(this, 5000) {
        protected void onTick() {
            System.out.println("Duzy Tick");
        }
    };

    public Behaviour RemoveAgent = new WakerBehaviour(this, 100000) {
        @Override
        protected void onWake(){
            System.out.println("Usuwam Agenta");
            myAgent.doDelete();
        }
    };

    public Behaviour RemoveBeh = new WakerBehaviour(this, 50000) {
        @Override
        protected void onWake(){
            System.out.println("Usuwam Zachowanie Big Tick");
            myAgent.removeBehaviour(BigTick);
        }
    };
}


