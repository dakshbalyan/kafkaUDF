package udf_apspeed_violation;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;


@UdfDescription(
        name = "AP_SPEEDVIOLATIONCHECK",
        description = "Return 1 if AP Speed is greater than threshold otherwise 0",
        version = "0.1.0",
        author = "IOTINA"
)
public class RRM_apSPEED_violationCheck {
    @Udf(description = "calculate AP speed as Sum(radio.SUMTXBYTES)/(Curent TIMESTAMP - Previous TIMESTAMP)." +
            "Compare value with threshold and return result")
    public int ap_speed(
            @UdfParameter final double ap_speed,
            @UdfParameter final double dwnlinkthrghput_threshold
        ) {
        if(ap_speed >= dwnlinkthrghput_threshold)      //dwnlinkthrghput_threshold is in Mbps
            return 1;
        else
            return 0;
    }
}
