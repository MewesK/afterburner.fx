package com.airhacks.afterburner.injection.weld.topgun;

import com.airhacks.afterburner.views.FXMLView;
import javafx.util.Callback;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/*
 * #%L
 * afterburner.fx
 * %%
 * Copyright (C) 2013 Adam Bien
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

/**
 *
 * @author Mewes Kochheim
 */
public class TopgunView extends FXMLView {

    @Override
    public Callback<Class<?>, Object> getControllerFactory() {
        return (Class<?> clazz) -> {
            WeldContainer weldContainer = new Weld().initialize();
            return weldContainer.instance().select(clazz).get();
        };
    }
}
