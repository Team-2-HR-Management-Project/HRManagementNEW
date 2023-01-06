package team2.service;

import org.springframework.stereotype.Service;
import team2.dto.request.ActivateCompanyRequestDto;
import team2.dto.request.CreateRequestDto;
import team2.dto.request.UpdateRequestDto;
import team2.dto.response.CompanyDetailResponseDto;
import team2.dto.response.SummaryResponseDto;
import team2.exception.CompanyManagerException;
import team2.exception.ErrorType;
import team2.mapper.ICompanyMapper;
import team2.repository.ICompanyRepository;
import team2.repository.entity.Company;
import team2.repository.enums.EStatus;
import team2.utility.JwtTokenManager;
import team2.utility.ServiceManager;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyService extends ServiceManager<Company, Long> {

    private final ICompanyRepository companyRepository;

    private final JwtTokenManager jwtTokenManager;
    public CompanyService(ICompanyRepository companyRepository, JwtTokenManager jwtTokenManager) {
        super(companyRepository);
        this.companyRepository = companyRepository;
        this.jwtTokenManager=jwtTokenManager;
    }
    public Boolean createCompany(CreateRequestDto dto){
        try{
            Company company = companyRepository.save(ICompanyMapper.INSTANCE.toCompany(dto));
            return true;
        }catch (Exception e){
            throw new CompanyManagerException(ErrorType.COMPANY_NOT_CREATED);
        }
    }
    public CompanyDetailResponseDto updateCompany(UpdateRequestDto dto){
        Optional<Company> company=companyRepository.findById(dto.getId());
        if(company.isPresent()){
            try{
                company.get().setPhone(dto.getPhone());
                company.get().setAddress(dto.getAddress());
                company.get().setLogo(dto.getLogo());
                company.get().setDateOfContract(dto.getDateOfContract());
                company.get().setContractExpiryDate(dto.getContractExpiryDate());
                company.get().setNumberOfEmployees(dto.getNumberOfEmployees());
                save(company.get());
                return ICompanyMapper.INSTANCE.toDetailResponseDto(company.get());
            }catch (Exception e){
                throw new CompanyManagerException(ErrorType.COMPANY_NOT_UPDATED);
            }
        }else{
            throw new CompanyManagerException(ErrorType.COMPANY_NOT_FOUND);
        }


    }
    public List<SummaryResponseDto> findAllSummary(){
        List<Company> companies = companyRepository.findAll();
        return companies.stream().map(x -> ICompanyMapper.INSTANCE.toSummaryResponseDto(x)).collect(Collectors.toList());
    }

    public CompanyDetailResponseDto seeDetail(Long id){

        Optional<Company> company=companyRepository.findOptionalById(id);
        if (company.isPresent()){
            return ICompanyMapper.INSTANCE.toDetailResponseDto(company.get());
        }else {
            throw new CompanyManagerException(ErrorType.COMPANY_NOT_FOUND);
        }

    }

    public boolean deleteUser(Long id) {
        Optional<Company> company=companyRepository.findOptionalById(id);
        if(company.isPresent()){
            company.get().setStatus(EStatus.INACTIVE);
            save(company.get());
            return true;
        }else{
            throw new CompanyManagerException(ErrorType.COMPANY_NOT_FOUND);
        }
    }

    public boolean activateUser(ActivateCompanyRequestDto dto) {
        Optional<Company> company=companyRepository.findOptionalById(dto.getId());
        if(company.isPresent()){
            company.get().setTaxNumber(dto.getTaxNumber());
            company.get().setTaxOffice(dto.getTaxOffice());
            company.get().setDateOfEstablishment(dto.getDateOfEstablishment());
            company.get().setDateOfContract(dto.getDateOfContract());
            company.get().setContractExpiryDate(dto.getContractExpiryDate());

            save(company.get());

            return true;
        }else{
            throw new CompanyManagerException(ErrorType.COMPANY_NOT_FOUND);
        }
    }


    public CompanyDetailResponseDto getById(Long id) {
        Optional<Company> company = companyRepository.findOptionalById(id);

        if (company.isPresent()) {
            return ICompanyMapper.INSTANCE.toDetailResponseDto(company.get());
        } else {
            throw new CompanyManagerException(ErrorType.COMPANY_NOT_FOUND);
        }
    }

    public CompanyDetailResponseDto findByToken(String token) {
        Optional<Long> id = jwtTokenManager.getUserId(token);
        if (id.isPresent()) {
            Optional<Company> company = companyRepository.findOptionalById(id.get());
            if (company.isPresent()) {
                return ICompanyMapper.INSTANCE.toDetailResponseDto(company.get());
            } else {
                throw new CompanyManagerException(ErrorType.COMPANY_NOT_FOUND);
            }

        } else {
            throw new CompanyManagerException(ErrorType.INVALID_TOKEN);
        }

    }
}
