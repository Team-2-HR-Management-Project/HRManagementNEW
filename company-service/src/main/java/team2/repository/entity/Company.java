package team2.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import team2.repository.enums.EStatus;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_company")
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String title;
    private String taxNumber;
    private String taxOffice;
    private String phone;
    private String address;
    private String email;
    private Long numberOfEmployees;
    private Long dateOfEstablishment;
    private Long dateOfContract;
    private Long contractExpiryDate;
    private String logo;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EStatus status=EStatus.PENDING;




}
