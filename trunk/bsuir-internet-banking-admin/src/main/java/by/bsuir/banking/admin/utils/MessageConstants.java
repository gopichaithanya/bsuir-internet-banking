package by.bsuir.banking.admin.utils;

public class MessageConstants {
	
	public static final String MODEL_BEAN_CREATED = "Model bean created";
	public static final String SECURITY_TOKEN_OBTAINED = "Security token obtained fro user";
	public static final String USER_AUTH_FAILED_CLIENT = "User authentication failed on client";
	public static final String OBJECT_INSTANCE_SAVED = "Object instance has been saved to database";
	public static final String USER_LOGGED_OUT = "User logged out. Session invalidated";
	public static final String ADMIN_SERVICE_CREATED = "Administrator service was instantiated";
	public static final String OPERATOR_SERVICE_CREATED = "Operator service was instantiated";
	public static final String CURRENCY_SERVICE_CREATED = "Currency service was instantiated";
	public static final String USER_AUTH_FAILED_SERVER = "Authentication failed on server";
	public static final String SESSION_IS_NULL = "Session is null for some reasons";
	public static final String AUTHORIZATION_ERROR = "Authorization error";
	public static final String NOT_AUTHENTICATED_REASON = "User has not been authenticated";
	public static final String WRONG_ROLE_REASON = "User is not authorized for this action (wrong role)";
	public static final String FORM_VALIDATION_ERROR = "Object was not created/updated due to validation errors";
	public static final String OBJECT_SAVING_FAILED_ON_SERVER = "Object instance was not created/updated on server";
	public static final String SERVICE_ERROR = "Operation cannot be completed because of service error";
	public static final String GETTING_OBJECT_FAILED_ON_SERVER = "Service could not retreive requested object";
	public static final String DELETING_OBJECT_FAILED_ON_SERVER = "Service could not remove requested object";
	
	/*
	 * Session attributes
	 */
	public static final String USER_ATTR = "user";
	
	/*
	 * Entities
	 */
	public static final String ADMIN_ENTITY = "administrator";
	public static final String OPERATOR_ENTITY = "operator";
	public static final String CLIENT_ENTITY = "client";
	public static final String PASSPORT_ENTITY = "passport";
	
	/*
	 * Roles (temporary)
	 */
	public static final String ADMIN_ROLE = "Administrator";
	public static final String OPERATOR_ROLE = "Operator";
	
	/*
	 * Common views
	 */
	public static String AUTH_FAILED_VIEW = "/auth/failed";
	public static String ERROR_VIEW = "/error";
	
}
