package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.OwnerDTO;

@Repository
public class OwnerDAOImpl extends BaseDAOImpl<OwnerDTO> implements OwnerDAOInt{

	@Override
	protected List<Predicate> getWhereClause(OwnerDTO dto, CriteriaBuilder builder, Root<OwnerDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getName())) {

			whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
		}
		if (isNotNull(dto.getDob())) {

			whereCondition.add(builder.equal(qRoot.get("dob"), dto.getDob()));
		}
		if (!isEmptyString(dto.getVehicleId())) {

			whereCondition.add(builder.like(qRoot.get("vehicleId"), dto.getVehicleId() + "%"));
		}
		
		if (isNotNull(dto.getInsuranceAmount())) {

			whereCondition.add(builder.equal(qRoot.get("insuranceAmount"), dto.getInsuranceAmount() ));
		}
		return whereCondition;
	}

	@Override
	public Class<OwnerDTO> getDTOClass() {
		// TODO Auto-generated method stub
		return OwnerDTO.class;
	}

}
