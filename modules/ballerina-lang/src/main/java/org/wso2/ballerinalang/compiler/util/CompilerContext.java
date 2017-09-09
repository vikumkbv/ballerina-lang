/*
*  Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing,
*  software distributed under the License is distributed on an
*  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
*  KIND, either express or implied.  See the License for the
*  specific language governing permissions and limitations
*  under the License.
*/
package org.wso2.ballerinalang.compiler.util;


import java.util.HashMap;
import java.util.Map;

/**
 * @since 0.94
 */
public class CompilerContext {

    private Map<Key<?>, Object> props = new HashMap<>();
    private Map<Class<?>, Object> objects = new HashMap<>();

    public CompilerContext() {
    }

    public <V> void put(Key<V> key, V value) {
        props.put(key, value);
    }

    @SuppressWarnings("unchecked")
    public <V> V get(Key<V> key) {
        return (V) props.get(key);
    }

    public <V> void put(Class<V> clazz, V value) {
        objects.put(clazz, value);
    }

    @SuppressWarnings("unchecked")
    public <V> V get(Class<V> clazz) {
        return (V) objects.get(clazz);
    }

    /**
     * @param <K> key
     * @since 0.94
     */
    public static class Key<K> {
    }
}
