package sumTestUDF;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;

@UdfDescription(name = "sumTest",
        author = "daksh",
        version = "1.0",
        description = "A custom formula for sum")

public class udf_sumTest {
    @Udf(description = "The standard version of the formula with integer parameters.")
    public int sumTest(@UdfParameter int v1, @UdfParameter int v2) {
        return (v1 + v2);
    }
}
