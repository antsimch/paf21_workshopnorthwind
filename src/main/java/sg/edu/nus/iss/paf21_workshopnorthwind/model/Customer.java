package sg.edu.nus.iss.paf21_workshopnorthwind.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    
    private int id;

    private String companyName;

    private String lastName;

    private String firstName;

    private String emailAddress;

    private String jobTitle;

    private String businessPhone;

    private String homePhone;

    private String mobilePhone;

    private String faxNumber;

    private String address;

    private String city;

    private String stateProvince;

    private String zipPostalCode;

    private String countryRegion;

    private String webPage;

    private String notes;
}
