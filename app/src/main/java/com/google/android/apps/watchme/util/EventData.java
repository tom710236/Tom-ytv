/*
 * Copyright (c) 2014 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.android.apps.watchme.util;

import android.util.Log;

import com.google.api.services.youtube.model.LiveBroadcast;

/**
 * @author Ibrahim Ulukaya <ulukaya@google.com>
 *         <p/>
 *         Helper class to handle YouTube videos.
 */
public class EventData {
    private LiveBroadcast mEvent;
    private String mIngestionAddress;

    public LiveBroadcast getEvent() {
        //Log.e("getEvent()", String.valueOf(mEvent));
        return mEvent;

    }

    public void setEvent(LiveBroadcast event) {
        Log.e("setEvent()", String.valueOf(event));
        mEvent = event;

    }

    public String getId() {
        return mEvent.getId();
    }

    public String getTitle() {
        //Log.e("getTitle()",mEvent.getSnippet().getTitle());
        return mEvent.getSnippet().getTitle();

    }

    public String getThumbUri() {
        String url = mEvent.getSnippet().getThumbnails().getDefault().getUrl();
        // if protocol is not defined, pick https
        //Log.e("url",url);
        if (url.startsWith("//")) {
            url = "https:" + url;
            //Log.e("url2", String.valueOf(url));
        }
        return url;

    }

    public String getIngestionAddress() {
        //Log.e("getIngestionAddress()",mIngestionAddress);
        return mIngestionAddress;
    }

    public void setIngestionAddress(String ingestionAddress) {
        mIngestionAddress = ingestionAddress;
        //Log.e("setIngestionAddress", String.valueOf(mIngestionAddress));
    }

    public String getWatchUri() {
        //Log.e("URI","http://www.youtube.com/watch?v=" + getId());
        return "http://www.youtube.com/watch?v=" + getId();
    }

}
