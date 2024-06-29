package com.rays.exception;
import com.google.gson.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public @interface ValiDate {
	
	String jsonString = "{\"dob\": \"abc\"}";
	JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();
	
}
