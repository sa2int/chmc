package io.bigtreelab.rndbox.api.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import io.bigtreelab.rndbox.api.domain.EnumModel;
import io.bigtreelab.rndbox.api.dto.EnumValueDto;

public class EnumMapper {
	private Map<String, List<EnumValueDto>> factory = new HashMap<>();

	private List<EnumValueDto> toEnumValues(Class<? extends EnumModel> e) {

		// Java8이 아닐경우
		/*
		 * List<EnumValue> enumValues = new ArrayList<>(); for (EnumModel enumType :
		 * e.getEnumConstants()) { enumValues.add(new EnumValue(enumType)); } return
		 * enumValues;
		 */

		 return Arrays.stream(e.getEnumConstants()) .map(EnumValueDto::new)
		 .collect(Collectors.toList());
		 
	}

	public void put(String key, Class<? extends EnumModel> e) {
		factory.put(key, toEnumValues(e));
	}

	public Map<String, List<EnumValueDto>> getAll() {
		return factory;
	}

	public Map<String, List<EnumValueDto>> get(String keys) {
		  // Java8이 아닐경우 
			
			  Map<String, List<EnumValueDto>> result = new LinkedHashMap<>(); 
			  for (String key: keys.split(",")) { 
				  result.put(key.trim(), factory.get(key.trim())); 
			  }
			  return result;
			 
	
			/*
			 * return Arrays .stream(keys.split(",")) .map(key -> key.trim())
			 * .collect(Collectors.toMap(Function.identity(), key -> factory.get(key)));
			 */
 
	}
	
	
	
	/**
	 * 하나의 공통코드만 조회
	 * @param keys
	 * @return
	 */
	public List<EnumValueDto> getOne(String keys) {
		  return factory.get(keys); 
	}
	

}