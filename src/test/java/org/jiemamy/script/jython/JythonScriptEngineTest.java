/*
 * Copyright 2007-2011 Jiemamy Project and the Others.
 * Created on 2011/01/15
 *
 * This file is part of Jiemamy.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.jiemamy.script.jython;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

import com.google.common.collect.Maps;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.CharEncoding;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * {@link JythonScriptEngine}のテストクラス。
 * 
 * @version $Id$
 * @author daisuke
 */
public class JythonScriptEngineTest {
	
	private JythonScriptEngine engine;
	

	/**
	 * テストを初期化する。
	 * 
	 * @throws Exception 例外が発生した場合
	 */
	@Before
	public void setUp() throws Exception {
		engine = new JythonScriptEngine();
	}
	
	/**
	 * execの例（未使用）
	 * 
	 * @throws Exception 例外が発生した場合
	 */
	@Test
	@Ignore
	public void test01() throws Exception {
		PrintStream saved = System.out;
		PrintStream ps = null;
		ByteArrayOutputStream baos = null;
		try {
			baos = new ByteArrayOutputStream();
			ps = new PrintStream(baos);
			System.setOut(ps);
			engine.process(null, "print 'Hello!'");
		} finally {
			System.setOut(saved);
			IOUtils.closeQuietly(ps);
		}
		assertThat(baos.toString(CharEncoding.UTF_8), is("Hello!\n"));
	}
	
	/**
	 * 単純な計算式の評価。
	 * 
	 * @throws Exception 例外が発生した場合
	 */
	@Test
	public void test02_単純な計算式の評価() throws Exception {
		String result = engine.process(null, "19 + 78");
		assertThat(result, is("97"));
	}
	
	/**
	 * 単純な変数を渡して評価。
	 * 
	 * @throws Exception 例外が発生した場合
	 */
	@Test
	public void test03_単純な変数を渡して評価() throws Exception {
		Map<String, Object> env = Maps.newHashMap();
		env.put("foo", 3);
		env.put("bar", 4);
		String result = engine.process(env, "foo * bar");
		assertThat(result, is("12"));
	}
	
	/**
	 * Beanを渡して評価。
	 * 
	 * @throws Exception 例外が発生した場合
	 */
	@Test
	public void test04_Beanを渡して評価() throws Exception {
		Map<String, Object> env = Maps.newHashMap();
		TestBean bean = new TestBean("jiemamy!", 3);
		env.put("bean", bean);
		String result = engine.process(env, "bean.foo * bean.bar");
		assertThat(result, is("jiemamy!jiemamy!jiemamy!"));
	}
}
