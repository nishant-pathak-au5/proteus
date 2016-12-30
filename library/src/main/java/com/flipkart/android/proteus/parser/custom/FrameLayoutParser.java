/*
 * Copyright 2016 Flipkart Internet Pvt. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.flipkart.android.proteus.parser.custom;

import android.view.ViewGroup;

import com.flipkart.android.proteus.Layout;
import com.flipkart.android.proteus.parser.Attributes;
import com.flipkart.android.proteus.parser.BaseTypeParser;
import com.flipkart.android.proteus.parser.ParseHelper;
import com.flipkart.android.proteus.parser.WrappableParser;
import com.flipkart.android.proteus.processor.StringAttributeProcessor;
import com.flipkart.android.proteus.toolbox.Styles;
import com.flipkart.android.proteus.view.ProteusAspectRatioFrameLayout;
import com.flipkart.android.proteus.view.ProteusView;
import com.flipkart.android.proteus.view.custom.AspectRatioFrameLayout;
import com.google.gson.JsonObject;


/**
 * Created by kiran.kumar on 12/05/14.
 */
public class FrameLayoutParser<T extends AspectRatioFrameLayout> extends WrappableParser<T> {

    public FrameLayoutParser(BaseTypeParser<T> parentParser) {
        super(parentParser);
    }

    @Override
    public ProteusView createView(ViewGroup parent, Layout layout, JsonObject data, Styles styles, int index) {
        return new ProteusAspectRatioFrameLayout(parent.getContext());
    }

    @Override
    protected void registerAttributeProcessors() {
        super.registerAttributeProcessors();
        addAttributeProcessor(Attributes.FrameLayout.HeightRatio, new StringAttributeProcessor<T>() {
            @Override
            public void handle(T view, String value) {
                view.setAspectRatioHeight(ParseHelper.parseInt(value));

            }
        });
        addAttributeProcessor(Attributes.FrameLayout.WidthRatio, new StringAttributeProcessor<T>() {
            @Override
            public void handle(T view, String value) {
                view.setAspectRatioWidth(ParseHelper.parseInt(value));

            }
        });
    }
}
