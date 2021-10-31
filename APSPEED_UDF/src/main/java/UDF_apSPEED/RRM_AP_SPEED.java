package UDF_apSPEED;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;

@UdfDescription(
        name = "ap_speed",
        description = "Return AP Speed in Mbps",
        version = "0.1.0",
        author = "IOTINA"
)

public class RRM_AP_SPEED {
    @Udf(description = "calculate AP speed as Sum(radio.SUMTXBYTES)/(Curent TIMESTAMP - Previous TIMESTAMP)")
    public double ap_speed(@UdfParameter final double sumTXbytes,
                           @UdfParameter final double currentTimestamp,
                           @UdfParameter final double prevTimestamp,
                           @UdfParameter final int collectionInterval) {

        double speed = 0;
        int icollectionInterval = collectionInterval;

        if (collectionInterval==0)
            icollectionInterval=1;
        //double speed = (sumTXbytes*8) / ((300)*1000);    //for 5 minutes
        if (currentTimestamp!=prevTimestamp)
            speed = (sumTXbytes*8) / (((currentTimestamp-prevTimestamp)/1000)*1000*1000);    //timestamp is in milliseconds
        else
            speed = (sumTXbytes*8) / ((icollectionInterval)*1000*1000);    //collectionInterval is in seconds
        return speed;
    }
}
