package org.binar.challenge4_bejava.services;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import org.binar.challenge4_bejava.dto.InvoiceData;

import java.io.FileNotFoundException;

public interface InvoiceService {
    JasperPrint generateInvoice(InvoiceData data)throws FileNotFoundException, JRException;
}
