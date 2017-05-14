package cargument.dantomdev.com.cargument.repository;

import javax.inject.Singleton;

import cargument.dantomdev.com.cargument.repositoy.MemoryRepository;
import cargument.dantomdev.com.cargument.repositoy.Repository;
import dagger.Module;
import dagger.Provides;

@Module
public class TestRepositoryModule {

	@Singleton
	@Provides
	public Repository provideRepository() {
		return new MemoryRepository();
	}
}