package at.mic.cust.export.create;


import at.mic.cust.export.model.ExportInvoice;
import at.mic.cust.export.model.ExportPosition;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Named
public class InvoiceServiceImpl implements InvoiceService {

    @PersistenceContext(unitName = "at.mic.cust.export.PU")
    private EntityManager entityManager;

    public InvoiceServiceImpl() {
        super();
    }

    public InvoiceServiceImpl(EntityManager entityManager) {
        super();
        this.entityManager = entityManager;
    }

    @Override
    public List<String> findPositionIds(String invoiceId) {
        return
                Optional.of(entityManager.find(ExportInvoice.class, Long.valueOf(invoiceId)))
                        .map(ExportInvoice::getPositions)
                        .map(List::stream).orElseGet(Stream::empty)
                        .map(ExportPosition::getSid)
                        .map(String::valueOf)
                        .collect(Collectors.toList());
    }
}
