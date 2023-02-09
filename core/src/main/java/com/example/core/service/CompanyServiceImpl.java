package com.example.core.service;

import com.example.core.exceptions.CompanyNotFoundException;
import com.example.db.entity.Company;
import com.example.db.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService{

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(
            CompanyRepository companyRepository
    ) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    public Page<Company> getAllPageable(Pageable pageable) {
        return companyRepository.findAll(pageable);
    }

    public Company getById(Long id) {
        return companyRepository.findById(id).orElseThrow(CompanyNotFoundException::new);
    }

    @Override
    public List<Company> findAllUserCompaniesByUserId(Long userId) {
        return null; //TODO логика возврата всех компаний юзера
    }

    @Override
    public List<Company> findAllUserIsAdminCompaniesByUserId(Long userId) {
        return null; //TODO логика возврата всех компаний где юзер является админом
    }

    @Override
    public Company addCompany(Company company) {
        return null; //TODO логика добавления компании и мб валидация
    }

    @Override
    public Company updateCompany(Company company, Long id) {
        return null; //TODO логика обновления компании и мб валидация
    }

    @Override
    public Company deleteCompanyById(Long id) {
        return null; //TODO логика удаления компании
    }

    @Override
    public Company addUserToCompanyByIds(Long userId, Long companyId) {
        return null; //TODO логика добавления юзера в компанию
    }
}
