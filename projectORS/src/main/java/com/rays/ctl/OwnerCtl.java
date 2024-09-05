package com.rays.ctl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.OwnerDTO;
import com.rays.form.OwnerForm;
import com.rays.service.OwnerServiceInt;

@RestController
@RequestMapping(value = "Owner")
public class OwnerCtl extends BaseCtl<OwnerForm, OwnerDTO, OwnerServiceInt> {

	@GetMapping("/preload")
	public ORSResponse preload() {
		System.out.println("inside preload");
		ORSResponse res = new ORSResponse(true);
		OwnerDTO dto = new OwnerDTO();
		
		List list = new ArrayList<>();
		list.add("rj100");
		list.add( "mp09");
		//List<DropdownList> list = baseService.search(dto, userContext);
		res.addResult("ownerList", list);
		return res;
	}
	
	
	
	
	
	
}
