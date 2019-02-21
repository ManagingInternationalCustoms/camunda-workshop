package at.mic.cust.export.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * This class represents the JPA mapping for the export position (table
 * MIC_AUSPOS).
 */
@Entity
@Table(name = "MIC_AUSPOS")
@SequenceGenerator(name = "ExportPositionSeq", sequenceName = "MIC_AUSPOS_SEQ", allocationSize = 1)
public class ExportPosition {

    @Id
    @Column(name = "AFPSID", nullable = false, length = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ExportPositionSeq")
    private long sid;

    @Basic
    @Column(name = "AFPTYP", length = 1)
    private String type;

    @Basic
    @Column(name = "AFPVSSNR", length = 65)
    private String previousDocumentNumber;

    @Basic
    @Column(name = "AFPVSSART", length = 6)
    private String previousDocumentType;

    @Basic
    @Column(name = "afpempnr", length = 105)
    private String consigneeNr;

    @Basic
    @Column(name = "AFPEMPNAME", length = 105)
    private String consigneeName;

    @Basic
    @Column(name = "AFPEMPSTR", length = 80)
    private String consigneeStreet;

    @Basic
    @Column(name = "AFPEMPPLZ", length = 10)
    private String consigneeZip;

    @Basic
    @Column(name = "AFPEMPORT", length = 80)
    private String consigneeCity;

    @Basic
    @Column(name = "AFPEMPLD", length = 3)
    private String consigneeCountry;

    @Basic
    @Column(name = "AFPEMPTIN", length = 18)
    private String consigneeTin;

    @Basic
    @Column(name = "AFPEMPEORI", length = 17)
    private String consigneeEori;

    @Basic
    @Column(name = "AFPZUSCD1", length = 4)
    private String additionalCode1;

    @Basic
    @Column(name = "AFPZUSCD2", length = 4)
    private String additionalCode2;

    @Basic
    @Column(name = "AFPZUSCD3", length = 4)
    private String additionalCode3;

    @Basic
    @Column(name = "AFPNATCD1", length = 4)
    private String additionalNationalCode1;

    @Basic
    @Column(name = "AFPNATCD2", length = 4)
    private String additionalNationalCode2;

    @Basic
    @Column(name = "AFPNATCD3", length = 4)
    private String additionalNationalCode3;

    @Basic
    @Column(name = "AFPSTATWERT", length = 17, scale = 4)
    private BigDecimal statisticalValue;

    @Basic
    @Column(name = "AFPSUPUNIT", length = 4)
    private String unitOfMeasure;

    @Basic
    @Column(name = "AFPSUPQUANT", length = 13, scale = 3)
    private BigDecimal unitOfMeasureQuantity;

    @Basic
    @Column(name = "AFPGEFAHRNR", length = 4)
    private String dangerousGoodsCode;

    @Basic
    @Column(name = "AFPBEFKOSTEN", length = 4)
    private String transportCharges;

    @Basic
    @Column(name = "AFPSDGKENNNR", length = 4)
    private String commercialReferenceNumber;

    @Basic
    @Column(name = "AFPREGION", length = 50)
    private String departureRegion;

    @Basic
    @Column(name = "AFPEUCODE", length = 3)
    private String nationalProcedure;

    @Basic
    @Column(name = "AFPFAKTPOS", length = 4)
    private Long invoiceLineNumber;

    @Basic
    @Column(name = "AFPBELPOS", length = 5)
    private Long shipmentLineNumber;

    @Basic
    @Column(name = "AFPBSNR", length = 22)
    private String purchaseOrderNumber;

    @Basic
    @Column(name = "AFPBSDAT")
    @Temporal(TemporalType.DATE)
    private Date purchaseOrderDate;

    @Basic
    @Column(name = "AFPFRIST")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deadlineDate;

    @Basic
    @Column(name = "AFPLSNR", length = 15)
    private String deliveryNote;

    @Basic
    @Column(name = "AFPLSDAT")
    @Temporal(TemporalType.DATE)
    private Date deliveryNoteDate;

    @Basic
    @Column(name = "AFPARTNR", length = 30)
    private String partNumber;

    @Basic
    @Column(name = "AFPARTBEZ", length = 240)
    private String partDescription;

    @Basic
    @Column(name = "AFPPRODGR", length = 10)
    private String productGroup;

    @Basic
    @Column(name = "AFPTARNR", length = 13)
    private String tariffNumber;

    @Basic
    @Column(name = "AFPEIGMAS", length = 13, scale = 4)
    private BigDecimal netWeight;

    @Basic
    @Column(name = "AFPSERNR", length = 30)
    private String serialNumber;

    @Basic
    @Column(name = "AFPEIGMASEINZEL", length = 13, scale = 4)
    private BigDecimal netWeightSingle;

    @Basic
    @Column(name = "AFPROHMAS", length = 13, scale = 4)
    private BigDecimal grossWeight;

    @Basic
    @Column(name = "AFPMENGE", length = 13, scale = 3)
    private BigDecimal quantity;

    @Basic
    @Column(name = "AFPMEH", length = 4)
    private String quantityUnit;

    @Basic
    @Column(name = "AFPWERT", length = 17, scale = 4)
    private BigDecimal value;

    @Basic
    @Column(name = "AFPPREIS", length = 17, scale = 4)
    private BigDecimal price;

    @Basic
    @Column(name = "AFPBESM", length = 13, scale = 3)
    private BigDecimal statisticalQuantity;

    @Basic
    @Column(name = "AFPBESMEH", length = 4)
    private String statisticalQuantityUnit;

    @Basic
    @Column(name = "AFPBESMEHQ", length = 1)
    private String statisticalQuantityUomQualificator;

    @Basic
    @Column(name = "AFPURLD", length = 3)
    private String countryOfOrigin;

    @Basic
    @Column(name = "AFPAVCASE", length = 6)
    private String customsProcedureId;

    @Basic
    @Column(name = "AFPAVKZ", length = 7)
    private String customsProcedureCode;

    @Basic
    @Column(name = "AFPBESTZUKZ", length = 1)
    private String stockAdditionFlag;

    @Basic
    @Column(name = "AFPWPN", length = 6)
    private String preferenceDocumentType;

    @Basic
    @Column(name = "AFPWPZ", length = 2)
    private String preferenceDocumentFlag;

    @Basic
    @Column(name = "AFPWNR", length = 35)
    private String preferenceDocumentNumber;

    // @Basic
    // @Column(name = "AFPGSART", length = 2)
    // private String transactionType;

    @Basic
    @Column(name = "AFPREFWERT", length = 18, scale = 6)
    private BigDecimal referenceValue;

    @Basic
    @Column(name = "AFPREFWAE", length = 3)
    private String referenceCurrency;

    @Basic
    @Column(name = "AFPABART1", length = 10)
    private String additionalCostType1;

    @Basic
    @Column(name = "AFPABKZ1", length = 1)
    private String additionalCostFlag1;

    @Basic
    @Column(name = "AFPABWRT1", length = 13, scale = 4)
    private BigDecimal additionalCostValue1;

    @Basic
    @Column(name = "AFPABWAE1", length = 3)
    private String additionalCostCurrency1;

    @Basic
    @Column(name = "AFPABART2", length = 10)
    private String additionalCostType2;

    @Basic
    @Column(name = "AFPABKZ2", length = 1)
    private String additionalCostFlag2;

    @Basic
    @Column(name = "AFPABWRT2", length = 13, scale = 4)
    private BigDecimal additionalCostValue2;

    @Basic
    @Column(name = "AFPABWAE2", length = 3)
    private String additionalCostCurrency2;

    @Basic
    @Column(name = "AFPPREISTYP", length = 10)
    private String priceType;

    @Basic
    @Column(name = "AFPPREISDATE")
    @Temporal(TemporalType.DATE)
    private Date priceDate;

    @Basic
    @Column(name = "AFPPREISREFNO", length = 50)
    private String priceReferenceNumber;

    @Basic
    @Column(name = "AFPPREISSYS", length = 10)
    private String priceSystem;

    @Basic
    @Column(name = "AFPGRWERT", length = 17, scale = 4)
    private BigDecimal customsValue;

    @Basic
    @Column(name = "AFPLWWERT", length = 17, scale = 4)
    private BigDecimal invoiceValue;

    @Basic
    @Column(name = "AFPSTORNO", length = 1)
    private String cancel;

    @Basic
    @Column(name = "AFPVALID", length = 2)
    private String valid;

    @Basic
    @Column(name = "AFPMESSREGNR", length = 35)
    private String messageRegNumber;

    @Basic
    @Column(name = "AFPMESSREGNR2", length = 35)
    private String messageRegNumber2;

    @Basic
    @Column(name = "AFPMESSREGNR3", length = 35)
    private String messageRegNumber3;

    @Basic
    @Column(name = "AFPANNAHMEDAT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUAM;

    @Basic
    @Column(name = "AFPUSER", length = 12)
    private String modificationUser;

    @Basic
    @Column(name = "AFPUSEDAT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;

    @Basic
    @Column(name = "AFPCREUSER", length = 12)
    private String creationUser;

    @Basic
    @Column(name = "AFPCREDAT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Basic
    @Column(name = "AFPMESSREFNR", length = 22)
    private String messageRefNumber1;

    @Basic
    @Column(name = "AFPMESSREFNR2", length = 22)
    private String messageRefNumber2;

    @Basic
    @Column(name = "AFPMESSREFNR3", length = 22)
    private String messageRefNumber3;

    @Basic
    @Column(name = "AFPINFO", length = 80)
    private String infoText;

    @Basic
    @Column(name = "afptext1", length = 400)
    private String text1;

    @Basic
    @Column(name = "afptext2", length = 400)
    private String text2;

    @Basic
    @Column(name = "afptext3", length = 400)
    private String text3;

    @Basic
    @Column(name = "afptext4", length = 400)
    private String text4;

    @Basic
    @Column(name = "afptext5", length = 400)
    private String text5;

    @Basic
    @Column(name = "afptext6", length = 400)
    private String text6;

    @Basic
    @Column(name = "afptext7", length = 400)
    private String text7;

    @Basic
    @Column(name = "afptext8", length = 400)
    private String text8;

    @Basic
    @Column(name = "afptext9", length = 400)
    private String text9;

    @Basic
    @Column(name = "afptext10", length = 400)
    private String text10;

    @Basic
    @Column(name = "afptext11", length = 400)
    private String text11;

    @Basic
    @Column(name = "afptext12", length = 400)
    private String text12;

    @Basic
    @Column(name = "afptext13", length = 400)
    private String text13;

    @Basic
    @Column(name = "afptext14", length = 400)
    private String text14;

    @Basic
    @Column(name = "afptext15", length = 400)
    private String text15;

    @Basic
    @Column(name = "afpnum1", length = 15, scale = 4)
    private BigDecimal customerNumber1;

    @Basic
    @Column(name = "afpnum2", length = 15, scale = 4)
    private BigDecimal customerNumber2;

    @Basic
    @Column(name = "afpnum3", length = 15, scale = 4)
    private BigDecimal customerNumber3;

    @Basic
    @Column(name = "afpnum4", length = 15, scale = 4)
    private BigDecimal customerNumber4;

    @Basic
    @Column(name = "afpnum5", length = 15, scale = 4)
    private BigDecimal customerNumber5;

    @Basic
    @Column(name = "afpnum6", length = 15, scale = 4)
    private BigDecimal customerNumber6;

    @Basic
    @Column(name = "afpnum7", length = 15, scale = 4)
    private BigDecimal customerNumber7;

    @Basic
    @Column(name = "afpnum8", length = 15, scale = 4)
    private BigDecimal customerNumber8;

    @Basic
    @Column(name = "afpnum9", length = 15, scale = 4)
    private BigDecimal customerNumber9;

    @Basic
    @Column(name = "afpnum10", length = 15, scale = 4)
    private BigDecimal customerNumber10;

    @Basic
    @Column(name = "afpnum11", length = 15, scale = 4)
    private BigDecimal customerNumber11;

    @Basic
    @Column(name = "afpnum12", length = 15, scale = 4)
    private BigDecimal customerNumber12;

    @Basic
    @Column(name = "afpnum13", length = 15, scale = 4)
    private BigDecimal customerNumber13;

    @Basic
    @Column(name = "afpnum14", length = 15, scale = 4)
    private BigDecimal customerNumber14;

    @Basic
    @Column(name = "afpnum15", length = 15, scale = 4)
    private BigDecimal customerNumber15;

    @Basic
    @Column(name = "afpdate1")
    @Temporal(TemporalType.TIMESTAMP)
    private Date customerDate1;

    @Basic
    @Column(name = "afpdate2")
    @Temporal(TemporalType.TIMESTAMP)
    private Date customerDate2;

    @Basic
    @Column(name = "afpdate3")
    @Temporal(TemporalType.TIMESTAMP)
    private Date customerDate3;

    @Basic
    @Column(name = "afpdate4")
    @Temporal(TemporalType.TIMESTAMP)
    private Date customerDate4;

    @Basic
    @Column(name = "afpdate5")
    @Temporal(TemporalType.TIMESTAMP)
    private Date customerDate5;

    @Basic
    @Column(name = "afpdate6")
    @Temporal(TemporalType.TIMESTAMP)
    private Date customerDate6;

    @Basic
    @Column(name = "afpdate7")
    @Temporal(TemporalType.TIMESTAMP)
    private Date customerDate7;

    @Basic
    @Column(name = "afpdate8")
    @Temporal(TemporalType.TIMESTAMP)
    private Date customerDate8;

    @Basic
    @Column(name = "afpdate9")
    @Temporal(TemporalType.TIMESTAMP)
    private Date customerDate9;

    @Basic
    @Column(name = "afpdate10")
    @Temporal(TemporalType.TIMESTAMP)
    private Date customerDate10;

    @Basic
    @Column(name = "afpdate11")
    @Temporal(TemporalType.TIMESTAMP)
    private Date customerDate11;

    @Basic
    @Column(name = "afpdate12")
    @Temporal(TemporalType.TIMESTAMP)
    private Date customerDate12;

    @Basic
    @Column(name = "afpdate13")
    @Temporal(TemporalType.TIMESTAMP)
    private Date customerDate13;

    @Basic
    @Column(name = "afpdate14")
    @Temporal(TemporalType.TIMESTAMP)
    private Date customerDate14;

    @Basic
    @Column(name = "afpdate15")
    @Temporal(TemporalType.TIMESTAMP)
    private Date customerDate15;

    @Basic
    @Column(name = "afpflag1", length = 1)
    private String customerFlag1;

    @Basic
    @Column(name = "afpflag2", length = 1)
    private String customerFlag2;

    @Basic
    @Column(name = "afpflag3", length = 1)
    private String customerFlag3;

    @Basic
    @Column(name = "afpflag4", length = 1)
    private String customerFlag4;

    @Basic
    @Column(name = "afpflag5", length = 1)
    private String customerFlag5;

    @Basic
    @Column(name = "afpflag6", length = 1)
    private String customerFlag6;

    @Basic
    @Column(name = "afpflag7", length = 1)
    private String customerFlag7;

    @Basic
    @Column(name = "afpflag8", length = 1)
    private String customerFlag8;

    @Basic
    @Column(name = "afpflag9", length = 1)
    private String customerFlag9;

    @Basic
    @Column(name = "afpflag10", length = 1)
    private String customerFlag10;

    @Basic
    @Column(name = "afpflag11", length = 1)
    private String customerFlag11;

    @Basic
    @Column(name = "afpflag12", length = 1)
    private String customerFlag12;

    @Basic
    @Column(name = "afpflag13", length = 1)
    private String customerFlag13;

    @Basic
    @Column(name = "afpflag14", length = 1)
    private String customerFlag14;

    @Basic
    @Column(name = "afpflag15", length = 1)
    private String customerFlag15;

    // INTGR-714
    @Basic
    @Column(name = "AFPSENDENDUSERINEAM", length = 1)
    private String endUserInEam;

    @Version
    @Basic
    @Column(name = "AFPLOCKVERSION", length = 1, nullable = false)
    private long lockVersion;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "AFPAFKSID")
    private ExportInvoice invoice;

    @Basic
    @Column(name = "AFPMESSSSTATUS", length = 2)
    private String sendStatus;

    @Basic
    @Column(name = "AFPMESSRSTATUS", length = 2)
    private String responseStatus;

    @Basic
    @Column(name = "AFPGSART", length = 2)
    private String typeOfTrade;

    // INTGR-510 new fields
    @Basic
    @Column(name = "AFPENDUSERID", length = 1)
    private String consigneeEndUserFlag;

    @Basic
    @Column(name = "AFPEMPBRANCHNO", length = 4)
    private String receiverBranchNo;

    @Basic
    @Column(name = "AFPEUSERTIN", length = 17)
    private String addrTin;

    @Basic
    @Column(name = "AFPEUSERBRANCHNO", length = 4)
    private String userBranchNo;

    @Basic
    @Column(name = "AFPEUSERNM1", length = 120)
    private String eUserName;

    @Basic
    @Column(name = "AFPEUSERCITY", length = 35)
    private String userAddrLoc;

    @Basic
    @Column(name = "AFPEUSERSTREET", length = 70)
    private String userAddrStreet;

    @Basic
    @Column(name = "AFPEUSERZIP", length = 10)
    private String userAddrZip;

    @Basic
    @Column(name = "AFPEUSERCOUNTRY", length = 2)
    private String userAddrCountry;

    @Basic
    @Column(name = "AFPEUSEREORI", length = 17)
    private String userAddrEori;

    @Basic
    @Column(name = "AFPALICODE", length = 3)
    private String termsOfDeliveryCode;

    @Basic
    @Column(name = "AFPALIBEZ", length = 35)
    private String termsOfDeliveryDesc;

    @Basic
    @Column(name = "afpeusernr", length = 15)
    private String userNr;

    @Basic
    @Column(name = "afpstornodat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date stornoDate;

    @Basic
    @Column(name = "afpbegweitdat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date furtherProcessingDate;

    @Basic
    @Column(name = "afpgrund", length = 350)
    private String reason;

    @Basic
    @Column(name = "afpueberlassdat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliverDate;

    @Basic
    @Column(name = "afpausfuhrdat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date exportDate;

    @Basic
    @Column(name = "AFPBESTABKZ", length = 1)
    private String stockDeductionFlag;

    @Basic
    @Column(name = "AFPWERTMETH", length = 2)
    private String valuationMethod;

    @Basic
    @Column(name = "afpregstatus", length = 2)
    private String registrationStatus;

    @Basic
    @Column(name = "AFPBZUAB1", length = 17, scale = 4)
    private BigDecimal additionalCosts1;

    @Basic
    @Column(name = "AFPAGREEMENT", length = 10)
    private String agreement;

    @Basic
    @Column(name = "AFPBESTART1", length = 20)
    private String stockTypeAdd;

    @Basic
    @Column(name = "AFPBESTART2", length = 20)
    private String stockTypeDed;

    @Basic
    @Column(name = "AFPREZNR", length = 40)
    private String bomNumber;

    @Basic
    @Column(name = "AFPREZVAR", length = 10)
    private String bomVar;

    @Basic
    @Column(name = "AFPKONTO", length = 50)
    private String accountNumber;

    @Basic
    @Column(name = "AFPENTGEGENNAHMEDAT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate;

    @Basic
    @Column(name = "AFPABLEHNDAT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rejectionDate;

    @Basic
    @Column(name = "AFPEXIT", length = 1)
    private String exit;

    @Basic
    @Column(name = "AFPZPTERL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date completionDate;

    @Basic
    @Column(name = "AFPVERPACKANF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date packBeginDate;

    @Basic
    @Column(name = "AFPVERPACKEND")
    @Temporal(TemporalType.TIMESTAMP)
    private Date packEndDate;

    @Basic
    @Column(name = "AFPMESSGROUPNR")
    private BigDecimal messageGroupNumber;

    @Basic
    @Column(name = "AFPMODEL", length = 40)
    private String model;

    @Basic
    @Column(name = "AFPBRAND", length = 40)
    private String brand;

    @Basic
    @Column(name = "AFPWATERMARK", length = 2)
    private String watermark;

    @Basic
    @Column(name = "AFPSHPWATERMARK", length = 2)
    private String shipmentWatermark;

    @Basic
    @Column(name = "AFPECCNBR", length = 50)
    private String exportControlClassficationNumber;

    /**
     * Constructs a new {@code ExportPosition} instance.
     */
    public ExportPosition() {
        super();
    }

    public String getConsigneeName() {
        return this.consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public String getConsigneeStreet() {
        return this.consigneeStreet;
    }

    public void setConsigneeStreet(String consigneeStreet) {
        this.consigneeStreet = consigneeStreet;
    }

    public String getConsigneeZip() {
        return this.consigneeZip;
    }

    public void setConsigneeZip(String consigneeZip) {
        this.consigneeZip = consigneeZip;
    }

    public String getConsigneeCity() {
        return this.consigneeCity;
    }

    public void setConsigneeCity(String consigneeCity) {
        this.consigneeCity = consigneeCity;
    }

    public String getConsigneeCountry() {
        return this.consigneeCountry;
    }

    public void setConsigneeCountry(String consigneeCountry) {
        this.consigneeCountry = consigneeCountry;
    }

    public String getConsigneeEori() {
        return this.consigneeEori;
    }

    public void setConsigneeEori(String consigneeEori) {
        this.consigneeEori = consigneeEori;
    }

    public String getConsigneeTin() {
        return this.consigneeTin;
    }

    public void setConsigneeTin(String consigneeTin) {
        this.consigneeTin = consigneeTin;
    }

    public String getDangerousGoodsCode() {
        return this.dangerousGoodsCode;
    }

    public void setDangerousGoodsCode(String dangerousGoodsCode) {
        this.dangerousGoodsCode = dangerousGoodsCode;
    }

    public String getTransportCharges() {
        return this.transportCharges;
    }

    public void setTransportCharges(String transportCharges) {
        this.transportCharges = transportCharges;
    }

    public String getCommercialReferenceNumber() {
        return this.commercialReferenceNumber;
    }

    public void setCommercialReferenceNumber(String commercialReferenceNumber) {
        this.commercialReferenceNumber = commercialReferenceNumber;
    }

    public long getSid() {
        return this.sid;
    }

    public void setSid(long sid) {
        this.sid = sid;
    }

    public Long getInvoiceLineNumber() {
        return this.invoiceLineNumber;
    }

    public void setInvoiceLineNumber(Long invoiceLineNumber) {
        this.invoiceLineNumber = invoiceLineNumber;
    }

    public Long getShipmentLineNumber() {
        return this.shipmentLineNumber;
    }

    public void setShipmentLineNumber(Long shipmentLineNumber) {
        this.shipmentLineNumber = shipmentLineNumber;
    }

    public String getPurchaseOrderNumber() {
        return this.purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public Date getPurchaseOrderDate() {
        return this.purchaseOrderDate;
    }

    public void setPurchaseOrderDate(Date purchaseOrderDate) {
        this.purchaseOrderDate = purchaseOrderDate;
    }

    public String getDeliveryNote() {
        return this.deliveryNote;
    }

    public void setDeliveryNote(String deliveryNote) {
        this.deliveryNote = deliveryNote;
    }

    public Date getDeliveryNoteDate() {
        return this.deliveryNoteDate;
    }

    public void setDeliveryNoteDate(Date deliveryNoteDate) {
        this.deliveryNoteDate = deliveryNoteDate;
    }

    public String getPartNumber() {
        return this.partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartDescription() {
        return this.partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public String getProductGroup() {
        return this.productGroup;
    }

    public void setProductGroup(String productGroup) {
        this.productGroup = productGroup;
    }

    public String getTariffNumber() {
        return this.tariffNumber;
    }

    public void setTariffNumber(String tariffNumber) {
        this.tariffNumber = tariffNumber;
    }

    public BigDecimal getNetWeight() {
        return this.netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    public BigDecimal getNetWeightSingle() {
        return this.netWeightSingle;
    }

    public void setNetWeightSingle(BigDecimal netWeightSingle) {
        this.netWeightSingle = netWeightSingle;
    }

    public BigDecimal getGrossWeight() {
        return this.grossWeight;
    }

    public void setGrossWeight(BigDecimal grossWeight) {
        this.grossWeight = grossWeight;
    }

    public BigDecimal getQuantity() {
        return this.quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getQuantityUnit() {
        return this.quantityUnit;
    }

    public void setQuantityUnit(String quantityUnit) {
        this.quantityUnit = quantityUnit;
    }

    public BigDecimal getValue() {
        return this.value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getStatisticalQuantity() {
        return this.statisticalQuantity;
    }

    public void setStatisticalQuantity(BigDecimal statisticalQuantity) {
        this.statisticalQuantity = statisticalQuantity;
    }

    public String getStatisticalQuantityUnit() {
        return this.statisticalQuantityUnit;
    }

    public void setStatisticalQuantityUnit(String statisticalQuantityUnit) {
        this.statisticalQuantityUnit = statisticalQuantityUnit;
    }

    public String getCountryOfOrigin() {
        return this.countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getCustomsProcedureId() {
        return this.customsProcedureId;
    }

    public void setCustomsProcedureId(String customsProcedureId) {
        this.customsProcedureId = customsProcedureId;
    }

    public String getCustomsProcedureCode() {
        return this.customsProcedureCode;
    }

    public void setCustomsProcedureCode(String customsProcedureCode) {
        this.customsProcedureCode = customsProcedureCode;
    }

    public String getStockAdditionFlag() {
        return stockAdditionFlag;
    }

    public void setStockAdditionFlag(String stockAdditionFlag) {
        this.stockAdditionFlag = stockAdditionFlag;
    }

    public String getPreferenceDocumentType() {
        return this.preferenceDocumentType;
    }

    public void setPreferenceDocumentType(String preferenceDocumentType) {
        this.preferenceDocumentType = preferenceDocumentType;
    }

    public String getPreferenceDocumentFlag() {
        return this.preferenceDocumentFlag;
    }

    public void setPreferenceDocumentFlag(String preferenceDocumentFlag) {
        this.preferenceDocumentFlag = preferenceDocumentFlag;
    }

    public String getPreferenceDocumentNumber() {
        return this.preferenceDocumentNumber;
    }

    public void setPreferenceDocumentNumber(String preferenceDocumentNumber) {
        this.preferenceDocumentNumber = preferenceDocumentNumber;
    }

    // public String getTransactionType() {
    // return this.transactionType;
    // }
    //
    // public void setTransactionType(String transactionType) {
    // this.transactionType = transactionType;
    // }

    public BigDecimal getReferenceValue() {
        return this.referenceValue;
    }

    public void setReferenceValue(BigDecimal referenceValue) {
        this.referenceValue = referenceValue;
    }

    public String getReferenceCurrency() {
        return this.referenceCurrency;
    }

    public void setReferenceCurrency(String referenceCurrency) {
        this.referenceCurrency = referenceCurrency;
    }

    public String getAdditionalCostType1() {
        return this.additionalCostType1;
    }

    public void setAdditionalCostType1(String additionalCostType1) {
        this.additionalCostType1 = additionalCostType1;
    }

    public String getAdditionalCostFlag1() {
        return this.additionalCostFlag1;
    }

    public void setAdditionalCostFlag1(String additionalCostFlag1) {
        this.additionalCostFlag1 = additionalCostFlag1;
    }

    public BigDecimal getAdditionalCostValue1() {
        return this.additionalCostValue1;
    }

    public void setAdditionalCostValue1(BigDecimal additionalCostValue1) {
        this.additionalCostValue1 = additionalCostValue1;
    }

    public String getAdditionalCostCurrency1() {
        return this.additionalCostCurrency1;
    }

    public void setAdditionalCostCurrency1(String additionalCostCurrency1) {
        this.additionalCostCurrency1 = additionalCostCurrency1;
    }

    public String getAdditionalCostType2() {
        return this.additionalCostType2;
    }

    public void setAdditionalCostType2(String additionalCostType2) {
        this.additionalCostType2 = additionalCostType2;
    }

    public String getAdditionalCostFlag2() {
        return this.additionalCostFlag2;
    }

    public void setAdditionalCostFlag2(String additionalCostFlag2) {
        this.additionalCostFlag2 = additionalCostFlag2;
    }

    public BigDecimal getAdditionalCostValue2() {
        return this.additionalCostValue2;
    }

    public void setAdditionalCostValue2(BigDecimal additionalCostValue2) {
        this.additionalCostValue2 = additionalCostValue2;
    }

    public String getAdditionalCostCurrency2() {
        return this.additionalCostCurrency2;
    }

    public void setAdditionalCostCurrency2(String additionalCostCurrency2) {
        this.additionalCostCurrency2 = additionalCostCurrency2;
    }

    public String getPriceType() {
        return this.priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    public Date getPriceDate() {
        return this.priceDate;
    }

    public void setPriceDate(Date priceDate) {
        this.priceDate = priceDate;
    }

    public String getPriceReferenceNumber() {
        return this.priceReferenceNumber;
    }

    public void setPriceReferenceNumber(String priceReferenceNumber) {
        this.priceReferenceNumber = priceReferenceNumber;
    }

    public String getPriceSystem() {
        return this.priceSystem;
    }

    public void setPriceSystem(String priceSystem) {
        this.priceSystem = priceSystem;
    }

    public BigDecimal getCustomsValue() {
        return this.customsValue;
    }

    public void setCustomsValue(BigDecimal customsValue) {
        this.customsValue = customsValue;
    }

    public BigDecimal getInvoiceValue() {
        return this.invoiceValue;
    }

    public void setInvoiceValue(BigDecimal invoiceValue) {
        this.invoiceValue = invoiceValue;
    }

    public String getCancel() {
        return this.cancel;
    }

    public void setCancel(String cancel) {
        this.cancel = cancel;
    }

    public String getValid() {
        return this.valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getMessageRegNumber() {
        return this.messageRegNumber;
    }

    public void setMessageRegNumber(String messageRegNumber) {
        this.messageRegNumber = messageRegNumber;
    }

    public Date getDateUAM() {
        return this.dateUAM;
    }

    public void setDateUAM(Date dateUAM) {
        this.dateUAM = dateUAM;
    }

    public String getModificationUser() {
        return this.modificationUser;
    }

    public void setModificationUser(String modificationUser) {
        this.modificationUser = modificationUser;
    }

    public Date getModificationDate() {
        return this.modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getCreationUser() {
        return this.creationUser;
    }

    public void setCreationUser(String creationUser) {
        this.creationUser = creationUser;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return the lockVersion
     */
    public long getLockVersion() {
        return this.lockVersion;
    }

    /**
     * @param lockVersion the lockVersion to set
     */
    public void setLockVersion(long lockVersion) {
        this.lockVersion = lockVersion;
    }

    public ExportInvoice getInvoice() {
        return this.invoice;
    }

    public void setInvoice(ExportInvoice invoice) {
        this.invoice = invoice;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }


    public String getSendStatus() {
        return this.sendStatus;
    }


    public void setSendStatus(String sendStatus) {
        this.sendStatus = sendStatus;
    }


    public String getResponseStatus() {
        return this.responseStatus;
    }


    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getTypeOfTrade() {
        return this.typeOfTrade;
    }

    public void setTypeOfTrade(String typeOfTrade) {
        this.typeOfTrade = typeOfTrade;
    }

    public String getDepartureRegion() {
        return this.departureRegion;
    }

    public void setDepartureRegion(String departureRegion) {
        this.departureRegion = departureRegion;
    }

    public String getNationalProcedure() {
        return this.nationalProcedure;
    }

    public void setNationalProcedure(String nationalProcedure) {
        this.nationalProcedure = nationalProcedure;
    }

    public BigDecimal getStatisticalValue() {
        return this.statisticalValue;
    }

    public void setStatisticalValue(BigDecimal statisticalValue) {
        this.statisticalValue = statisticalValue;
    }

    public String getUnitOfMeasure() {
        return this.unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public BigDecimal getUnitOfMeasureQuantity() {
        return this.unitOfMeasureQuantity;
    }

    public void setUnitOfMeasureQuantity(BigDecimal unitOfMeasureQuantity) {
        this.unitOfMeasureQuantity = unitOfMeasureQuantity;
    }

    public String getAdditionalCode1() {
        return this.additionalCode1;
    }

    public void setAdditionalCode1(String additionalCode1) {
        this.additionalCode1 = additionalCode1;
    }

    public String getAdditionalCode2() {
        return this.additionalCode2;
    }

    public void setAdditionalCode2(String additionalCode2) {
        this.additionalCode2 = additionalCode2;
    }

    public String getAdditionalCode3() {
        return this.additionalCode3;
    }

    public void setAdditionalCode3(String additionalCode3) {
        this.additionalCode3 = additionalCode3;
    }

    public String getAdditionalNationalCode1() {
        return this.additionalNationalCode1;
    }

    public void setAdditionalNationalCode1(String additionalNationalCode1) {
        this.additionalNationalCode1 = additionalNationalCode1;
    }

    public String getAdditionalNationalCode2() {
        return this.additionalNationalCode2;
    }

    public void setAdditionalNationalCode2(String additionalNationalCode2) {
        this.additionalNationalCode2 = additionalNationalCode2;
    }

    public String getAdditionalNationalCode3() {
        return this.additionalNationalCode3;
    }

    public void setAdditionalNationalCode3(String additionalNationalCode3) {
        this.additionalNationalCode3 = additionalNationalCode3;
    }


    public String getMessageRefNumber1() {
        return this.messageRefNumber1;
    }


    public void setMessageRefNumber1(String messageRefNumber1) {
        this.messageRefNumber1 = messageRefNumber1;
    }


    public String getMessageRefNumber2() {
        return this.messageRefNumber2;
    }


    public void setMessageRefNumber2(String messageRefNumber2) {
        this.messageRefNumber2 = messageRefNumber2;
    }


    public String getRegistrationNumber1() {
        return this.getMessageRegNumber();
    }


    public void setRegistrationNumber1(String registrationNumber1) {
        this.setMessageRegNumber(registrationNumber1);
    }


    public String getRegistrationNumber2() {
        return this.getMessageRegNumber2();
    }


    public void setRegistrationNumber2(String registrationNumber2) {
        this.setRegistrationNumber2(registrationNumber2);
    }

    public String getMessageRefNumber3() {
        return this.messageRefNumber3;
    }

    public void setMessageRefNumber3(String messageRefNumber3) {
        this.messageRefNumber3 = messageRefNumber3;
    }

    public String getConsigneeNr() {
        return this.consigneeNr;
    }

    public void setConsigneeNr(String consigneeNr) {
        this.consigneeNr = consigneeNr;
    }

    public String getMessageRegNumber2() {
        return this.messageRegNumber2;
    }

    public void setMessageRegNumber2(String messageRegNumber2) {
        this.messageRegNumber2 = messageRegNumber2;
    }

    public String getMessageRegNumber3() {
        return this.messageRegNumber3;
    }

    public void setMessageRegNumber3(String messageRegNumber3) {
        this.messageRegNumber3 = messageRegNumber3;
    }

    public String getText1() {
        return this.text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return this.text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText3() {
        return this.text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public String getText4() {
        return this.text4;
    }

    public void setText4(String text4) {
        this.text4 = text4;
    }

    public String getText5() {
        return this.text5;
    }

    public void setText5(String text5) {
        this.text5 = text5;
    }

    public String getText6() {
        return this.text6;
    }

    public void setText6(String text6) {
        this.text6 = text6;
    }

    public String getText7() {
        return this.text7;
    }

    public void setText7(String text7) {
        this.text7 = text7;
    }

    public String getText8() {
        return this.text8;
    }

    public void setText8(String text8) {
        this.text8 = text8;
    }

    public String getText9() {
        return this.text9;
    }

    public void setText9(String text9) {
        this.text9 = text9;
    }

    public String getText10() {
        return this.text10;
    }

    public void setText10(String text10) {
        this.text10 = text10;
    }

    public BigDecimal getCustomerNumber1() {
        return this.customerNumber1;
    }

    public void setCustomerNumber1(BigDecimal customerNumber1) {
        this.customerNumber1 = customerNumber1;
    }

    public BigDecimal getCustomerNumber2() {
        return this.customerNumber2;
    }

    public void setCustomerNumber2(BigDecimal customerNumber2) {
        this.customerNumber2 = customerNumber2;
    }

    public BigDecimal getCustomerNumber3() {
        return this.customerNumber3;
    }

    public void setCustomerNumber3(BigDecimal customerNumber3) {
        this.customerNumber3 = customerNumber3;
    }

    public BigDecimal getCustomerNumber4() {
        return this.customerNumber4;
    }

    public void setCustomerNumber4(BigDecimal customerNumber4) {
        this.customerNumber4 = customerNumber4;
    }

    public BigDecimal getCustomerNumber5() {
        return this.customerNumber5;
    }

    public void setCustomerNumber5(BigDecimal customerNumber5) {
        this.customerNumber5 = customerNumber5;
    }

    public BigDecimal getCustomerNumber6() {
        return this.customerNumber6;
    }

    public void setCustomerNumber6(BigDecimal customerNumber6) {
        this.customerNumber6 = customerNumber6;
    }

    public BigDecimal getCustomerNumber7() {
        return this.customerNumber7;
    }

    public void setCustomerNumber7(BigDecimal customerNumber7) {
        this.customerNumber7 = customerNumber7;
    }

    public BigDecimal getCustomerNumber8() {
        return this.customerNumber8;
    }

    public void setCustomerNumber8(BigDecimal customerNumber8) {
        this.customerNumber8 = customerNumber8;
    }

    public BigDecimal getCustomerNumber9() {
        return this.customerNumber9;
    }

    public void setCustomerNumber9(BigDecimal customerNumber9) {
        this.customerNumber9 = customerNumber9;
    }

    public BigDecimal getCustomerNumber10() {
        return this.customerNumber10;
    }

    public void setCustomerNumber10(BigDecimal customerNumber10) {
        this.customerNumber10 = customerNumber10;
    }

    public Date getCustomerDate1() {
        return this.customerDate1;
    }

    public void setCustomerDate1(Date customerDate1) {
        this.customerDate1 = customerDate1;
    }

    public Date getCustomerDate2() {
        return this.customerDate2;
    }

    public void setCustomerDate2(Date customerDate2) {
        this.customerDate2 = customerDate2;
    }

    public Date getCustomerDate3() {
        return this.customerDate3;
    }

    public void setCustomerDate3(Date customerDate3) {
        this.customerDate3 = customerDate3;
    }

    public Date getCustomerDate4() {
        return this.customerDate4;
    }

    public void setCustomerDate4(Date customerDate4) {
        this.customerDate4 = customerDate4;
    }

    public Date getCustomerDate5() {
        return this.customerDate5;
    }

    public void setCustomerDate5(Date customerDate5) {
        this.customerDate5 = customerDate5;
    }

    public Date getCustomerDate6() {
        return this.customerDate6;
    }

    public void setCustomerDate6(Date customerDate6) {
        this.customerDate6 = customerDate6;
    }

    public Date getCustomerDate7() {
        return this.customerDate7;
    }

    public void setCustomerDate7(Date customerDate7) {
        this.customerDate7 = customerDate7;
    }

    public Date getCustomerDate8() {
        return this.customerDate8;
    }

    public void setCustomerDate8(Date customerDate8) {
        this.customerDate8 = customerDate8;
    }

    public Date getCustomerDate9() {
        return this.customerDate9;
    }

    public void setCustomerDate9(Date customerDate9) {
        this.customerDate9 = customerDate9;
    }

    public Date getCustomerDate10() {
        return this.customerDate10;
    }

    public void setCustomerDate10(Date customerDate10) {
        this.customerDate10 = customerDate10;
    }

    public String getCustomerFlag1() {
        return this.customerFlag1;
    }

    public void setCustomerFlag1(String customerFlag1) {
        this.customerFlag1 = customerFlag1;
    }

    public String getCustomerFlag2() {
        return this.customerFlag2;
    }

    public void setCustomerFlag2(String customerFlag2) {
        this.customerFlag2 = customerFlag2;
    }

    public String getCustomerFlag3() {
        return this.customerFlag3;
    }

    public void setCustomerFlag3(String customerFlag3) {
        this.customerFlag3 = customerFlag3;
    }

    public String getCustomerFlag4() {
        return this.customerFlag4;
    }

    public void setCustomerFlag4(String customerFlag4) {
        this.customerFlag4 = customerFlag4;
    }

    public String getCustomerFlag5() {
        return this.customerFlag5;
    }

    public void setCustomerFlag5(String customerFlag5) {
        this.customerFlag5 = customerFlag5;
    }

    public String getCustomerFlag6() {
        return this.customerFlag6;
    }

    public void setCustomerFlag6(String customerFlag6) {
        this.customerFlag6 = customerFlag6;
    }

    public String getCustomerFlag7() {
        return this.customerFlag7;
    }

    public void setCustomerFlag7(String customerFlag7) {
        this.customerFlag7 = customerFlag7;
    }

    public String getCustomerFlag8() {
        return this.customerFlag8;
    }

    public void setCustomerFlag8(String customerFlag8) {
        this.customerFlag8 = customerFlag8;
    }

    public String getCustomerFlag9() {
        return this.customerFlag9;
    }

    public void setCustomerFlag9(String customerFlag9) {
        this.customerFlag9 = customerFlag9;
    }

    public String getCustomerFlag10() {
        return this.customerFlag10;
    }

    public void setCustomerFlag10(String customerFlag10) {
        this.customerFlag10 = customerFlag10;
    }

    /**
     * @return the consigneeEndUserFlag
     */
    public String getConsigneeEndUserFlag() {
        return this.consigneeEndUserFlag;
    }

    /**
     * @param consigneeEndUserFlag the consigneeEndUserFlag to set
     */
    public void setConsigneeEndUserFlag(String consigneeEndUserFlag) {
        this.consigneeEndUserFlag = consigneeEndUserFlag;
    }

    /**
     * @return the receiverBranchNo
     */
    public String getReceiverBranchNo() {
        return this.receiverBranchNo;
    }

    /**
     * @param receiverBranchNo the receiverBranchNo to set
     */
    public void setReceiverBranchNo(String receiverBranchNo) {
        this.receiverBranchNo = receiverBranchNo;
    }

    /**
     * @return the addrTin
     */
    public String getAddrTin() {
        return this.addrTin;
    }

    /**
     * @param addrTin the addrTin to set
     */
    public void setAddrTin(String addrTin) {
        this.addrTin = addrTin;
    }

    /**
     * @return the userBranchNo
     */
    public String getUserBranchNo() {
        return this.userBranchNo;
    }

    /**
     * @param userBranchNo the userBranchNo to set
     */
    public void setUserBranchNo(String userBranchNo) {
        this.userBranchNo = userBranchNo;
    }

    /**
     * @return the eUserName
     */
    public String geteUserName() {
        return this.eUserName;
    }

    /**
     * @param eUserName the eUserName to set
     */
    public void seteUserName(String eUserName) {
        this.eUserName = eUserName;
    }

    /**
     * @return the userAddrLoc
     */
    public String getUserAddrLoc() {
        return this.userAddrLoc;
    }

    /**
     * @param userAddrLoc the userAddrLoc to set
     */
    public void setUserAddrLoc(String userAddrLoc) {
        this.userAddrLoc = userAddrLoc;
    }

    /**
     * @return the userAddrStreet
     */
    public String getUserAddrStreet() {
        return this.userAddrStreet;
    }

    /**
     * @param userAddrStreet the userAddrStreet to set
     */
    public void setUserAddrStreet(String userAddrStreet) {
        this.userAddrStreet = userAddrStreet;
    }

    /**
     * @return the userAddrZip
     */
    public String getUserAddrZip() {
        return this.userAddrZip;
    }

    /**
     * @param userAddrZip the userAddrZip to set
     */
    public void setUserAddrZip(String userAddrZip) {
        this.userAddrZip = userAddrZip;
    }

    /**
     * @return the userAddrCountry
     */
    public String getUserAddrCountry() {
        return this.userAddrCountry;
    }

    /**
     * @param userAddrCountry the userAddrCountry to set
     */
    public void setUserAddrCountry(String userAddrCountry) {
        this.userAddrCountry = userAddrCountry;
    }

    public String getUserAddrEori() {
        return this.userAddrEori;
    }

    public void setUserAddrEori(String userAddrEori) {
        this.userAddrEori = userAddrEori;
    }

    /**
     * @return the termsOfDeliveryCode
     */
    public String getTermsOfDeliveryCode() {
        return this.termsOfDeliveryCode;
    }

    /**
     * @param termsOfDeliveryCode the termsOfDeliveryCode to set
     */
    public void setTermsOfDeliveryCode(String termsOfDeliveryCode) {
        this.termsOfDeliveryCode = termsOfDeliveryCode;
    }

    /**
     * @return the termsOfDeliveryDesc
     */
    public String getTermsOfDeliveryDesc() {
        return this.termsOfDeliveryDesc;
    }

    /**
     * @param termsOfDeliveryDesc the termsOfDeliveryDesc to set
     */
    public void setTermsOfDeliveryDesc(String termsOfDeliveryDesc) {
        this.termsOfDeliveryDesc = termsOfDeliveryDesc;
    }

    /**
     * @return the userNr
     */
    public String getUserNr() {
        return this.userNr;
    }

    /**
     * @param userNr the userNr to set
     */
    public void setUserNr(String userNr) {
        this.userNr = userNr;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPreviousDocumentNumber() {
        return this.previousDocumentNumber;
    }

    public void setPreviousDocumentNumber(String previousDocumentNumber) {
        this.previousDocumentNumber = previousDocumentNumber;
    }

    public String getPreviousDocumentType() {
        return this.previousDocumentType;
    }

    public void setPreviousDocumentType(String previousDocumentType) {
        this.previousDocumentType = previousDocumentType;
    }

    public String getEndUserInEam() {
        return this.endUserInEam;
    }

    public void setEndUserInEam(String endUserInEam) {
        this.endUserInEam = endUserInEam;
    }

    public Date getStornoDate() {
        return this.stornoDate;
    }

    public void setStornoDate(Date stornoDate) {
        this.stornoDate = stornoDate;
    }

    public Date getFurtherProcessingDate() {
        return this.furtherProcessingDate;
    }

    public void setFurtherProcessingDate(Date furtherProcessingDate) {
        this.furtherProcessingDate = furtherProcessingDate;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getDeliverDate() {
        return this.deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }

    public Date getExportDate() {
        return this.exportDate;
    }

    public void setExportDate(Date exportDate) {
        this.exportDate = exportDate;
    }

    public String getStockDeductionFlag() {
        return this.stockDeductionFlag;
    }

    public void setStockDeductionFlag(String stockDeductionFlag) {
        this.stockDeductionFlag = stockDeductionFlag;
    }

    public String getValuationMethod() {
        return this.valuationMethod;
    }

    public void setValuationMethod(String valuationMethod) {
        this.valuationMethod = valuationMethod;
    }

    public String getRegistrationStatus() {
        return this.registrationStatus;
    }

    public void setRegistrationStatus(String registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public BigDecimal getAdditionalCosts1() {
        return this.additionalCosts1;
    }

    public void setAdditionalCosts1(BigDecimal additionalCosts1) {
        this.additionalCosts1 = additionalCosts1;
    }

    public String getAgreement() {
        return this.agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    public String getStockTypeAdd() {
        return this.stockTypeAdd;
    }

    public void setStockTypeAdd(String stockTypeAdd) {
        this.stockTypeAdd = stockTypeAdd;
    }

    public String getStockTypeDed() {
        return this.stockTypeDed;
    }

    public void setStockTypeDed(String stockTypeDed) {
        this.stockTypeDed = stockTypeDed;
    }

    public String getBomNumber() {
        return this.bomNumber;
    }

    public void setBomNumber(String bomNumber) {
        this.bomNumber = bomNumber;
    }

    public String getBomVar() {
        return this.bomVar;
    }

    public void setBomVar(String bomVar) {
        this.bomVar = bomVar;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getRegistrationDate() {
        return this.registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getInfoText() {
        return this.infoText;
    }

    public void setInfoText(String infoText) {
        this.infoText = infoText;
    }

    public Date getRejectionDate() {
        return this.rejectionDate;
    }

    public void setRejectionDate(Date rejectionDate) {
        this.rejectionDate = rejectionDate;
    }

    /**
     * @return the statisticalQuantityUomQualificator
     */
    public String getStatisticalQuantityUomQualificator() {
        return this.statisticalQuantityUomQualificator;
    }

    /**
     * @param statisticalQuantityUomQualificator the statisticalQuantityUomQualificator to set
     */
    public void setStatisticalQuantityUomQualificator(
            String statisticalQuantityUomQualificator) {
        this.statisticalQuantityUomQualificator = statisticalQuantityUomQualificator;
    }


    /**
     * @return the exit
     */
    public String getExit() {
        return this.exit;
    }

    /**
     * @param exit the exit to set
     */
    public void setExit(String exit) {
        this.exit = exit;
    }

    public Date getCompletionDate() {
        return this.completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public Date getPackBeginDate() {
        return this.packBeginDate;
    }

    public void setPackBeginDate(Date packBeginDate) {
        this.packBeginDate = packBeginDate;
    }

    public Date getPackEndDate() {
        return this.packEndDate;
    }

    public void setPackEndDate(Date packEndDate) {
        this.packEndDate = packEndDate;
    }

    public Date getDeadlineDate() {
        return this.deadlineDate;
    }

    public void setDeadlineDate(Date deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    /**
     * @return the messageGroupNumber
     */
    public BigDecimal getMessageGroupNumber() {
        return this.messageGroupNumber;
    }

    /**
     * @param messageGroupNumber the messageGroupNumber to set
     */
    public void setMessageGroupNumber(BigDecimal messageGroupNumber) {
        this.messageGroupNumber = messageGroupNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getWatermark() {
        return watermark;
    }

    public void setWatermark(String watermark) {
        this.watermark = watermark;
    }

    public String getShipmentWatermark() {
        return shipmentWatermark;
    }

    public void setShipmentWatermark(String shipmentWatermark) {
        this.shipmentWatermark = shipmentWatermark;
    }

    public String getText11() {
        return text11;
    }

    public void setText11(String text11) {
        this.text11 = text11;
    }

    public String getText12() {
        return text12;
    }

    public void setText12(String text12) {
        this.text12 = text12;
    }

    public String getText13() {
        return text13;
    }

    public void setText13(String text13) {
        this.text13 = text13;
    }

    public String getText14() {
        return text14;
    }

    public void setText14(String text14) {
        this.text14 = text14;
    }

    public String getText15() {
        return text15;
    }

    public void setText15(String text15) {
        this.text15 = text15;
    }

    public BigDecimal getCustomerNumber11() {
        return customerNumber11;
    }

    public void setCustomerNumber11(BigDecimal customerNumber11) {
        this.customerNumber11 = customerNumber11;
    }

    public BigDecimal getCustomerNumber12() {
        return customerNumber12;
    }

    public void setCustomerNumber12(BigDecimal customerNumber12) {
        this.customerNumber12 = customerNumber12;
    }

    public BigDecimal getCustomerNumber13() {
        return customerNumber13;
    }

    public void setCustomerNumber13(BigDecimal customerNumber13) {
        this.customerNumber13 = customerNumber13;
    }

    public BigDecimal getCustomerNumber14() {
        return customerNumber14;
    }

    public void setCustomerNumber14(BigDecimal customerNumber14) {
        this.customerNumber14 = customerNumber14;
    }

    public BigDecimal getCustomerNumber15() {
        return customerNumber15;
    }

    public void setCustomerNumber15(BigDecimal customerNumber15) {
        this.customerNumber15 = customerNumber15;
    }

    public Date getCustomerDate11() {
        return customerDate11;
    }

    public void setCustomerDate11(Date customerDate11) {
        this.customerDate11 = customerDate11;
    }

    public Date getCustomerDate12() {
        return customerDate12;
    }

    public void setCustomerDate12(Date customerDate12) {
        this.customerDate12 = customerDate12;
    }

    public Date getCustomerDate13() {
        return customerDate13;
    }

    public void setCustomerDate13(Date customerDate13) {
        this.customerDate13 = customerDate13;
    }

    public Date getCustomerDate14() {
        return customerDate14;
    }

    public void setCustomerDate14(Date customerDate14) {
        this.customerDate14 = customerDate14;
    }

    public Date getCustomerDate15() {
        return customerDate15;
    }

    public void setCustomerDate15(Date customerDate15) {
        this.customerDate15 = customerDate15;
    }

    public String getCustomerFlag11() {
        return customerFlag11;
    }

    public void setCustomerFlag11(String customerFlag11) {
        this.customerFlag11 = customerFlag11;
    }

    public String getCustomerFlag12() {
        return customerFlag12;
    }

    public void setCustomerFlag12(String customerFlag12) {
        this.customerFlag12 = customerFlag12;
    }

    public String getCustomerFlag13() {
        return customerFlag13;
    }

    public void setCustomerFlag13(String customerFlag13) {
        this.customerFlag13 = customerFlag13;
    }

    public String getCustomerFlag14() {
        return customerFlag14;
    }

    public void setCustomerFlag14(String customerFlag14) {
        this.customerFlag14 = customerFlag14;
    }

    public String getCustomerFlag15() {
        return customerFlag15;
    }

    public void setCustomerFlag15(String customerFlag15) {
        this.customerFlag15 = customerFlag15;
    }

    public String getExportControlClassficationNumber() {
        return exportControlClassficationNumber;
    }

    public void setExportControlClassficationNumber(
            String exportControlClassficationNumber) {
        this.exportControlClassficationNumber = exportControlClassficationNumber;
    }


}
