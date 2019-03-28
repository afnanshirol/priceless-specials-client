package com.mastercard.priceless.common;

import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;

import com.mastercard.developer.oauth.OAuth;
import com.mastercard.developer.utils.SecurityUtils;

public class AuthorizationUtil {

	/**
	 * @param queryParam 
	 * @return
	 * @throws Exception
	 */
	public static String getAuthorizationHeader(String serviceName, String queryParam) throws Exception {
		PrivateKey signingKey = SecurityUtils.loadPrivateKey(
				"C:\\Users\\aimamuddin\\Downloads\\MCD_Sandbox_PricelessSpecial_API_Keys\\PricelessSpecial-sandbox.p12", 
				"keyalias", 
				"keystorepassword");
		
				
		String consumerKey = "GXbURmhm2Ek8QRfUhwpVrlkOxjZuvM7EcC26s983fa850c9a!f537f5a494b0436e94d2f628de0185ed0000000000000000";
		URI uri = URI.create("https://sandbox.api.mastercard.com/priceless/specials/v1/"+serviceName+queryParam);
		String method = "GET";
		String payload = "";
		Charset charset = StandardCharsets.UTF_8;
		String authHeader = OAuth.getAuthorizationHeader(uri, method, payload, charset, consumerKey, signingKey);
		return authHeader;
	}
}
