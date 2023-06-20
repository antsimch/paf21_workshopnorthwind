package sg.edu.nus.iss.paf21_workshopnorthwind.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    
    private Integer id;

    private Integer employeeId;

    private Integer customerId;

    private LocalDateTime orderDate;

    private LocalDateTime shippedDate;

    private Integer shipperId;

    private String shipName;

    private String shipAddress;

    private String shipCity;

    private String shipStateProvince;

    private String shipZipPostalCode;

    private String shipCountryRegion;

    private BigDecimal shippingFee;

    private BigDecimal taxes;

    private String paymentType;

    private LocalDateTime paidDate;

    private String notes;

    private Double taxRate;

    private Integer taxStatusId;

    private Integer statusId;
}
