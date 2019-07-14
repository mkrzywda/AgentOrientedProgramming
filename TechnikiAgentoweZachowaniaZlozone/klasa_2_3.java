import jade.core.Agent;
import jade.core.behaviours.*;


public class klasa_2_3 extends Agent {

    protected void setup() {
        System.out.println("Agent " + getLocalName() + " started.");


        SequentialBehaviour sb = new SequentialBehaviour(this);
        sb.addSubBehaviour(new ThreeStepBehaviour());
        sb.addSubBehaviour(new ThreeStepBehaviour());
        sb.addSubBehaviour(new ThreeStepBehaviour());
        addBehaviour(sb);
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