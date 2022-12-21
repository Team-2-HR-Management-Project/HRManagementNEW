package team2.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import team2.dto.request.ActivateCompanyRequestDto;
import team2.dto.request.CreateRequestDto;
import team2.dto.request.UpdateRequestDto;
import team2.dto.response.DetailResponseDto;
import team2.dto.response.SummaryResponseDto;
import team2.repository.entity.Company;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ICompanyMapper {

    ICompanyMapper INSTANCE = Mappers.getMapper(ICompanyMapper.class);

    Company toCompany(final CreateRequestDto dto);
    Company toCompany(final UpdateRequestDto dto);
    SummaryResponseDto toSummaryResponseDto(final Company company);
    DetailResponseDto toDetailResponseDto(final Company company);
    Company toCompany(final ActivateCompanyRequestDto dto);
}
