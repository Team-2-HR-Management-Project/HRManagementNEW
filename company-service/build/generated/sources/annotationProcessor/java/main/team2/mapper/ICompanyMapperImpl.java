package team2.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import team2.dto.request.ActivateCompanyRequestDto;
import team2.dto.request.CreateRequestDto;
import team2.dto.request.UpdateRequestDto;
import team2.dto.response.CompanyDetailResponseDto;
import team2.dto.response.SummaryResponseDto;
import team2.repository.entity.Company;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-08T20:12:38+0300",
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
    public CompanyDetailResponseDto toDetailResponseDto(Company company) {
        if ( company == null ) {
            return null;
        }

        CompanyDetailResponseDto.CompanyDetailResponseDtoBuilder companyDetailResponseDto = CompanyDetailResponseDto.builder();

        companyDetailResponseDto.id( company.getId() );
        companyDetailResponseDto.name( company.getName() );
        companyDetailResponseDto.title( company.getTitle() );
        companyDetailResponseDto.taxNumber( company.getTaxNumber() );
        companyDetailResponseDto.taxOffice( company.getTaxOffice() );
        companyDetailResponseDto.phone( company.getPhone() );
        companyDetailResponseDto.address( company.getAddress() );
        companyDetailResponseDto.email( company.getEmail() );
        companyDetailResponseDto.numberOfEmployees( company.getNumberOfEmployees() );
        companyDetailResponseDto.dateOfEstablishment( company.getDateOfEstablishment() );
        companyDetailResponseDto.dateOfContract( company.getDateOfContract() );
        companyDetailResponseDto.contractExpiryDate( company.getContractExpiryDate() );
        companyDetailResponseDto.logo( company.getLogo() );

        return companyDetailResponseDto.build();
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
