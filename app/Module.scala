import com.google.inject.AbstractModule

class Module extends AbstractModule{
  override def configure() = {
    bind(classOf[repositories.PajakMasukanRepository]).to(classOf[repositories.impl.PajakMasukanRepositoryImpl])
    bind(classOf[services.PajakMasukanService]).to(classOf[services.PajakMasukanImpl.PajakMasukanServiceImpl])
  }
}
