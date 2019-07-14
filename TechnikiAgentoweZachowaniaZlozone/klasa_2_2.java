import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import sun.nio.ch.PollArrayWrapper;


public class klasa_2_2 extends Agent {

    protected void setup() {
        System.out.println("Agent " + getLocalName() + " started.");


        ParallelBehaviour pb = new ParallelBehaviour(this,ParallelBehaviour.WHEN_ALL);
        pb.addSubBehaviour(new ThreeStepBehaviour());
        pb.addSubBehaviour(new ThreeStepBehaviour());
        pb.addSubBehaviour(new ThreeStepBehaviour());
        addBehaviour(pb);
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