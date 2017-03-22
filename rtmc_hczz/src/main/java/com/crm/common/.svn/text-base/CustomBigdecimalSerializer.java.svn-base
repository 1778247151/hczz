package com.crm.common;

import java.io.IOException;
import java.math.BigDecimal;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
/**
 * 
 * 
 * CustomBigdecimalSerializer:自定义返回JSON bigdecimal  保留两位小数
 *
 * @author  yumaochun
 * @date    2016年8月12日
 * @version jdk1.8
 *
 */
public class CustomBigdecimalSerializer extends JsonSerializer<BigDecimal> {

	@Override
	public void serialize(BigDecimal value, JsonGenerator jsonGenerator, SerializerProvider arg2)
			throws IOException, JsonProcessingException {
		BigDecimal b2 = value;
		b2=b2.setScale(2, BigDecimal.ROUND_HALF_UP);
		jsonGenerator.writeString(b2.toString());  
		//使用：在get属性字段上加上注解（@JsonSerialize(using = CustomBigdecimalSerializer.class) ）
	}
}

