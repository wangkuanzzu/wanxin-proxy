package com.qb.ad.common.util;

import java.net.URLDecoder;

/**
 * @author: liyifan
 * @date: 2019/5/11
 * @description:
 */
public class URLDecoderUtil {

	private static final String encod = "UTF-8";

	public static String decoder(String providerNo, String decodeProviderNo, String context) throws Exception {
		if (decodeProviderNo.indexOf(providerNo) < 0) {
			context = URLDecoder.decode(context, encod);
		}
		return context;
	}

	public static void main(String[] args) {
		System.out.println("12311".indexOf("1"));
	}
}
