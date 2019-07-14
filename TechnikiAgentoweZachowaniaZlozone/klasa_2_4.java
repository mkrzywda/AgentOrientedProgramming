import jade.core.Agent;
import jade.core.behaviours.*;


public class klasa_2_4 extends Agent {

    private ThreadedBehaviourFactory tbf = new ThreadedBehaviourFactory();
    protected void setup() {
        System.out.println("Agent " + getLocalName() + " started.");

        Behaviour a = new CyclicBehaviour() {
            @Override
            public void action() {
                System.out.println("cyclic 1");

            }
        };

        Behaviour b = new CyclicBehaviour() {
            @Override
            public void action() {
                System.out.println("cyclic 2");

            }
        };

        addBehaviour(tbf.wrap(a));
        addBehaviour(tbf.wrap(b));

    }


}