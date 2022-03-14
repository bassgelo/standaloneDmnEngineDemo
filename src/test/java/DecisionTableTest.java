import org.camunda.bpm.dmn.engine.DmnDecision;
import org.camunda.bpm.dmn.engine.DmnDecisionResult;
import org.camunda.bpm.dmn.engine.DmnEngine;
import org.camunda.bpm.dmn.engine.test.DmnEngineRule;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.io.InputStream;

public class DecisionTableTest {

    @Rule
    public DmnEngineRule dmnEngineRule = new DmnEngineRule();

    @Test
    public void testTable() {
        DmnEngine dmnEngine = dmnEngineRule.getDmnEngine();

        // load DMN file
        InputStream inputStream = DecisionTableTest.class.getResourceAsStream("dish_decision_table.dmn");

        //create and add variables, this time using a class from the Camunda dependency
        VariableMap variables = Variables.createVariables();
        variables.putValue("season", "Summer");

        //parse or map the decision key to the file
        DmnDecision decision = dmnEngine.parseDecision("Decision_0u97qcw", inputStream);

        //evaluate the decision
        DmnDecisionResult result = dmnEngine.evaluateDecision(decision, variables);

        // assert the result
        Assert.assertEquals("Light Salad and a nice Steak", result.getFirstResult().get("dish"));

    }

}
