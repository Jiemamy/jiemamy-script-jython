/*
 * Copyright 2007-2012 Jiemamy Project and the Others.
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

import java.util.Map;
import java.util.Map.Entry;

import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

import org.jiemamy.script.ScriptEngine;
import org.jiemamy.script.ScriptException;

/**
 * {@link ScriptEngine}のJython実装クラス。
 * 
 * @since 0.3
 * @version $Id$
 * @author daisuke
 */
public class JythonScriptEngine implements ScriptEngine {
	
	public String process(Map<String, Object> env, String script) throws ScriptException {
		try {
			PythonInterpreter pythonInterpreter = new PythonInterpreter();
			if (env != null) {
				for (Entry<String, Object> entry : env.entrySet()) {
					pythonInterpreter.set(entry.getKey(), entry.getValue());
				}
			}
			PyObject result = pythonInterpreter.eval(script);
			return result == null ? null : result.toString();
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
}
