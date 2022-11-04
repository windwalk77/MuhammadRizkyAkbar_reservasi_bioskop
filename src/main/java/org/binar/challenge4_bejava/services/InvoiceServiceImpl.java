package org.binar.challenge4_bejava.services;

import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.binar.challenge4_bejava.dto.InvoiceData;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class InvoiceServiceImpl implements InvoiceService {

    @Override
    public JasperPrint generateInvoice(InvoiceData data)throws FileNotFoundException, JRException {


        Map<String, Object> dataMap = dataParameter(data);
        List<InvoiceData> ordersCollect = new LinkedList<>();
        ordersCollect.add(data);
        dataMap.put("userData", new JRBeanCollectionDataSource(ordersCollect));
        JasperPrint jasperPrint = JasperFillManager.fillReport(
                JasperCompileManager.compileReport(
                        ResourceUtils.getFile("Invoice.jrxml")
                                .getAbsolutePath())
                , dataMap
                , new JREmptyDataSource()
        );
        log.info("Succesfully Generate Invoice");
        return jasperPrint;

    }

    public Map<String, Object> dataParameter(InvoiceData data) {
        String username = data.getUsername();
        String jamMulai = data.getJamMulai();
        String jamSelesai = data.getJamSelesai();
        String studio = data.getStudio();
        String namaFilm = data.getNamaFilm();
        String noKursi = data.getNoKursi();
        String tanggal = data.getTanggal();

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("username", username);
        dataMap.put("jamMulai", jamMulai);
        dataMap.put("jamSelesai", jamSelesai);
        dataMap.put("tanggal", tanggal);
        dataMap.put("studio", studio);
        dataMap.put("noKursi", noKursi);
        dataMap.put("namaFilm", namaFilm);
        dataMap.put("id", "1000");
        return dataMap;

    }
}
