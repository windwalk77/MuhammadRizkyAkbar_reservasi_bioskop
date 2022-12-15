package com.binar.schedules.controllers;

import com.binar.schedules.dto.InvoiceData;
import com.binar.schedules.services.InvoiceServiceImpl;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@RestController
@SecurityRequirement(name = "Authorize")
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceServiceImpl invoiceService;

    @GetMapping("/generatePDF")
    public JasperPrint getInvoicePrint(HttpServletResponse response) throws IOException, JRException {
        InvoiceData data = tesData();

        JasperPrint jasperPrint = invoiceService.generateInvoice(data);
        response.setContentType("application/pdf");
        response.addHeader("Content-disposition", "attachment; filename=Invoice.pdf");
        OutputStream out = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint,out);
        return jasperPrint;
    }

    public InvoiceData tesData(){
        InvoiceData datas = new InvoiceData();
        datas.setUsername("Kiki");
        datas.setNamaFilm("Star Wars");
        datas.setStudio("2");
        datas.setNoKursi("A7");
        datas.setTanggal("20-10-2022");
        datas.setJamMulai("07:00");
        datas.setJamSelesai("10:00");
        return datas;
    }
}
