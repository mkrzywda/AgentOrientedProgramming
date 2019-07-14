import jade.core.Agent;

/**
 This example shows a minimal agent that just prints "Hallo World!"
 and then terminates.
 @author Giovanni Caire - TILAB
 */
public class klasa_1 extends Agent {

    protected void setup() {
        System.out.println(getLocalName()+" startuje");

        // Make this agent terminate
    }
    protected void takeDown(){
        System.out.println(""+getLocalName() +" zaraz sie usune!");

    }

}

