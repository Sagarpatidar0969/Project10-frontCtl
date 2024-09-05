package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.OrderDTO;

@Repository
public class OrderDAOImpl extends BaseDAOImpl<OrderDTO> implements OrderDAOInt{

	@Override
	protected List<Predicate> getWhereClause(OrderDTO dto, CriteriaBuilder builder, Root<OrderDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		
		if (isNotNull(dto.getDate())) {

			whereCondition.add(builder.equal(qRoot.get("date"), dto.getDate()));
		}
		if (!isEmptyString(dto.getProduct())) {

			whereCondition.add(builder.like(qRoot.get("product"), dto.getProduct() ));
		}
		
		if (isNotNull(dto.getAmount())) {

			whereCondition.add(builder.equal(qRoot.get("amount"), dto.getAmount() ));
		}
		if (isNotNull(dto.getQuantity())) {

			whereCondition.add(builder.equal(qRoot.get("quantity"), dto.getQuantity() ));
		}
		return whereCondition;
	}

	@Override
	public Class<OrderDTO> getDTOClass() {
		// TODO Auto-generated method stub
		return OrderDTO.class;
	}

}
