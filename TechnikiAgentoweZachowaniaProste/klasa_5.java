import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;

public class klasa_5 extends Agent {

    protected void setup() {
        System.out.println("Agent " + getLocalName() + " started.");

        addBehaviour(new OneShotBehaviour(this) {
            public void action() {
                System.out.println("pierwsze");
            }
        });
        // Add the generic behaviour
        addBehaviour(new ThreeStepBehaviour());
    }

    private class ThreeStepBehaviour extends Behaviour {
        private int step = 1;

        public void action() {
            switch (step) {
                case 1:
                    System.out.println("krok 1");
                    myAgent.addBehaviour(new OneShotBehaviour(myAgent) {
                    public void action() {
                        System.out.println("drugie");
                    }
                });
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
