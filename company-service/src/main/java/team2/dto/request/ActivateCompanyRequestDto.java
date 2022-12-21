package team2.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActivateCompanyRequestDto {

    private Long id;
    private String taxNumber;
    private String taxOffice;
    private Long dateOfEstablishment;
    private Long dateOfContract;
    private Long contractExpiryDate;


}
