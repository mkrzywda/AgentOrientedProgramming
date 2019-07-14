import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;

/**
 * This example shows the basic usage of JADE behaviours.<br>
 * More in details this agent executes a <code>CyclicBehaviour</code> that shows
 * a printout at each round and a generic behaviour that performs four successive
 * "dummy" operations. The second operation in particular involves adding a
 * <code>OneShotBehaviour</code>. When the generic behaviour completes the
 * agent terminates.
 * @author Giovanni Caire - TILAB
 */
public class klasa_4 extends Agent {

    protected void setup() {
        System.out.println("Agent " + getLocalName() + " started.");

        // Add the generic behaviour
        addBehaviour(new ThreeStepBehaviour());
    }

    private class ThreeStepBehaviour extends Behaviour {
        private int step = 1;
        public void action() {
            switch (step) {
                case 1:
                    System.out.println("krok 1");
                    break;
                case 2:
                    System.out.println("krok 2");
                    break;
                case 3:
                    System.out.println("krok 3");
                    break;
            }
            step++;
        }
        public boolean done() {
            return step == 4;
        }
    }
}