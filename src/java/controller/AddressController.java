/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DistrictDao;
import dao.ProvinceDao;
import domain.District;
import domain.Province;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Edison
 */
@ManagedBean(name = "ad", eager = true)
@SessionScoped
public class AddressController {

    private District district = new District();
    private final Province province = new Province();

    private final List<District> districts = new ArrayList<>();

    private String provId = new String();

    public List<Province> findAllProvince() {
        return new ProvinceDao().findAll(Province.class);
    }

    public void districtInit() {
        districts.clear();
        for (District d : new DistrictDao().findAll(District.class)) {
            if (d.getProvince().getCode().equalsIgnoreCase(provId)) {
                districts.add(d);
            }
        }
    }

    public void saveProvince() {
        try {
            new ProvinceDao().create(province);
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }

    public void saveDistrict() {
        try {
            Province dis = new ProvinceDao().findOne(Province.class, provId);
            district.setProvince(dis);
            new DistrictDao().create(district);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Province getProvince() {
        return province;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public String getProvId() {
        return provId;
    }

    public void setProvId(String provId) {
        this.provId = provId;
    }

}
