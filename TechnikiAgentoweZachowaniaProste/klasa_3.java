
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
/**
 This example shows a minimal agent that just prints "Hallo World!"
 and then terminates.
 @author Giovanni Caire - TILAB
 */
public class klasa_3 extends Agent {

    protected void setup() {
        System.out.println(getLocalName()+" startuje");

        addBehaviour(new CyclicBehaviour(this) {
            public void action() {
                System.out.println("wykonuje- cykliczenie");
            }
        });
    }
    protected void takeDown(){
        System.out.println(""+getLocalName() +" zaraz sie usune!");

    }


}

