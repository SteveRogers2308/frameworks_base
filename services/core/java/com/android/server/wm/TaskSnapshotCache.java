/*
 * Copyright (C) 2016 The Android Open Source Project
 *
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
 * limitations under the License
 */

package com.android.server.wm;

import android.annotation.Nullable;
import android.graphics.GraphicBuffer;
import android.util.ArrayMap;

/**
 * Caches snapshots. See {@link TaskSnapshotController}.
 * <p>
 * Access to this class should be guarded by the global window manager lock.
 */
class TaskSnapshotCache {

    private final ArrayMap<Task, GraphicBuffer> mCache = new ArrayMap<>();

    void putSnapshot(Task task, GraphicBuffer snapshot) {
        mCache.put(task, snapshot);
    }

    @Nullable GraphicBuffer getSnapshot(Task task) {
        return mCache.get(task);
    }
}
