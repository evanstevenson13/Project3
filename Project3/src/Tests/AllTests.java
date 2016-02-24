package Tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import Code.ConvertingMachineTest;
import Code.InterimResultTest;
import Tests.Actions.*;
import Tests.Verifiers.*;


@RunWith(Suite.class)
@Suite.SuiteClasses({
    InterimResultTest.class,
    ConvertingMachineTest.class,
//    	Actions
    ContinuingFractionActionTest.class,
    ContinuingIntegerActionTest.class,
    NegateActionTest.class,
    StartFractionActionTest.class,
    ValueIsDigitActionTest.class,
//    Verifiers
    DigitInputVerifierTest.class,
    MinusInputVerifierTest.class,
    PeriodInputVerifierTest.class,
    PlusInputVerifierTest.class,
})
public class AllTests{}
