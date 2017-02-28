package dao;

import model.Company;

/**
 * Created by Perevoznyk Pavel on 17.02.2017.
 * V 1.0a
 */
public interface CompanyDAO extends GenericDAO<Company, Long> {
    public Company findCompanyByName(String companyName);
}
