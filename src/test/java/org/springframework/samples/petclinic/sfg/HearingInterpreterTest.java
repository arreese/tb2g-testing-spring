package org.springframework.samples.petclinic.sfg;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
//The lines below are telling the class that we want tp run with the Spring Runner
//And then our context configuration is pointing at the BaseConfig and the LaurelConfig
//So what happens now is Spring is going to wake up, look at the 2 config class,
//build the Spring Context, when it goees to execute this test, its going to
//Autowire a HearingInterpreter that has the Laurel Bean injected into it!
@ActiveProfiles("base-test")
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {BaseConfig.class, LaurelConfig.class})
public class HearingInterpreterTest {
    @Autowired
    HearingInterpreter hearingInterpreter;
//    Get rid of this because we want to allow the Spring Context
//    to manage this!
//    @Before
//    public void setUp() throws Exception {
//        hearingInterpreter = new HearingInterpreter(new LaurelWordProducer());
//    }

    @Test
    public void whatIHeard() {
        String word = hearingInterpreter.whatIHeard();

        assertEquals("Laurel", word);
    }
}