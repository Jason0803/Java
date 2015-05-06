/*
 * Name: Soo Young Choi
 * StdNo: 3171700
 * Course: SENG3400
 * Assignment title: Assignment 2
 * Due date: 10/10/2014
 */

import org.apache.axis2.context.MessageContext;
import org.apache.axis2.engine.AxisConfiguration;
import java.util.HashMap;

public class MyBMIServer {


    // a hash map is used to store the range
    // key is the name of the range
    // value is a triple of Strings (lower, upper, desirable) of the range
    // disirable != "" means true.
    // this hashmap is store in the service group context.
    private HashMap<String, String[]> getRanges() {
        MessageContext mc = MessageContext.getCurrentMessageContext();
        AxisConfiguration config = mc.getConfigurationContext().getAxisConfiguration();

        Object value = config.getParameterValue("ranges");

        if (value == null) {
            // not exist yet, add one into the context
            HashMap<String, String[]> ranges = new HashMap<String, String[]>();
            try {
                config.addParameter("ranges", ranges);
            } catch (Exception e) {
                // this is a fatal error, should not happen
                System.err.println("Error: could not add the ranges into the context.");
            }
            value = ranges;
        }

        return (HashMap<String, String[]>)value;
    }

    // calculate the BMI and classification for a given weight and height
    public String calcBMI(String weight, String height) {
        // parse the parameters to double
        // if format is error, return "UNDEFINED"
        double w = 0;
        double h = 0;
        
        try {
            w = Double.parseDouble(weight);
            h = Double.parseDouble(height);
            if (w <= 0 || h <= 0) {
                // negative weight or height
                throw new Exception();
            }
        } catch (Exception e) {
            return "UNDEFINED";
        }

        // now calculate the BMI and classification
        double BMI = w / (h * h);

        // get the range of this BMI
        // get ranges from the context
        HashMap<String, String[]> ranges = getRanges();

        for (String name : ranges.keySet()) {
            String[] values = ranges.get(name);
            Double[] bounds = toValue(values);

            if (BMI >= bounds[0] && BMI <= bounds[1]) {
                return String.format("%.2f %s", BMI, name);
            }
        }

        return "UNDEFINED";
    }

    // return all ranges 
    public String listRanges() {
        StringBuilder builder = new StringBuilder();
        // get ranges from the context
        HashMap<String, String[]> ranges = getRanges();

        for (String name : ranges.keySet()) {
            builder.append(name + "\n");
            /*
            String[] values = ranges.get(name);
            // see the description of getRanges functions to find out the structure
            // of values
            String info = String.format("%s %s-%s %s\n", 
                name, values[0], values[1],
                "".equals(values[2]) ? "" : "(desirable)");
            builder.append(info);
            */
        }

        if (ranges.size() == 0) {
            // no range has been defined
            builder.append("UNDEFINED\n");
        }

        return builder.toString();
    }

    // return the ideal lower and upper weights for the height
    public String listWeights(String height) {

        if (height == null || height.length() == 0) {
            return "UNDEFINED";
        }

        double nheight = 0;
        try {
            nheight = Double.parseDouble(height);
            if (nheight <= 0) {
                throw new Exception();
            }
        } catch (Exception e) {
            // invalid height parameter
            return "UNDEFINED";
        }

        // now find the desirable BMI range
        String desirable = getDesirable();

        if (desirable == null) { // the desirable range has not been defined
            return "UNDEFINED";
        }

        // get ranges from the context
        HashMap<String, String[]> ranges = getRanges();

        Double[] values = toValue((String[]) ranges.get(desirable));
        double lowerBMI = values[0];
        double upperBMI = values[1];

        double lowerWeight = lowerBMI * nheight * nheight;
        double upperWeight = upperBMI * nheight * nheight;

        return String.format("%.2f - %.2f", lowerWeight, upperWeight);
    }

    // a helper function that returns the name of the desirable range
    private String getDesirable() {
        HashMap<String, String[]> ranges = getRanges();

        for (String name : ranges.keySet()) {
            String[] values = ranges.get(name);
            if (!"".equals(values[2])) {
                // this is the desirable range
                return name;
            }
        }
        return null;
    }

    // return the lower and upper range of the given values
    private static Double[] toValue(String[] values) {
        String lower = values[0];
        String upper = values[1];

        double nlower = 0;
        double nupper = Double.MAX_VALUE;

        if (!"*".equals(lower)) {
            nlower = Double.parseDouble(lower);
        }

        if (!"*".equals(upper)) {
            nupper = Double.parseDouble(upper);
        }

        return new Double[] {nlower, nupper};
    }
}

