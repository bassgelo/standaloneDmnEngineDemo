import org.camunda.bpm.dmn.engine.DmnDecisionResult;
import org.camunda.bpm.dmn.engine.DmnEngine;
import org.camunda.bpm.dmn.engine.DmnEngineConfiguration;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ExternalDmnEngineMain {

    //A regular main class
    public static void main(String[] args) {

        //get the engine using the API from Camunda
        DmnEngineConfiguration configuration = DmnEngineConfiguration.createDefaultDmnEngineConfiguration();
        DmnEngine dmnEngine = configuration.buildEngine();

        //Prepare input data in a Map, pro tip: all variables in Camunda are stored in Maps
        Map variables = new HashMap();
        variables.put("season", "Summer");

        //read the file
        InputStream inputStream = ExternalDmnEngineMain.class.getResourceAsStream("dish_decision_table.dmn");

        //Call the table inside the file using the decision definition key, it is in the DRD view
        DmnDecisionResult result = dmnEngine.evaluateDecision("Decision_0u97qcw", inputStream, variables);

        //read output by getting the desired variable in the output result
        System.out.println(result.getFirstResult().get("dish"));
    }

}
