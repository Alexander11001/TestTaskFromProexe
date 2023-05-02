package co.proexe.di

import android.content.Context
import android.content.SharedPreferences
import co.proexe.data.infrastructure.SharedPreferencesUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PreferenceModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("proexe.preferences", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideSharedPreferencesUtil(sharedPreferences: SharedPreferences): SharedPreferencesUtil {
        return SharedPreferencesUtil(sharedPreferences)
    }

}