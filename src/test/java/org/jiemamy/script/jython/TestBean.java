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

/**
 * テスト用Bean。
 * 
 * @version $Id$
 * @author daisuke
 */
public class TestBean {
	
	private String foo;
	
	private int bar;
	
	
	/**
	 * インスタンスを生成する。
	 * 
	 * @param foo Fooの初期値
	 * @param bar Barの初期値
	 */
	public TestBean(String foo, int bar) {
		this.foo = foo;
		this.bar = bar;
	}
	
	/**
	 * Barの値を取得する。
	 * 
	 * @return the bar
	 */
	public int getBar() {
		return bar;
	}
	
	/**
	 * Fooの値を取得する。
	 * @return the foo
	 */
	public String getFoo() {
		return foo;
	}
	
}
