package at.mic.cust.export.create;


import at.mic.cust.export.model.ExportInvoice;
import at.mic.cust.export.model.ExportPosition;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    @Transactional(value = Transactional.TxType.REQUIRED)
    public List<String> findPositionIds(String invoiceId) {
        ExportInvoice invoice = Optional.ofNullable(entityManager.find(ExportInvoice.class, Long.valueOf(invoiceId))).orElseGet(this::createNewInvoice);
        addLineToInvoice(invoice);
        entityManager.flush();


        return invoice.getPositions().stream()
                .map(ExportPosition::getSid)
                .map(String::valueOf)
                .collect(Collectors.toList());
    }

    private ExportInvoice createNewInvoice() {
        ExportInvoice invoice = new ExportInvoice();
        invoice.setCompany("01");
        invoice.setPlant("01");
        invoice.setInvoiceNumber("INV1");
        entityManager.persist(invoice);
        return invoice;
    }

    private void addLineToInvoice(ExportInvoice invoice) {
        long nextLineNunmber = invoice.getPositions().size() + 1;
        ExportPosition pos = new ExportPosition();
        pos.setInvoiceLineNumber(nextLineNunmber);
        pos.setShipmentLineNumber(nextLineNunmber);
        pos.setInvoice(invoice);
        invoice.getPositions().add(pos);
    }
}
