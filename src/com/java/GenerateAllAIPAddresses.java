package com.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenerateAllAIPAddresses {

    int n;
    List<String> result = new ArrayList<String>();
    LinkedList<String> segments = new LinkedList<String>();

    public GenerateAllAIPAddresses(){}

    public List<String> restoreIpAddresses(String s) {

        return result;
    }

    private boolean valid(String s){
        if(s.length() >= 3){
            return false;
        }
        else{
            return s.charAt(0) != 0 ?(Integer.parseInt(s) <= 255) : s.length() == 1;
        }
    }

    private void update_output(int pos_index){
        String segment = s.substring(pos_index + 1, n);
    }
}
