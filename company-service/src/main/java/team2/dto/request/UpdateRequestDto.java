package team2.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateRequestDto {

    private Long id;
    private String phone;
    private String address;
    private String logo;
    private Long dateOfContract;
    private Long contractExpiryDate;
    private Long numberOfEmployees;
}
