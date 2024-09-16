package com.example.dependencyinjecttion_di.di
import com.example.dependencyinjecttion_di.connst.Const
import com.example.dependencyinjecttion_di.remote.datasource.Datasource
import com.example.dependencyinjecttion_di.remote.datasource.DatasourceImp
import com.example.dependencyinjecttion_di.remote.repository.ArticleRepository
import com.example.dependencyinjecttion_di.remote.repository.ArticleRepositoryImp
import com.example.dependencyinjecttion_di.remote.repository.ArticleService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }
    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Const.BASE_URL)
            .client(client)
            .build()
    }
    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ArticleService {
        return retrofit.create(ArticleService::class.java)
    }
    @Singleton
    @Provides
    fun provideDatasource(articleService: ArticleService): Datasource {
        return DatasourceImp(articleService)
    }
    @Singleton
    @Provides
    fun provideArticleRepository(datasource: Datasource): ArticleRepository {
        return ArticleRepositoryImp(datasource)
    }
}
