package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import states.DecimalTest;
import states.EndTest;
import states.IntegerTest;
import states.StartTest;
import states.StateTest;
import tests.actions.ContinuingFractionActionTest;
import tests.actions.ContinuingIntegerActionTest;
import tests.actions.NegateActionTest;
import tests.actions.StartFractionActionTest;
import tests.actions.ValueIsDigitActionTest;
import tests.verifiers.*;
import code.ConvertingMachineTest;
import code.InterimResultTest;


// Run all the tests in the program
@RunWith(Suite.class)
@Suite.SuiteClasses({
	
    InterimResultTest.class,
    ConvertingMachineTest.class,

    //  States
    StateTest.class,
    StartTest.class,
    IntegerTest.class, 
    DecimalTest.class,
    EndTest.class,

    
    //  Verifiers
    DigitInputVerifierTest.class,
    MinusInputVerifierTest.class,
    PeriodInputVerifierTest.class,
    PlusInputVerifierTest.class,
    
	//	Actions
	ContinuingFractionActionTest.class,
	ContinuingIntegerActionTest.class,
	NegateActionTest.class,
	StartFractionActionTest.class,
	ValueIsDigitActionTest.class,
})

public class AllTests{}
