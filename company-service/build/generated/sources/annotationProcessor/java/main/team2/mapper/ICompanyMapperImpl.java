package team2.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import team2.dto.request.ActivateCompanyRequestDto;
import team2.dto.request.CreateRequestDto;
import team2.dto.request.UpdateRequestDto;
import team2.dto.response.DetailResponseDto;
import team2.dto.response.SummaryResponseDto;
import team2.repository.entity.Company;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-29T11:33:39+0300",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class ICompanyMapperImpl implements ICompanyMapper {

    @Override
    public Company toCompany(CreateRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Company.CompanyBuilder company = Company.builder();

        company.name( dto.getName() );
        company.title( dto.getTitle() );
        company.phone( dto.getPhone() );
        company.address( dto.getAddress() );
        company.email( dto.getEmail() );

        return company.build();
    }

    @Override
    public Company toCompany(UpdateRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Company.CompanyBuilder company = Company.builder();

        company.id( dto.getId() );
        company.phone( dto.getPhone() );
        company.address( dto.getAddress() );
        company.numberOfEmployees( dto.getNumberOfEmployees() );
        company.dateOfContract( dto.getDateOfContract() );
        company.contractExpiryDate( dto.getContractExpiryDate() );
        company.logo( dto.getLogo() );

        return company.build();
    }

    @Override
    public SummaryResponseDto toSummaryResponseDto(Company company) {
        if ( company == null ) {
            return null;
        }

        SummaryResponseDto.SummaryResponseDtoBuilder summaryResponseDto = SummaryResponseDto.builder();

        summaryResponseDto.id( company.getId() );
        summaryResponseDto.name( company.getName() );
        summaryResponseDto.title( company.getTitle() );
        summaryResponseDto.phone( company.getPhone() );
        summaryResponseDto.address( company.getAddress() );
        summaryResponseDto.email( company.getEmail() );

        return summaryResponseDto.build();
    }

    @Override
    public DetailResponseDto toDetailResponseDto(Company company) {
        if ( company == null ) {
            return null;
        }

        DetailResponseDto.DetailResponseDtoBuilder detailResponseDto = DetailResponseDto.builder();

        detailResponseDto.id( company.getId() );
        detailResponseDto.name( company.getName() );
        detailResponseDto.title( company.getTitle() );
        detailResponseDto.taxNumber( company.getTaxNumber() );
        detailResponseDto.taxOffice( company.getTaxOffice() );
        detailResponseDto.phone( company.getPhone() );
        detailResponseDto.address( company.getAddress() );
        detailResponseDto.email( company.getEmail() );
        detailResponseDto.numberOfEmployees( company.getNumberOfEmployees() );
        detailResponseDto.dateOfEstablishment( company.getDateOfEstablishment() );
        detailResponseDto.dateOfContract( company.getDateOfContract() );
        detailResponseDto.contractExpiryDate( company.getContractExpiryDate() );
        detailResponseDto.logo( company.getLogo() );

        return detailResponseDto.build();
    }

    @Override
    public Company toCompany(ActivateCompanyRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Company.CompanyBuilder company = Company.builder();

        company.id( dto.getId() );
        company.taxNumber( dto.getTaxNumber() );
        company.taxOffice( dto.getTaxOffice() );
        company.dateOfEstablishment( dto.getDateOfEstablishment() );
        company.dateOfContract( dto.getDateOfContract() );
        company.contractExpiryDate( dto.getContractExpiryDate() );

        return company.build();
    }
}
