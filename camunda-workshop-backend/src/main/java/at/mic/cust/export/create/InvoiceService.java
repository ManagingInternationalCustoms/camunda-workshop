package at.mic.cust.export.create;

import java.util.List;

public interface InvoiceService {
    List<String> findPositionIds(String invoiceId);
}
