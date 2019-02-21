package at.mic.bpm.camunda.impl;

import at.mic.bpm.camunda.service.InvoiceService;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Named
public class InvoiceServiceImpl implements InvoiceService {
    @Override
    public List<String> findPositionIds(String invoiceId) {
        List<String> result = new ArrayList<>(3);
        result.addAll(Arrays.asList(new String[]{"0815", "4711", "42"}));
        return result;
    }
}
