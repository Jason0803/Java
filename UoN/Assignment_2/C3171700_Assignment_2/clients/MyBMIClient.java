/*
 * Name: Soo Young Choi
 * StdNo: 3171700
 * Course: SENG3400
 * Assignment title: Assignment 2
 * Due date: 10/10/2014
 */

import bmi.*;
import bmi.MyBMIServerStub;

public class MyBMIClient {

    public static void main(String[] args) {

        try {
            MyBMIServerStub stub1 = new MyBMIServerStub();
            MyBMIAdminStub stub2 = new MyBMIAdminStub();

            if ("calcBMI".equals(args[0])) {
                // generate a request
                MyBMIServerStub.CalcBMI request = new MyBMIServerStub.CalcBMI();
                request.setWeight(args[1]);
                request.setHeight(args[2]);

                // execute
                MyBMIServerStub.CalcBMIResponse response = stub1.calcBMI(request);
                
                // display the result
                System.out.println(response.get_return());
            }

            if ("listRanges".equals(args[0])) {
                // generate a request
                MyBMIServerStub.ListRanges request = new MyBMIServerStub.ListRanges();

                // execute
                MyBMIServerStub.ListRangesResponse response = stub1.listRanges(request);
                
                // display the result
                System.out.println(response.get_return());
            }

            if ("listWeights".equals(args[0])) {
                // generate a request
                MyBMIServerStub.ListWeights request = new MyBMIServerStub.ListWeights();
                request.setHeight(args[1]);

                // execute
                MyBMIServerStub.ListWeightsResponse response = stub1.listWeights(request);
                
                // display the result
                System.out.println(response.get_return());
            }

            if ("addRange".equals(args[0])) {
                // generate a request
                MyBMIAdminStub.AddRange request = new MyBMIAdminStub.AddRange();
                request.setUser(args[1]);
                request.setPwd(args[2]);
                request.setLower(args[3]);
                request.setUpper(args[4]);
                request.setName(args[5]);
                request.setNormal(Boolean.parseBoolean(args[6]));

                // execute
                MyBMIAdminStub.AddRangeResponse response = stub2.addRange(request);
                
                // display the result
                System.out.println(response.get_return());
            }

            if ("deleteRange".equals(args[0])) {
                // generate a request
                MyBMIAdminStub.DeleteRange request = new MyBMIAdminStub.DeleteRange();
                request.setUser(args[1]);
                request.setPwd(args[2]);
                request.setName(args[3]);

                // execute
                MyBMIAdminStub.DeleteRangeResponse response = stub2.deleteRange(request);
                
                // display the result
                System.out.println(response.get_return());
            }

            if ("setName".equals(args[0])) {
                // generate a request
                MyBMIAdminStub.SetName request = new MyBMIAdminStub.SetName();
                request.setUser(args[1]);
                request.setPwd(args[2]);
                request.setOldName(args[3]);
                request.setNewName(args[4]);

                // execute
                MyBMIAdminStub.SetNameResponse response = stub2.setName(request);
                
                // display the result
                System.out.println(response.get_return());
            }

            if ("callCount".equals(args[0])) {
                // generate a request
                MyBMIAdminStub.CallCount request = new MyBMIAdminStub.CallCount();
                request.setUser(args[1]);
                request.setPwd(args[2]);

                // execute
                MyBMIAdminStub.CallCountResponse response = stub2.callCount(request);
                
                // display the result
                System.out.println(response.get_return());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: incorrect parameter.");
        }
    }
}

