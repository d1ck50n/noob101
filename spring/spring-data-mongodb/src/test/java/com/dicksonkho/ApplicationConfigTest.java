package com.dicksonkho;

import com.dicksonkho.config.MongoConfig;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Dickson Kho May 4, 2015
 */
public class ApplicationConfigTest {

    @Test
	public void bootstrapAppFromJavaConfig() {

		ApplicationContext context = new AnnotationConfigApplicationContext(MongoConfig.class);
		assertThat(context, is(notNullValue()));
	}

}
