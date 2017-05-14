package cargument.dantomdev.com.cargument;

import javax.inject.Singleton;

import cargument.dantomdev.com.cargument.interactor.InteractorModule;
import cargument.dantomdev.com.cargument.mock.MockNetworkModule;
import cargument.dantomdev.com.cargument.repository.TestRepositoryModule;
import dagger.Component;

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class, TestRepositoryModule.class})
public interface TestComponent extends CargumentApplicationComponent {
}
