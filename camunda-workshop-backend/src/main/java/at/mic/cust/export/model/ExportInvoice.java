package at.mic.cust.export.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class represents the JPA mapping for the export invoice (table
 * MIC_AUSKOP).
 */
@Entity
@Table(name = "MIC_AUSKOP")
@SequenceGenerator(name = "ExportInvoiceSeq", sequenceName = "MIC_AUSKOP_SEQ", allocationSize = 1)
public class ExportInvoice {

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ExportPosition> positions = new ArrayList<ExportPosition>();

    @Id
    @Column(name = "AFKSID", nullable = false, length = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ExportInvoiceSeq")
    private long sid;
    @Basic
    @Column(name = "AFKMANDANT", nullable = false, length = 2)
    private String company;
    @Basic
    @Column(name = "AFKWERK", nullable = false, length = 2)
    private String plant;
    @Basic
    @Column(name = "AFKFAKTNR", length = 30)
    private String invoiceNumber;
    @Basic
    @Column(name = "AFKFAKTDAT")
    @Temporal(TemporalType.DATE)
    private Date invoiceDate;
    @Basic
    @Column(name = "AFKKNDNR", length = 15)
    private String customerNumber;
    @Basic
    @Column(name = "AFKKNDNM1", length = 40)
    private String customerName1;
    @Basic
    @Column(name = "AFKKNDNM2", length = 40)
    private String customerName2;
    @Basic
    @Column(name = "AFKKNDNM3", length = 40)
    private String customerName3;
    @Basic
    @Column(name = "AFKKNDNM4", length = 40)
    private String customerName4;
    @Basic
    @Column(name = "AFKKNDSTR", length = 80)
    private String customerStreet;
    @Basic
    @Column(name = "AFKKNDPLZ", length = 10)
    private String customerZip;
    @Basic
    @Column(name = "AFKKNDORT", length = 80)
    private String customerCity;
    @Basic
    @Column(name = "AFKKNDLD", length = 3)
    private String customerCountry;
    @Basic
    @Column(name = "AFKKNDREGION", length = 10)
    private String customerRegion;
    @Basic
    @Column(name = "AFKKNDUST", length = 20)
    private String customerVatId;
    @Basic
    @Column(name = "AFKKNDTIN", length = 17)
    private String customerTin;
    @Basic
    @Column(name = "AFKKNDEORI", length = 17)
    private String customerEori;
    @Basic
    @Column(name = "AFKKNDKVB", length = 1)
    private String customerRelationIndicator;
    @Basic
    @Column(name = "AFKEMPNR", length = 15)
    private String receiverNumber;
    @Basic
    @Column(name = "AFKEMPNM1", length = 40)
    private String receiverName1;
    @Basic
    @Column(name = "AFKEMPNM2", length = 40)
    private String receiverName2;
    @Basic
    @Column(name = "AFKEMPNM3", length = 40)
    private String receiverName3;
    @Basic
    @Column(name = "AFKEMPNM4", length = 40)
    private String receiverName4;
    @Basic
    @Column(name = "AFKEMPSTR", length = 80)
    private String receiverStreet;
    @Basic
    @Column(name = "AFKEMPPLZ", length = 10)
    private String receiverZip;
    @Basic
    @Column(name = "AFKEMPORT", length = 80)
    private String receiverCity;
    @Basic
    @Column(name = "AFKEMPLD", length = 3)
    private String receiverCountry;
    @Basic
    @Column(name = "AFKEMPREGION", length = 10)
    private String receiverRegion;
    @Basic
    @Column(name = "AFKEMPUST", length = 20)
    private String receiverVatId;
    @Basic
    @Column(name = "AFKEMPTIN", length = 17)
    private String receiverTin;
    @Basic
    @Column(name = "AFKEMPEORI", length = 17)
    private String receiverEori;
    @Basic
    @Column(name = "AFKEMPKVB", length = 1)
    private String receiverRelationIndicator;
    @Basic
    @Column(name = "AFKLIEWERT", length = 17, scale = 4)
    private BigDecimal invoiceValue;
    @Basic
    @Column(name = "AFKLIEWAE", length = 3)
    private String currency;
    @Basic
    @Column(name = "AFKKURS", length = 16, scale = 9)
    private BigDecimal exchangeRate;
    @Basic
    @Column(name = "AFKROHMAS", length = 13, scale = 4)
    private BigDecimal grossWeight;
    @Basic
    @Column(name = "AFKGEWSUM", length = 13, scale = 4)
    private BigDecimal netWeight;
    @Basic
    @Column(name = "AFKKOLANZ", length = 6)
    private Long packageCount;
    @Basic
    @Column(name = "AFKKOLBEZ", length = 30)
    private String packageDescription;
    @Basic
    @Column(name = "AFKHALD", length = 3)
    private String countryOfTrade;
    @Basic
    @Column(name = "AFKALIFORMULA", length = 4)
    private String incoTermFormula;
    @Basic
    @Column(name = "AFKABART1", length = 10)
    private String additionalCostType1;
    @Basic
    @Column(name = "AFKABKZ1", length = 1)
    private String additionalCostFlag1;
    @Basic
    @Column(name = "AFKABWRT1", length = 17, scale = 4)
    private BigDecimal additionalCostValue1;
    @Basic
    @Column(name = "AFKABWAE1", length = 3)
    private String additionalCostCurrency1;
    @Basic
    @Column(name = "AFKABART2", length = 10)
    private String additionalCostType2;
    @Basic
    @Column(name = "AFKABKZ2", length = 1)
    private String additionalCostFlag2;
    @Basic
    @Column(name = "AFKABWRT2", length = 17, scale = 4)
    private BigDecimal additionalCostValue2;
    @Basic
    @Column(name = "AFKABWAE2", length = 3)
    private String additionalCostCurrency2;
    @Basic
    @Column(name = "AFKFAKTTYP", length = 2)
    private String invoiceType;
    @Basic
    @Column(name = "AFKBELKZ", length = 1)
    private String closed;
    @Basic
    @Column(name = "AFKSTORNO", length = 1)
    private String cancel;
    @Basic
    @Column(name = "AFKVALID", length = 2)
    private String valid;
    @Basic
    @Column(name = "AFKUSER", length = 12)
    private String modificationUser;
    @Basic
    @Column(name = "AFKUSEDAT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;
    @Basic
    @Column(name = "AFKCREUSER", length = 12)
    private String creationUser;
    @Basic
    @Column(name = "AFKCREDAT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Basic
    @Column(name = "afkafssid", length = 10, insertable = false, updatable = false)
    private long shipmentSid;

    // --- new fields
    @Basic
    @Column(name = "afkwvb", length = 18)
    private String mce;
    @Basic
    @Column(name = "afkbol", length = 20)
    private String billOfLoading;
    @Basic
    @Column(name = "afkinfo", length = 80)
    private String infoText;
    @Basic
    @Column(name = "afkletzpos", length = 5)
    private Long lastLineItem;
    @Basic
    @Column(name = "afkalicod2", length = 1)
    private String deliveryTerms2; // <--- could be boolean
    @Basic
    @Column(name = "afkpruefkz", length = 1)
    private String checked; // <--- could be boolean
    @Basic
    @Column(name = "afkmesssstatus", length = 2)
    private String sendStatus;
    @Basic
    @Column(name = "afkmessrstatus", length = 2)
    private String responseStatus;
    @Basic
    @Column(name = "AFKFLUSSKZ", length = 1)
    private String flowFlag; // <--- could be boolean
    @Basic
    @Column(name = "AFKFAKTREF", length = 30)
    private String invoiceNumberRef;
    @Basic
    @Column(name = "AFKTEXT1", length = 400)
    private String text1;
    @Basic
    @Column(name = "AFKTEXT2", length = 80)
    private String text2;
    @Basic
    @Column(name = "AFKTEXT3", length = 80)
    private String text3;
    @Basic
    @Column(name = "AFKTEXT4", length = 80)
    private String text4;
    @Basic
    @Column(name = "AFKTEXT5", length = 400)
    private String text5;
    @Basic
    @Column(name = "AFKTEXT6", length = 400)
    private String text6;
    @Basic
    @Column(name = "AFKTEXT7", length = 400)
    private String text7;
    @Basic
    @Column(name = "AFKTEXT8", length = 400)
    private String text8;
    @Basic
    @Column(name = "AFKTEXT9", length = 400)
    private String text9;
    @Basic
    @Column(name = "AFKTEXT10", length = 400)
    private String text10;
    @Basic
    @Column(name = "AFKDATE1")
    @Temporal(TemporalType.TIMESTAMP)
    private Date customerDate1;
    @Basic
    @Column(name = "AFKDATE2")
    @Temporal(TemporalType.TIMESTAMP)
    private Date customerDate2;
    @Basic
    @Column(name = "AFKDATE3")
    @Temporal(TemporalType.TIMESTAMP)
    private Date customerDate3;
    @Basic
    @Column(name = "AFKDATE4")
    @Temporal(TemporalType.TIMESTAMP)
    private Date customerDate4;
    @Basic
    @Column(name = "AFKDATE5")
    @Temporal(TemporalType.TIMESTAMP)
    private Date customerDate5;
    @Basic
    @Column(name = "AFKDATE6")
    @Temporal(TemporalType.TIMESTAMP)
    private Date customerDate6;
    @Basic
    @Column(name = "AFKDATE7")
    @Temporal(TemporalType.TIMESTAMP)
    private Date customerDate7;
    @Basic
    @Column(name = "AFKDATE8")
    @Temporal(TemporalType.TIMESTAMP)
    private Date customerDate8;
    @Basic
    @Column(name = "AFKDATE9")
    @Temporal(TemporalType.TIMESTAMP)
    private Date customerDate9;
    @Basic
    @Column(name = "AFKDATE10")
    @Temporal(TemporalType.TIMESTAMP)
    private Date customerDate10;
    @Basic
    @Column(name = "AFKFLAG1", length = 1)
    private String customerFlag1;
    @Basic
    @Column(name = "AFKFLAG2", length = 1)
    private String customerFlag2;
    @Basic
    @Column(name = "AFKFLAG3", length = 1)
    private String customerFlag3;
    @Basic
    @Column(name = "AFKFLAG4", length = 1)
    private String customerFlag4;
    @Basic
    @Column(name = "AFKFLAG5", length = 1)
    private String customerFlag5;
    @Basic
    @Column(name = "AFKFLAG6", length = 1)
    private String customerFlag6;
    @Basic
    @Column(name = "AFKFLAG7", length = 1)
    private String customerFlag7;
    @Basic
    @Column(name = "AFKFLAG8", length = 1)
    private String customerFlag8;
    @Basic
    @Column(name = "AFKFLAG9", length = 1)
    private String customerFlag9;
    @Basic
    @Column(name = "AFKFLAG10", length = 1)
    private String customerFlag10;
    @Basic
    @Column(name = "AFKNUM1", length = 13, scale = 4)
    private BigDecimal customerNumber1;
    @Basic
    @Column(name = "AFKNUM2", length = 13, scale = 4)
    private BigDecimal customerNumber2;
    @Basic
    @Column(name = "AFKNUM3", length = 13, scale = 4)
    private BigDecimal customerNumber3;
    @Basic
    @Column(name = "AFKNUM4", length = 13, scale = 4)
    private BigDecimal customerNumber4;
    @Basic
    @Column(name = "AFKNUM5", length = 13, scale = 4)
    private BigDecimal customerNumber5;
    @Basic
    @Column(name = "AFKNUM6", length = 13, scale = 4)
    private BigDecimal customerNumber6;
    @Basic
    @Column(name = "AFKNUM7", length = 13, scale = 4)
    private BigDecimal customerNumber7;
    @Basic
    @Column(name = "AFKNUM8", length = 13, scale = 4)
    private BigDecimal customerNumber8;
    @Basic
    @Column(name = "AFKNUM9", length = 13, scale = 4)
    private BigDecimal customerNumber9;
    @Basic
    @Column(name = "AFKNUM10", length = 13, scale = 4)
    private BigDecimal customerNumber10;
    @Basic
    @Column(name = "afkrscode", length = 10)
    private String reasonCode;
    @Basic
    @Column(name = "afktranspnr", length = 20)
    private String transportNumber;
    @Basic
    @Column(name = "afktransptyp", length = 10)
    private String transportType;
    @Basic
    @Column(name = "afkpos", length = 5)
    private Long invoiceLineNumber;
    @Basic
    @Column(name = "afkgrdat")
    @Temporal(TemporalType.DATE)
    // <--- could also be TemporalType.TIMESTAMP
    private Date crossingBorderDate;
    @Basic
    @Column(name = "afkplombe", length = 50)
    private String containerSeals;
    @Basic
    @Column(name = "afkcontno", length = 20)
    private String containerNumber;
    @Basic
    @Column(name = "afkconttyp", length = 10)
    private String containerType;
    @Basic
    @Column(name = "afkshed", length = 4)
    private String warehouseNumber;
    @Basic
    @Column(name = "afkprocesskz", length = 1)
    private String processFlag; // <--- could be boolean
    @Basic
    @Column(name = "afkgsart", length = 2)
    private String typeOfTrade;
    @Basic
    @Column(name = "afkauthobj", length = 30)
    private String authorizationObject;
    @Basic
    @Column(name = "afkaufart1", length = 1)
    private String additionalDistributionType1; // <--- could be boolean
    @Basic
    @Column(name = "afkaufart2", length = 1)
    private String additionalDistributionType2; // <--- could be boolean
    @Basic
    @Column(name = "afkmesssstatusalt", length = 2)
    private String oldSendStatus;
    @Basic
    @Column(name = "afkmessrstatusalt", length = 2)
    private String oldResponseStatus;
    @Basic
    @Column(name = "afkmxniu", length = 200)
    private String mxniu;
    // INTGR-510 new Fields
    @Basic
    @Column(name = "afkeusernr", length = 15)
    private String userAddNo;
    @Basic
    @Column(name = "AFKEUSERBRANCHNO", length = 4)
    private String userBranchNo;
    @Basic
    @Column(name = "AFKEUSERTIN", length = 17)
    private String addrTin;
    @Basic
    @Column(name = "AFKEMPBRANCHNO", length = 4)
    private String receiverBranchNo;
    @Basic
    @Column(name = "AFKEUSERNM1", length = 120)
    private String userAddrName1;
    @Basic
    @Column(name = "AFKEUSERSTREET", length = 70)
    private String userAddrStreet;
    @Basic
    @Column(name = "AFKEUSERCITY", length = 35)
    private String userAddrLoc;
    @Basic
    @Column(name = "AFKEUSERCOUNTRY", length = 2)
    private String userAddrCountry;
    @Basic
    @Column(name = "AFKEUSERZIP", length = 10)
    private String userAddrZip;
    @Basic
    @Column(name = "Afkalicode", length = 3)
    private String termsOfDeliveryCode;
    @Basic
    @Column(name = "Afkalibez", length = 35)
    private String termsOfDeliveryDesc;
    @Version
    @Basic
    @Column(name = "afklockversion", length = 1, nullable = false)
    private long lockVersion;

    /**
     * Constructs a new {@code ExportInvoice} instance.
     */
    public ExportInvoice() {
        super();
    }

    public long getSid() {
        return this.sid;
    }

    public void setSid(long sid) {
        this.sid = sid;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPlant() {
        return this.plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

    public String getInvoiceNumber() {
        return this.invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Date getInvoiceDate() {
        return this.invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getCustomerNumber() {
        return this.customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName1() {
        return this.customerName1;
    }

    public void setCustomerName1(String customerName1) {
        this.customerName1 = customerName1;
    }

    public String getCustomerName2() {
        return this.customerName2;
    }

    public void setCustomerName2(String customerName2) {
        this.customerName2 = customerName2;
    }

    public String getCustomerName3() {
        return this.customerName3;
    }

    public void setCustomerName3(String customerName3) {
        this.customerName3 = customerName3;
    }

    public String getCustomerName4() {
        return this.customerName4;
    }

    public void setCustomerName4(String customerName4) {
        this.customerName4 = customerName4;
    }

    public String getCustomerStreet() {
        return this.customerStreet;
    }

    public void setCustomerStreet(String customerStreet) {
        this.customerStreet = customerStreet;
    }

    public String getCustomerZip() {
        return this.customerZip;
    }

    public void setCustomerZip(String customerZip) {
        this.customerZip = customerZip;
    }

    public String getCustomerCity() {
        return this.customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerCountry() {
        return this.customerCountry;
    }

    public void setCustomerCountry(String customerCountry) {
        this.customerCountry = customerCountry;
    }

    public String getCustomerRegion() {
        return this.customerRegion;
    }

    public void setCustomerRegion(String customerRegion) {
        this.customerRegion = customerRegion;
    }

    public String getCustomerVatId() {
        return this.customerVatId;
    }

    public void setCustomerVatId(String customerVatId) {
        this.customerVatId = customerVatId;
    }

    public String getCustomerTin() {
        return this.customerTin;
    }

    public void setCustomerTin(String customerTin) {
        this.customerTin = customerTin;
    }

    public String getCustomerEori() {
        return this.customerEori;
    }

    public void setCustomerEori(String customerEori) {
        this.customerEori = customerEori;
    }

    public String getCustomerRelationIndicator() {
        return this.customerRelationIndicator;
    }

    public void setCustomerRelationIndicator(String customerRelationIndicator) {
        this.customerRelationIndicator = customerRelationIndicator;
    }

    public String getReceiverNumber() {
        return this.receiverNumber;
    }

    public void setReceiverNumber(String receiverNumber) {
        this.receiverNumber = receiverNumber;
    }

    public String getReceiverName1() {
        return this.receiverName1;
    }

    public void setReceiverName1(String receiverName1) {
        this.receiverName1 = receiverName1;
    }

    public String getReceiverName2() {
        return this.receiverName2;
    }

    public void setReceiverName2(String receiverName2) {
        this.receiverName2 = receiverName2;
    }

    public String getReceiverName3() {
        return this.receiverName3;
    }

    public void setReceiverName3(String receiverName3) {
        this.receiverName3 = receiverName3;
    }

    public String getReceiverName4() {
        return this.receiverName4;
    }

    public void setReceiverName4(String receiverName4) {
        this.receiverName4 = receiverName4;
    }

    public String getReceiverStreet() {
        return this.receiverStreet;
    }

    public void setReceiverStreet(String receiverStreet) {
        this.receiverStreet = receiverStreet;
    }

    public String getReceiverZip() {
        return this.receiverZip;
    }

    public void setReceiverZip(String receiverZip) {
        this.receiverZip = receiverZip;
    }

    public String getReceiverCity() {
        return this.receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    public String getReceiverCountry() {
        return this.receiverCountry;
    }

    public void setReceiverCountry(String receiverCountry) {
        this.receiverCountry = receiverCountry;
    }

    public String getReceiverRegion() {
        return this.receiverRegion;
    }

    public void setReceiverRegion(String receiverRegion) {
        this.receiverRegion = receiverRegion;
    }

    public String getReceiverVatId() {
        return this.receiverVatId;
    }

    public void setReceiverVatId(String receiverVatId) {
        this.receiverVatId = receiverVatId;
    }

    public String getReceiverTin() {
        return this.receiverTin;
    }

    public void setReceiverTin(String receiverTin) {
        this.receiverTin = receiverTin;
    }

    public String getReceiverEori() {
        return this.receiverEori;
    }

    public void setReceiverEori(String receiverEori) {
        this.receiverEori = receiverEori;
    }

    public String getReceiverRelationIndicator() {
        return this.receiverRelationIndicator;
    }

    public void setReceiverRelationIndicator(String receiverRelationIndicator) {
        this.receiverRelationIndicator = receiverRelationIndicator;
    }

    public BigDecimal getInvoiceValue() {
        return this.invoiceValue;
    }

    public void setInvoiceValue(BigDecimal invoiceValue) {
        this.invoiceValue = invoiceValue;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getExchangeRate() {
        return this.exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public BigDecimal getGrossWeight() {
        return this.grossWeight;
    }

    public void setGrossWeight(BigDecimal grossWeight) {
        this.grossWeight = grossWeight;
    }

    public BigDecimal getNetWeight() {
        return this.netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    public Long getPackageCount() {
        return this.packageCount;
    }

    public void setPackageCount(Long packageCount) {
        this.packageCount = packageCount;
    }

    public String getPackageDescription() {
        return this.packageDescription;
    }

    public void setPackageDescription(String packageDescription) {
        this.packageDescription = packageDescription;
    }

    public String getCountryOfTrade() {
        return this.countryOfTrade;
    }

    public void setCountryOfTrade(String countryOfTrade) {
        this.countryOfTrade = countryOfTrade;
    }

    public String getIncoTermFormula() {
        return this.incoTermFormula;
    }

    public void setIncoTermFormula(String incoTermFormula) {
        this.incoTermFormula = incoTermFormula;
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

    public String getInvoiceType() {
        return this.invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getClosed() {
        return this.closed;
    }

    public void setClosed(String closed) {
        this.closed = closed;
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


    public List<ExportPosition> getPositions() {
        return this.positions;
    }

    public void setPositions(List<ExportPosition> positions) {
        this.positions = positions;
    }


    public long getShipmentSid() {
        return this.shipmentSid;
    }

    public String getMce() {
        return this.mce;
    }

    public void setMce(String mce) {
        this.mce = mce;
    }

    public String getBillOfLoading() {
        return this.billOfLoading;
    }

    public void setBillOfLoading(String billOfLoading) {
        this.billOfLoading = billOfLoading;
    }

    public String getInfoText() {
        return this.infoText;
    }

    public void setInfoText(String infoText) {
        this.infoText = infoText;
    }

    public Long getLastLineItem() {
        return this.lastLineItem;
    }

    public void setLastLineItem(Long lastLineItem) {
        this.lastLineItem = lastLineItem;
    }

    public String getDeliveryTerms2() {
        return this.deliveryTerms2;
    }

    public void setDeliveryTerms2(String deliveryTerms2) {
        this.deliveryTerms2 = deliveryTerms2;
    }

    public String getChecked() {
        return this.checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
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

    public String getFlowFlag() {
        return this.flowFlag;
    }

    public void setFlowFlag(String flowFlag) {
        this.flowFlag = flowFlag;
    }

    public String getInvoiceNumberRef() {
        return this.invoiceNumberRef;
    }

    public void setInvoiceNumberRef(String invoiceNumberRef) {
        this.invoiceNumberRef = invoiceNumberRef;
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

    public String getReasonCode() {
        return this.reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getTransportNumber() {
        return this.transportNumber;
    }

    public void setTransportNumber(String transportNumber) {
        this.transportNumber = transportNumber;
    }

    public String getTransportType() {
        return this.transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public Date getCrossingBorderDate() {
        return this.crossingBorderDate;
    }

    public void setCrossingBorderDate(Date crossingBorderDate) {
        this.crossingBorderDate = crossingBorderDate;
    }

    public String getContainerSeals() {
        return this.containerSeals;
    }

    public void setContainerSeals(String containerSeals) {
        this.containerSeals = containerSeals;
    }

    public String getContainerNumber() {
        return this.containerNumber;
    }

    public void setContainerNumber(String containerNumber) {
        this.containerNumber = containerNumber;
    }

    public String getContainerType() {
        return this.containerType;
    }

    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    public String getWarehouseNumber() {
        return this.warehouseNumber;
    }

    public void setWarehouseNumber(String warehouseNumber) {
        this.warehouseNumber = warehouseNumber;
    }

    public String getProcessFlag() {
        return this.processFlag;
    }

    public void setProcessFlag(String processFlag) {
        this.processFlag = processFlag;
    }

    public String getTypeOfTrade() {
        return this.typeOfTrade;
    }

    public void setTypeOfTrade(String typeOfTrade) {
        this.typeOfTrade = typeOfTrade;
    }

    public String getAuthorizationObject() {
        return this.authorizationObject;
    }

    public void setAuthorizationObject(String authorizationObject) {
        this.authorizationObject = authorizationObject;
    }

    public String getAdditionalDistributionType1() {
        return this.additionalDistributionType1;
    }

    public void setAdditionalDistributionType1(
            String additionalDistributionType1) {
        this.additionalDistributionType1 = additionalDistributionType1;
    }

    public String getAdditionalDistributionType2() {
        return this.additionalDistributionType2;
    }

    public void setAdditionalDistributionType2(
            String additionalDistributionType2) {
        this.additionalDistributionType2 = additionalDistributionType2;
    }

    public String getOldSendStatus() {
        return this.oldSendStatus;
    }

    public void setOldSendStatus(String oldSendStatus) {
        this.oldSendStatus = oldSendStatus;
    }

    public String getOldResponseStatus() {
        return this.oldResponseStatus;
    }

    public void setOldResponseStatus(String oldResponseStatus) {
        this.oldResponseStatus = oldResponseStatus;
    }

    public String getMxniu() {
        return this.mxniu;
    }

    public void setMxniu(String mxniu) {
        this.mxniu = mxniu;
    }

    public long getLockVersion() {
        return this.lockVersion;
    }

    public void setLockVersion(long lockVersion) {
        this.lockVersion = lockVersion;
    }

    /**
     * @return the userBranchNo
     */
    public String getUserBranchNo() {
        return userBranchNo;
    }

    /**
     * @param userBranchNo the userBranchNo to set
     */
    public void setUserBranchNo(String userBranchNo) {
        this.userBranchNo = userBranchNo;
    }

    /**
     * @return the addrTin
     */
    public String getAddrTin() {
        return addrTin;
    }

    /**
     * @param addrTin the addrTin to set
     */
    public void setAddrTin(String addrTin) {
        this.addrTin = addrTin;
    }

    /**
     * @return the receiverBranchNo
     */
    public String getReceiverBranchNo() {
        return receiverBranchNo;
    }

    /**
     * @param receiverBranchNo the receiverBranchNo to set
     */
    public void setReceiverBranchNo(String receiverBranchNo) {
        this.receiverBranchNo = receiverBranchNo;
    }

    /**
     * @return the addrName
     */
    public String getUserAddrName1() {
        return userAddrName1;
    }

    /**
     * @param userAddrName1 the addrName to set
     */
    public void setUserAddrName1(String userAddrName1) {
        this.userAddrName1 = userAddrName1;
    }

    /**
     * @return the userAddrStreet
     */
    public String getUserAddrStreet() {
        return userAddrStreet;
    }

    /**
     * @param userAddrStreet the userAddrStreet to set
     */
    public void setUserAddrStreet(String userAddrStreet) {
        this.userAddrStreet = userAddrStreet;
    }

    /**
     * @return the userAddrLoc
     */
    public String getUserAddrLoc() {
        return userAddrLoc;
    }

    /**
     * @param userAddrLoc the userAddrLoc to set
     */
    public void setUserAddrLoc(String userAddrLoc) {
        this.userAddrLoc = userAddrLoc;
    }

    /**
     * @return the userAddrCountry
     */
    public String getUserAddrCountry() {
        return userAddrCountry;
    }

    /**
     * @param userAddrCountry the userAddrCountry to set
     */
    public void setUserAddrCountry(String userAddrCountry) {
        this.userAddrCountry = userAddrCountry;
    }

    /**
     * @return the userAddrZip
     */
    public String getUserAddrZip() {
        return userAddrZip;
    }

    /**
     * @param userAddrZip the userAddrZip to set
     */
    public void setUserAddrZip(String userAddrZip) {
        this.userAddrZip = userAddrZip;
    }

    /**
     * @return the termsOfDeliveryCode
     */
    public String getTermsOfDeliveryCode() {
        return termsOfDeliveryCode;
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
        return termsOfDeliveryDesc;
    }

    /**
     * @param termsOfDeliveryDesc the termsOfDeliveryDesc to set
     */
    public void setTermsOfDeliveryDesc(String termsOfDeliveryDesc) {
        this.termsOfDeliveryDesc = termsOfDeliveryDesc;
    }

    /**
     * @return the userAddNo
     */
    public String getUserAddNo() {
        return userAddNo;
    }

    /**
     * @param userAddNo the userAddNo to set
     */
    public void setUserAddNo(String userAddNo) {
        this.userAddNo = userAddNo;
    }

    public long getInvoiceLineNumber() {
        return this.invoiceLineNumber;
    }

    public void setInvoiceLineNumber(Long invoiceLineNumber) {
        this.invoiceLineNumber = invoiceLineNumber;
    }

    public String getMxNiu() {
        return this.mxniu;
    }

    public void setMxNiu(String mxniu) {
        this.mxniu = mxniu;
    }

}
