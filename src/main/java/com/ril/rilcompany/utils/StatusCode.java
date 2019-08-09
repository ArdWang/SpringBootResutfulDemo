package com.ril.rilcompany.utils;


public interface  StatusCode {

    interface Code{

        String CODE_SUCCESS = "200";
        String CODE_ERROR = "101";
        String CODE_SERVER_ERROR = "100";

    }

	interface User{

		String EMAIL_PASSWORD_EMPTY = "email or password is not null!";
		String EMAIL_PASSWORD_ERROR = "email or password is error!";

	}

	interface System{

	    String SYSTEM_ERROR = "System is error";

	    String PARAM_ERROR = "Param is error";

    }



}
