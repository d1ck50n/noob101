package com.poc.activemq.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
//{
//    "employeeFirstName": "shine",
//    "employeeFullName": "shinemtest",
//    "employeeId": "129",
//    "employeeLastName": "test",
//    "employeeMiddleName": "m"
//}
@Getter @Setter @NoArgsConstructor @ToString
public class Employee implements Serializable {
    private static final long serialVersionUID = 300002228479017363L;

    private String employeeId;
    private String employeeFullName;
    private String employeeFirstName;
    private String employeeMiddleName;
    private String employeeLastName;

}
