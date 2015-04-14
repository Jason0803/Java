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

public class MyBMIAdmin {
    private int count = 0; // the number of times interfaces have been called

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

    // add a range into the system
    public boolean addRange(String user, String pwd, 
        String lower, String upper, String name, boolean normal) {
        count ++;

        // validate user and password
        if (!"admin".equals(user) || !"bodymass".equals(pwd)) {
            return false;
        }

        if (name == null) {
            return false;
        }
        name = name.toUpperCase();

        HashMap<String, String[]> ranges = getRanges();

        if (ranges.containsKey(name)) {
            // already exist
            return false;
        }

        name = name.toUpperCase();

        if (normal && getDesirable() != null) {
            // desirable range already set
            return false;
        }

        // covert the lower and upper to values
        double nlower = 0;
        double nupper = Double.MAX_VALUE;
        try {
            if (!"*".equals(lower)) {
                nlower = Double.parseDouble(lower);
            }
            if (!"*".equals(upper)) {
                nupper = Double.parseDouble(upper);
            }
            if (nlower < 0 || nupper < 0 || nlower > nupper) {
                // invalid range
                throw new Exception();
            }
        } catch (Exception e) {
            return false;
        }

        // make sure it does not overlap exsiting ones
        for (String e : ranges.keySet()) {
            String[] values = ranges.get(e);
            Double[] existing = toValue(values);
            if (nupper >= existing[0] && nlower <= existing[1]) {
                // overlapped
                return false;
            }
        }

        // add into the range
        // using 1 in the third value to indicate desirable range
        ranges.put(name, new String[] {lower, upper, normal ? "1" : ""});
        return true;
    }

    // delete the given range
    public boolean deleteRange(String user, String pwd, String name) {
        count ++;

        // validate user and password
        if (!"admin".equals(user) || !"bodymass".equals(pwd)) {
            return false;
        }

        if (name == null) {
            return false;
        }
        name = name.toUpperCase();

        // to make sure the range of given name exists
        HashMap<String, String[]>  ranges = getRanges();
        if (!ranges.containsKey(name)) {
            return false;
        }

        // now remove
        ranges.remove(name);
        return true;
    }

    // update the name of the range
    public boolean setName(String user, String pwd, String oldName, String newName) {
        count ++;

        // validate user and password
        if (!"admin".equals(user) || !"bodymass".equals(pwd)) {
            return false;
        }

        if (oldName == null || newName == null) {
            return false;
        }
        oldName = oldName.toUpperCase();
        newName = newName.toUpperCase();


        // make sure the range of given name exists
        HashMap<String, String[]>  ranges = getRanges();
        if (oldName == null || !ranges.containsKey(oldName)) {
            return false;
        }

        if (newName == null || newName.length() == 0 || ranges.containsKey(newName)) {
            // the new Name is already in the system
            return false;
        }

        // now update the name by first deleting then adding
        String[] value = ranges.remove(oldName);
        ranges.put(newName, value);
        return true;
    }

    // return the number of times any interface has been called.
    public int callCount(String user, String pwd) {
        // validate user and password
        if (!"admin".equals(user) || !"bodymass".equals(pwd)) {
            return -1;
        }
        return count;
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
