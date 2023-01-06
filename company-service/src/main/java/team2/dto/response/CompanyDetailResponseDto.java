package team2.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyDetailResponseDto {

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
}
