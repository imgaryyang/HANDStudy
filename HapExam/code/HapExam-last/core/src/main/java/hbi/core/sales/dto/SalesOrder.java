package hbi.core.sales.dto;

import com.hand.hap.system.dto.BaseDTO;
import hbi.core.companys.dto.OrgCompanys;
import hbi.core.customers.dto.ArCustomers;
import hbi.core.headerLine.dto.OmOrderHeaders;
import hbi.core.headerLine.dto.OmOrderLines;
import hbi.core.inventoryItems.dto.InvInventoryItems;

import java.util.Date;

/**
 * @author Create By legend
 * @date 2019/4/19 16:16
 */
public class SalesOrder  {
    //extends BaseDTO
    //直接放对象
    /*private OrgCompanys orgCompanys;
    private ArCustomers arCustomers;
    private InvInventoryItems invInventoryItems;
    private OmOrderHeaders omOrderHeaders;
    private OmOrderLines omOrderLines;*/

    //存储具体属性
    private Long headerId;
    private Long companyId;
    private String companyName;
    private Long customerId;
    private String customerName;
    private Long inventoryItemId;
    private String orderNumber;
    private Date orderDate;
    private String orderStatus;
    private Long price;

    public Long getHeaderId() {
        return headerId;
    }

    public void setHeaderId(Long headerId) {
        this.headerId = headerId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(Long inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public SalesOrder(Long headerId, Long companyId, String companyName, Long customerId, String customerName, Long inventoryItemId, String orderNumber, Date orderDate, String orderStatus, Long price) {
        this.headerId = headerId;
        this.companyId = companyId;
        this.companyName = companyName;
        this.customerId = customerId;
        this.customerName = customerName;
        this.inventoryItemId = inventoryItemId;
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.price = price;
    }

    @Override
    public String toString() {
        return "SalesOrder{" +
                "headerId=" + headerId +
                ", companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", inventoryItemId=" + inventoryItemId +
                ", orderNumber='" + orderNumber + '\'' +
                ", orderDate=" + orderDate +
                ", orderStatus='" + orderStatus + '\'' +
                ", price=" + price +
                '}';
    }
}
