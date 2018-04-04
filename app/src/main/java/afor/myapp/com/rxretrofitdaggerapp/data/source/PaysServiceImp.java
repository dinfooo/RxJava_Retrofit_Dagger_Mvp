/*
 * Copyright 2016, The Android Open Source Project
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
 * limitations under the License.
 */

/**
 * Created by Mahdi Dammak on 23/03/2018.
 */

package afor.myapp.com.rxretrofitdaggerapp.data.source;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;


import afor.myapp.com.rxretrofitdaggerapp.data.retrofitEntity.RetourJson;
import afor.myapp.com.rxretrofitdaggerapp.UserService;
import io.reactivex.Observable;

import static com.google.common.base.Preconditions.checkNotNull;

public class PaysServiceImp implements PaysServiceInterface {

    @Nullable
    private static PaysServiceImp INSTANCE = null;
    private final UserService mUserService;


    // Prevent direct instantiation.
    private PaysServiceImp(@NonNull UserService userService) {
        this.mUserService = checkNotNull(userService);
    }

    /**
     * Returns the single instance of this class, creating it if necessary.
     *
     * @return the {@link PaysServiceImp} instance
     */
    public static PaysServiceImp getInstance(@NonNull UserService userService) {
        if (INSTANCE == null) {
            INSTANCE = new PaysServiceImp(userService);
        }
        return INSTANCE;
    }

    /**
     * Used to force {@link #getInstance(UserService userService)} to create a new instance
     * next time it's called.
     */
    public static void destroyInstance() {
        INSTANCE = null;
    }


    /**
     * Gets all pays from WebService
     */
    @Override
    public Observable<RetourJson> getAllPays() {
        return mUserService.getAllPaysCodeRx();
    }
}
