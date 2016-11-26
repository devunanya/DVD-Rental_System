/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.DVD.System;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

/**
 *
 * @author Ikwerreninja
 */
public class printJob implements Printable {
private String printjob;
    public printJob(String printjob){
        this.printjob = printjob;
    }
    @Override
    public int print(Graphics grphcs, PageFormat pf, int page) throws PrinterException {
       if (page > 0) { /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }
 
        /* User (0,0) is typically outside the imageable area, so we must
         * translate by the X and Y values in the PageFormat to avoid clipping
         */
        Graphics2D g2d = (Graphics2D)grphcs;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
 
        /* Now we perform our rendering */
        grphcs.drawString(printjob, 0, 500);
 
        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
    }
    
}
