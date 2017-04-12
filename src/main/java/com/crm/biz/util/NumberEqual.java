/**
 * xf9-gc-biz 
 * NumberEqual.java 
 * com.xf9.gc.biz.util 
 * TODO  
 * @author dolphin
 * @date   2015年10月29日 下午5:37:48 
 * @Copyright 2015, 唯创国际 幸福9号 All Rights Reserved. 
 * @version   1.0
 */

package com.crm.biz.util;

/**
 * ClassName:NumberEqual <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月29日 下午5:37:48 <br/>
 * 
 * @author dolphin
 * @version 1.0
 * @since JDK 1.7
 * @see
 */
public class NumberEqual {

	public static boolean equals(Integer a, Integer b)
	{
		if (a == null) {
			return b == null;
		}
		return b != null && b.intValue() == a.intValue();
	}

	public static boolean equals(Byte a, Byte b)
	{
		if (a == null) {
			return b == null;
		}
		return b != null && b.byteValue() == a.byteValue();
	}

	public static boolean equals(Long a, Long b)
	{
		if (a == null) {
			return b == null;
		}
		return b != null && b.longValue() == a.longValue();
	}
}
