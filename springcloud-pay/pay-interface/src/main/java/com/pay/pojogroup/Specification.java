package com.pay.pojogroup;


import com.pay.pojo.TbSpecification;
import com.pay.pojo.TbSpecificationOption;

import java.io.Serializable;
import java.util.List;

/*
* 规格组合实体类
* */
public class Specification implements Serializable{
   private TbSpecification specification;

   private List<TbSpecificationOption> specificationOptionList;

    @Override
    public String toString() {
        return "Specification{" +
                "specification=" + specification +
                ", specificationOptionList=" + specificationOptionList +
                '}';
    }

    public TbSpecification getSpecification() {
        return specification;
    }

    public void setSpecification(TbSpecification specification) {
        this.specification = specification;
    }

    public List<TbSpecificationOption> getSpecificationOptionList() {
        return specificationOptionList;
    }

    public void setSpecificationOptionList(List<TbSpecificationOption> specificationOptionList) {
        this.specificationOptionList = specificationOptionList;
    }
}
