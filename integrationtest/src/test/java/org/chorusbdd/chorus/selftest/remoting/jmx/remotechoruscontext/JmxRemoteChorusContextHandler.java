/**
 * MIT License
 *
 * Copyright (c) 2019 Chorus BDD Organisation.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.chorusbdd.chorus.selftest.remoting.jmx.remotechoruscontext;

import org.chorusbdd.chorus.annotations.Handler;
import org.chorusbdd.chorus.annotations.Step;
import org.chorusbdd.chorus.context.ChorusContext;
import org.chorusbdd.chorus.util.assertion.ChorusAssert;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: Nick Ebbutt
 * Date: 14/06/12
 * Time: 09:21
 */
@Handler("Remote Chorus Context Handler")
public class JmxRemoteChorusContextHandler extends ChorusAssert {

    @Step("I can call a step method exported by the handler")
    public void canCallAMethod() {
    }

    @Step("I can access the context variable (.*)")
    public Object canSeeAContextVariableRemotely(String variableName) {
        ChorusContext c = ChorusContext.getContext();
        Object o = c.get(variableName);
        return o.toString() + ":" + o.getClass().getSimpleName();
    }

    @Step("the value of variable (.*) is (.*)")
    public void checkValueOfVar(String variableName, String value) {
        ChorusContext c = ChorusContext.getContext();
        Object o = c.get(variableName);
        assertEquals("Value should be " + value + " was " + o, value, o);
    }

    @Step("I set the context variable (.*) to (.*)")
    public void setAContextVariable(String variableName, Object value) {
        ChorusContext c = ChorusContext.getContext();
        c.put(variableName, value);
    }

    @Step("I create a context map (.*)")
    public void createContextMap(String variableName) {
        ChorusContext c = ChorusContext.getContext();
        HashMap myMap = new HashMap();
        myMap.put("one", "one");
        myMap.put("two", "two");
        myMap.put("three", "three");
        c.put(variableName, myMap);
    }
}