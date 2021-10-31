package cnvrtCurrUDF;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;

@UdfDescription(name = "cnvrt_inrtoyen",
        author = "daksh",
        version = "1.0",
        description = "A custom formula to convert inr to yen")

public class CnvrtCurr {
    @Udf(description = "The standard version of the formula with integer parameters.")
    public int cnvrt_inrtoyen(@UdfParameter int v1) {
        return (int) (v1 * 1.51);
    }
}
