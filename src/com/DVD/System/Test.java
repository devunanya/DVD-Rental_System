/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.DVD.System;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Ikwerreninja
 */
public class Test {

public  Test(){
    
}
    public static void main(String[] args){
        Calendar cal = Calendar.getInstance();
    int month = cal.get(Calendar.MONTH);
    int year = cal.get(Calendar.YEAR);
    int day = cal.get(Calendar.DAY_OF_MONTH);
    String dated;
    dated = (String)(day+"/"+(month)+"/"+year);
    
    
         System.out.println(dated);
    }
}
