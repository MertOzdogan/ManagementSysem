package com.mert.managementsystem.services;

public class ServiceFactory {

	public static <T> Service getService(Class<T> className) {

		if (className.getSimpleName().equals("ManagementService"))
			return ManagementService.getINSTANCE();
		return null;
	}

}
