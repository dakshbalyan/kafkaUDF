package diffTestUDF;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;

@UdfDescription(name = "diffTest",
        author = "daksh",
        description = "UDF for testing 2 udfs")

public class udf_diffTest {

    @Udf(description = "Standard formula for calculating difference")
    public int diffFormula(@UdfParameter int i, @UdfParameter int j){
        return i - j;
    }
}
