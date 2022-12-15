package com.binar.schedules.services;

import com.binar.schedules.dto.InvoiceData;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;


import java.io.FileNotFoundException;

public interface InvoiceService {
    JasperPrint generateInvoice(InvoiceData data)throws FileNotFoundException, JRException;
}
