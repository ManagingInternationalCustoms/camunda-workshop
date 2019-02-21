package at.mic.bpm.camunda.service;

import java.util.List;

public interface InvoiceService {
    List<String> findPositionIds(String invoiceId);
}
