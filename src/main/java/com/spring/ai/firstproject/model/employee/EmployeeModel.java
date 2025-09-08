package com.spring.ai.firstproject.model.employee;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employees")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String mobile;
    private String address;
    private String username;
    private String password;
    @Column(name = "user_role_id")
    private Long userRoleId;
    @Getter(AccessLevel.NONE)
    @Column(name = "created_on")
    private String createdOn;

    @Column(name = "created_on_gmt")
    private String createdOnGmt;
    @Column(name = "employee_no")
    private String employeeNo;
    @Column(name = "salutation_id")
    private Long salutationId;
    private String dob;
    @Column(name = "gender_id")
    private Long genderId;
    @Column(name = "blood_group_id")
    private Long bloodGroupId;
    @Column(name = "department_id")
    private Long departmentId;
    @Column(name = "designation_id")
    private Long designationId;
    @Column(name = "material_status_id")
    private Long materialStatusId;
    @Column(name = "biomatrix_code")
    private String biomatricCode;
    @Column(name = "candidate_photo")
    private String candidatePhoto;
    @Column(name = "candidate_sig")
    private String candidateSig;
    @Column(name = "f_name")
    private String fName;
    @Column(name = "f_mobile")
    private String fMobile;
    @Column(name = "f_occupation_id")
    private Long foccupationId;
    @Column(name = "f_qualification_id")
    private Long fqualificationId;
    @Column(name = "m_name")
    private String mName;
    @Column(name = "m_mobile")
    private String mMobile;
    @Column(name = "m_occupation_id")
    private Long moccupationid;
    @Column(name = "m_qualification_id")
    private Long mqualificationid;
    @Column(name = "s_name")
    private String sname;
    @Column(name = "s_mobile")
    private String smobile;
    @Column(name = "s_occupation_id")
    private Long soccupationId;
    @Column(name = "s_qualification_id")
    private Long squalificationId;
    @Column(name = "c_address")
    private String cAddress;
    @Column(name = "c_country_id")
    private Long cCountryId;
    @Column(name = "c_state_id")
    private Long cStateId;
    @Column(name = "c_city_id")
    private Long cCityId;
    @Column(name = "c_pincode")
    private Long cPincode;
    @Column(name = "p_address")
    private String pAddress;
    @Column(name = "p_country_id")
    private Long pCountryId;
    @Column(name = "p_state_id")
    private Long pStateId;
    @Column(name = "p_city_id")
    private Long pCityId;
    @Column(name = "p_pincode")
    private Long pPincode;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "resign_date")
    private String resignDate;
    @Column(name = "resign_reason")
    private Long resignReason;
    @Column(name = "resign_saved_by")
    private Long resignSavedBy;
    @Column(name = "joining_date")
    private String joiningDate;
    @Column(name="is_delete")
    private Boolean isDelete;
    @Column(name="country_code")
    private String countryCode;

}
